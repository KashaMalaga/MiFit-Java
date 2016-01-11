package com.d.a.a;

import android.util.Log;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class C1013b implements HttpRequestInterceptor {
    final /* synthetic */ C1012a a;

    C1013b(C1012a c1012a) {
        this.a = c1012a;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader(C1012a.f)) {
            httpRequest.addHeader(C1012a.f, C1012a.g);
        }
        for (String str : this.a.o.keySet()) {
            if (httpRequest.containsHeader(str)) {
                Header firstHeader = httpRequest.getFirstHeader(str);
                Log.d(C1012a.h, String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{str, this.a.o.get(str), firstHeader.getName(), firstHeader.getValue()}));
            }
            httpRequest.addHeader(str, (String) this.a.o.get(str));
        }
    }
}
