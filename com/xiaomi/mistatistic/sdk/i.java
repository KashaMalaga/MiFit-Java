package com.xiaomi.mistatistic.sdk;

import android.os.SystemClock;
import com.xiaomi.mistatistic.sdk.a.b;
import com.xiaomi.mistatistic.sdk.a.d;
import com.xiaomi.mistatistic.sdk.b.u;
import com.xiaomi.mistatistic.sdk.c.a;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import javax.net.ssl.HttpsURLConnection;

class i extends URLStreamHandler {
    private URLStreamHandler a;

    public i(URLStreamHandler uRLStreamHandler) {
        this.a = uRLStreamHandler;
    }

    protected URLConnection openConnection(URL url) {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Method declaredMethod = URLStreamHandler.class.getDeclaredMethod("openConnection", new Class[]{URL.class});
            declaredMethod.setAccessible(true);
            URLConnection uRLConnection = (URLConnection) declaredMethod.invoke(this.a, new Object[]{url});
            URLConnection dVar;
            if (uRLConnection instanceof HttpsURLConnection) {
                dVar = new d((HttpsURLConnection) uRLConnection);
                dVar.a(elapsedRealtime);
                return dVar;
            } else if (!(uRLConnection instanceof HttpURLConnection)) {
                return uRLConnection;
            } else {
                dVar = new b((HttpURLConnection) uRLConnection);
                dVar.a(elapsedRealtime);
                return dVar;
            }
        } catch (Exception e) {
            u.a().a(new a(url.toString(), e.getClass().getSimpleName()));
            throw new IOException();
        }
    }
}
