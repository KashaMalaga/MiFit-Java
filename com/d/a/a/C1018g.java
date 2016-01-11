package com.d.a.a;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class C1018g implements Runnable {
    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final S d;
    private int e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    public C1018g(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, S s) {
        this.a = abstractHttpClient;
        this.b = httpContext;
        this.c = httpUriRequest;
        this.d = s;
    }

    private void c() {
        if (!a()) {
            if (this.c.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            HttpResponse execute = this.a.execute(this.c, this.b);
            if (!a() && this.d != null) {
                this.d.sendResponseMessage(execute);
            }
        }
    }

    private void d() {
        int i;
        IOException iOException = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
        boolean z = true;
        while (z) {
            try {
                c();
                return;
            } catch (UnknownHostException e) {
                try {
                    boolean z2;
                    IOException iOException2;
                    IOException iOException3 = new IOException("UnknownHostException exception: " + e.getMessage());
                    if (this.e > 0) {
                        int i2 = this.e + 1;
                        this.e = i2;
                        if (httpRequestRetryHandler.retryRequest(iOException3, i2, this.b)) {
                            z2 = true;
                            iOException2 = iOException3;
                            z = z2;
                            iOException = iOException2;
                        }
                    }
                    z2 = false;
                    iOException2 = iOException3;
                    z = z2;
                    iOException = iOException2;
                } catch (Throwable e2) {
                    Throwable th = e2;
                    Log.e("AsyncHttpRequest", "Unhandled exception origin cause", th);
                    iOException = new IOException("Unhandled exception: " + th.getMessage());
                }
            } catch (NullPointerException e3) {
                iOException = new IOException("NPE in HttpClient: " + e3.getMessage());
                i = this.e + 1;
                this.e = i;
                z = httpRequestRetryHandler.retryRequest(iOException, i, this.b);
            } catch (IOException e4) {
                iOException = e4;
                if (!a()) {
                    i = this.e + 1;
                    this.e = i;
                    z = httpRequestRetryHandler.retryRequest(iOException, i, this.b);
                } else {
                    return;
                }
            }
        }
        throw iOException;
        if (z && this.d != null) {
            this.d.sendRetryMessage(this.e);
        }
    }

    private synchronized void e() {
        if (!(this.h || !this.f || this.g)) {
            this.g = true;
            if (this.d != null) {
                this.d.sendCancelMessage();
            }
        }
    }

    public boolean a() {
        if (this.f) {
            e();
        }
        return this.f;
    }

    public boolean a(boolean z) {
        this.f = true;
        this.c.abort();
        return a();
    }

    public boolean b() {
        return a() || this.h;
    }

    public void run() {
        if (!a()) {
            if (this.d != null) {
                this.d.sendStartMessage();
            }
            if (!a()) {
                try {
                    d();
                } catch (Throwable e) {
                    if (a() || this.d == null) {
                        Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", e);
                    } else {
                        this.d.sendFailureMessage(0, null, null, e);
                    }
                }
                if (!a()) {
                    if (this.d != null) {
                        this.d.sendFinishMessage();
                    }
                    this.h = true;
                }
            }
        }
    }
}
