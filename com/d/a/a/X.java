package com.d.a.a;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class X extends C1012a {
    public X() {
        super(false, 80, 443);
    }

    public X(int i) {
        super(false, i, 443);
    }

    public X(int i, int i2) {
        super(false, i, i2);
    }

    public X(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }

    public X(boolean z, int i, int i2) {
        super(z, i, i2);
    }

    protected N a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, S s, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        s.setUseSynchronousMode(true);
        new C1018g(defaultHttpClient, httpContext, httpUriRequest, s).run();
        return new N(null);
    }
}
