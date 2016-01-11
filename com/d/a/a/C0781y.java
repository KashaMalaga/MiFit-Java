package com.d.a.a;

import android.content.Context;
import android.util.Log;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public abstract class C0781y extends h {
    static final /* synthetic */ boolean b = (!C0781y.class.desiredAssertionStatus() ? true : b);
    private static final String c = "FileAsyncHttpResponseHandler";
    protected final File a;

    public C0781y(Context context) {
        this.a = a(context);
    }

    public C0781y(File file) {
        if (b || file != null) {
            this.a = file;
            return;
        }
        throw new AssertionError();
    }

    protected File a(Context context) {
        if (b || context != null) {
            try {
                return File.createTempFile("temp_", "_handled", context.getCacheDir());
            } catch (Throwable th) {
                Log.e(c, "Cannot create temporary file", th);
                return null;
            }
        }
        throw new AssertionError();
    }

    public abstract void a(int i, Header[] headerArr, File file);

    public abstract void a(int i, Header[] headerArr, Throwable th, File file);

    public boolean a() {
        return (b() == null || !b().delete()) ? b : true;
    }

    protected File b() {
        if (b || this.a != null) {
            return this.a;
        }
        throw new AssertionError();
    }

    protected byte[] getResponseData(HttpEntity httpEntity) {
        int i = 0;
        if (httpEntity != null) {
            InputStream content = httpEntity.getContent();
            long contentLength = httpEntity.getContentLength();
            OutputStream fileOutputStream = new FileOutputStream(b());
            if (content != null) {
                try {
                    byte[] bArr = new byte[ChartData.d];
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1 || Thread.currentThread().isInterrupted()) {
                            C1012a.a(content);
                            fileOutputStream.flush();
                            C1012a.a(fileOutputStream);
                        } else {
                            i += read;
                            fileOutputStream.write(bArr, 0, read);
                            sendProgressMessage(i, (int) contentLength);
                        }
                    }
                    C1012a.a(content);
                    fileOutputStream.flush();
                    C1012a.a(fileOutputStream);
                } catch (Throwable th) {
                    C1012a.a(content);
                    fileOutputStream.flush();
                    C1012a.a(fileOutputStream);
                }
            }
        }
        return null;
    }

    public final void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        a(i, headerArr, th, b());
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        a(i, headerArr, b());
    }
}
