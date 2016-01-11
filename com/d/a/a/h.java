package com.d.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.model.WeightedLatLng;
import com.huami.android.widget.share.m;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import kankan.wheel.widget.a;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

public abstract class h implements S {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpResponse";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    private Handler handler;
    private Header[] requestHeaders = null;
    private URI requestURI = null;
    private String responseCharset = DEFAULT_CHARSET;
    private boolean useSynchronousMode;

    public h() {
        setUseSynchronousMode(false);
    }

    public String getCharset() {
        return this.responseCharset == null ? DEFAULT_CHARSET : this.responseCharset;
    }

    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    public URI getRequestURI() {
        return this.requestURI;
    }

    byte[] getResponseData(HttpEntity httpEntity) {
        int i = BUFFER_SIZE;
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                long contentLength = httpEntity.getContentLength();
                if (contentLength > 2147483647L) {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
                if (contentLength > 0) {
                    i = (int) contentLength;
                }
                try {
                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
                    byte[] bArr = new byte[BUFFER_SIZE];
                    i = 0;
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        int i2 = i + read;
                        byteArrayBuffer.append(bArr, 0, read);
                        sendProgressMessage(i2, (int) (contentLength <= 0 ? 1 : contentLength));
                        i = i2;
                    }
                    C1012a.a(content);
                    return byteArrayBuffer.toByteArray();
                } catch (OutOfMemoryError e) {
                    System.gc();
                    throw new IOException("File too large to fit into available memory");
                } catch (Throwable th) {
                    C1012a.a(content);
                }
            }
        }
        return null;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    protected void handleMessage(Message message) {
        Object[] objArr;
        switch (message.what) {
            case a.i /*0*/:
                objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < FINISH_MESSAGE) {
                    Log.e(LOG_TAG, "SUCCESS_MESSAGE didn't got enough params");
                    return;
                } else {
                    onSuccess(((Integer) objArr[0]).intValue(), (Header[]) objArr[FAILURE_MESSAGE], (byte[]) objArr[START_MESSAGE]);
                    return;
                }
            case FAILURE_MESSAGE /*1*/:
                objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < PROGRESS_MESSAGE) {
                    Log.e(LOG_TAG, "FAILURE_MESSAGE didn't got enough params");
                    return;
                } else {
                    onFailure(((Integer) objArr[0]).intValue(), (Header[]) objArr[FAILURE_MESSAGE], (byte[]) objArr[START_MESSAGE], (Throwable) objArr[FINISH_MESSAGE]);
                    return;
                }
            case START_MESSAGE /*2*/:
                onStart();
                return;
            case FINISH_MESSAGE /*3*/:
                onFinish();
                return;
            case PROGRESS_MESSAGE /*4*/:
                objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < START_MESSAGE) {
                    Log.e(LOG_TAG, "PROGRESS_MESSAGE didn't got enough params");
                    return;
                }
                try {
                    onProgress(((Integer) objArr[0]).intValue(), ((Integer) objArr[FAILURE_MESSAGE]).intValue());
                    return;
                } catch (Throwable th) {
                    Log.e(LOG_TAG, "custom onProgress contains an error", th);
                    return;
                }
            case RETRY_MESSAGE /*5*/:
                objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length != FAILURE_MESSAGE) {
                    Log.e(LOG_TAG, "RETRY_MESSAGE didn't get enough params");
                    return;
                } else {
                    onRetry(((Integer) objArr[0]).intValue());
                    return;
                }
            case CANCEL_MESSAGE /*6*/:
                onCancel();
                return;
            default:
                return;
        }
    }

    protected Message obtainMessage(int i, Object obj) {
        if (this.handler != null) {
            return Message.obtain(this.handler, i, obj);
        }
        Message obtain = Message.obtain();
        if (obtain == null) {
            return obtain;
        }
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    public void onCancel() {
        Log.d(LOG_TAG, "Request got cancelled");
    }

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public void onFinish() {
    }

    public void onProgress(int i, int i2) {
        String str = LOG_TAG;
        String str2 = "Progress %d from %d (%2.0f%%)";
        Object[] objArr = new Object[FINISH_MESSAGE];
        objArr[0] = Integer.valueOf(i);
        objArr[FAILURE_MESSAGE] = Integer.valueOf(i2);
        objArr[START_MESSAGE] = Double.valueOf(i2 > 0 ? ((((double) i) * WeightedLatLng.DEFAULT_INTENSITY) / ((double) i2)) * 100.0d : -1.0d);
        Log.v(str, String.format(str2, objArr));
    }

    public void onRetry(int i) {
        String str = LOG_TAG;
        Object[] objArr = new Object[FAILURE_MESSAGE];
        objArr[0] = Integer.valueOf(i);
        Log.d(str, String.format("Request retry no. %d", objArr));
    }

    public void onStart() {
    }

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    protected void postRunnable(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (getUseSynchronousMode() || this.handler == null) {
            runnable.run();
        } else {
            this.handler.post(runnable);
        }
    }

    public final void sendCancelMessage() {
        sendMessage(obtainMessage(CANCEL_MESSAGE, null));
    }

    public final void sendFailureMessage(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        Object obj = new Object[PROGRESS_MESSAGE];
        obj[0] = Integer.valueOf(i);
        obj[FAILURE_MESSAGE] = headerArr;
        obj[START_MESSAGE] = bArr;
        obj[FINISH_MESSAGE] = th;
        sendMessage(obtainMessage(FAILURE_MESSAGE, obj));
    }

    public final void sendFinishMessage() {
        sendMessage(obtainMessage(FINISH_MESSAGE, null));
    }

    protected void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            this.handler.sendMessage(message);
        }
    }

    public final void sendProgressMessage(int i, int i2) {
        Object obj = new Object[START_MESSAGE];
        obj[0] = Integer.valueOf(i);
        obj[FAILURE_MESSAGE] = Integer.valueOf(i2);
        sendMessage(obtainMessage(PROGRESS_MESSAGE, obj));
    }

    public void sendResponseMessage(HttpResponse httpResponse) {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] responseData = getResponseData(httpResponse.getEntity());
            if (!Thread.currentThread().isInterrupted()) {
                if (statusLine.getStatusCode() >= m.n) {
                    sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                } else {
                    sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData);
                }
            }
        }
    }

    public final void sendRetryMessage(int i) {
        Object obj = new Object[FAILURE_MESSAGE];
        obj[0] = Integer.valueOf(i);
        sendMessage(obtainMessage(RETRY_MESSAGE, obj));
    }

    public final void sendStartMessage() {
        sendMessage(obtainMessage(START_MESSAGE, null));
    }

    public final void sendSuccessMessage(int i, Header[] headerArr, byte[] bArr) {
        Object obj = new Object[FINISH_MESSAGE];
        obj[0] = Integer.valueOf(i);
        obj[FAILURE_MESSAGE] = headerArr;
        obj[START_MESSAGE] = bArr;
        sendMessage(obtainMessage(0, obj));
    }

    public void setCharset(String str) {
        this.responseCharset = str;
    }

    public void setRequestHeaders(Header[] headerArr) {
        this.requestHeaders = headerArr;
    }

    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }

    public void setUseSynchronousMode(boolean z) {
        if (!z && Looper.myLooper() == null) {
            z = true;
            Log.w(LOG_TAG, "Current thread has not called Looper.prepare().Forcing synchronous mode");
        }
        if (!z && this.handler == null) {
            this.handler = new C1019i(this);
        } else if (z && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z;
    }
}
