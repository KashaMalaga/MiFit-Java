package com.d.a.a;

import android.util.Log;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.huami.android.widget.share.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class M extends C0781y {
    private static final String c = "RangeFileAsyncHttpResponseHandler";
    private long d = 0;
    private boolean e = false;

    public M(File file) {
        super(file);
    }

    public void a(HttpUriRequest httpUriRequest) {
        if (this.a.exists() && this.a.canWrite()) {
            this.d = this.a.length();
        }
        if (this.d > 0) {
            this.e = true;
            httpUriRequest.setHeader("Range", "bytes=" + this.d + "-");
        }
    }

    protected byte[] getResponseData(HttpEntity httpEntity) {
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            long contentLength = httpEntity.getContentLength() + this.d;
            FileOutputStream fileOutputStream = new FileOutputStream(b(), this.e);
            if (content != null) {
                try {
                    byte[] bArr = new byte[ChartData.d];
                    while (this.d < contentLength) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        this.d += (long) read;
                        fileOutputStream.write(bArr, 0, read);
                        sendProgressMessage((int) this.d, (int) contentLength);
                    }
                    content.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    content.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
        }
        return null;
    }

    public void sendResponseMessage(HttpResponse httpResponse) {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == 416) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null);
                }
            } else if (statusLine.getStatusCode() >= m.n) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                }
            } else if (!Thread.currentThread().isInterrupted()) {
                Header firstHeader = httpResponse.getFirstHeader("Content-Range");
                if (firstHeader == null) {
                    this.e = false;
                    this.d = 0;
                } else {
                    Log.v(c, "Content-Rnage: " + firstHeader.getValue());
                }
                sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), getResponseData(httpResponse.getEntity()));
            }
        }
    }
}
