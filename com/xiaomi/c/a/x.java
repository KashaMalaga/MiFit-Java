package com.xiaomi.c.a;

import android.content.Context;
import com.d.a.a.C1012a;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

final class x implements C1085p {
    private final Lock a = new ReentrantLock();
    private O b;
    private HttpClient c;

    x() {
        HttpClient.class.getName();
    }

    private synchronized HttpClient b(O o) {
        HttpClient defaultHttpClient;
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 100);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        if (!(o == null || o.f() == null || o.g() == 0)) {
            basicHttpParams.setParameter("http.route.default-proxy", new HttpHost(o.f(), o.g()));
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        defaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        return defaultHttpClient;
    }

    public C1084o a(C1077i c1077i, C1078u c1078u, Context context) {
        this.a.lock();
        HttpClient httpClient;
        try {
            if (this.c == null) {
                this.c = b(this.b);
            }
            httpClient = this.c;
            HttpParams params = httpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, C1012a.b);
            if (c1077i != null) {
                HttpConnectionParams.setSoTimeout(params, (int) (((long) (((Integer) c1077i.b().a()).intValue() + 30)) * 1000));
            }
            O o = this.b;
            return new w(httpClient, o, c1077i, c1078u, context);
        } finally {
            httpClient = this.a;
            httpClient.unlock();
        }
    }

    public void a() {
        this.a.lock();
        try {
            if (this.c != null) {
                this.c.getConnectionManager().shutdown();
            }
            this.b = null;
            this.c = null;
            this.a.unlock();
        } catch (Throwable th) {
            this.b = null;
            this.c = null;
            this.a.unlock();
        }
    }

    public void a(O o) {
        this.a.lock();
        try {
            this.b = o;
            this.c = b(o);
        } finally {
            this.a.unlock();
        }
    }
}
