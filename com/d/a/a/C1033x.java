package com.d.a.a;

import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

public abstract class C1033x extends h {
    protected static final int a = 6;
    private static final String b = "DataAsyncHttpResponseHandler";

    public static byte[] a(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        length = Math.min(i3, length - i);
        Object obj = new byte[i3];
        System.arraycopy(bArr, i, obj, 0, length);
        return obj;
    }

    public void a(byte[] bArr) {
    }

    public final void b(byte[] bArr) {
        sendMessage(obtainMessage(a, new Object[]{bArr}));
    }

    byte[] getResponseData(HttpEntity httpEntity) {
        byte[] bArr = null;
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                long contentLength = httpEntity.getContentLength();
                if (contentLength > 2147483647L) {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
                if (contentLength < 0) {
                    contentLength = PlaybackStateCompat.m;
                }
                try {
                    ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) contentLength);
                    bArr = new byte[ChartData.d];
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            break;
                        }
                        byteArrayBuffer.append(bArr, 0, read);
                        b(C1033x.a(bArr, 0, read));
                    }
                    C1012a.a(content);
                    bArr = byteArrayBuffer.toByteArray();
                } catch (OutOfMemoryError e) {
                    System.gc();
                    throw new IOException("File too large to fit into available memory");
                } catch (Throwable th) {
                    C1012a.a(content);
                }
            }
        }
        return bArr;
    }

    protected void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case a /*6*/:
                Object[] objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 1) {
                    Log.e(b, "PROGRESS_DATA_MESSAGE didn't got enough params");
                    return;
                }
                try {
                    a((byte[]) objArr[0]);
                    return;
                } catch (Throwable th) {
                    Log.e(b, "custom onProgressData contains an error", th);
                    return;
                }
            default:
                return;
        }
    }
}
