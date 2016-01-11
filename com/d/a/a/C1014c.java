package com.d.a.a;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class C1014c implements HttpResponseInterceptor {
    final /* synthetic */ C1012a a;

    C1014c(C1012a c1012a) {
        this.a = c1012a;
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                for (HeaderElement name : contentEncoding.getElements()) {
                    if (name.getName().equalsIgnoreCase(C1012a.g)) {
                        httpResponse.setEntity(new C1017f(entity));
                        return;
                    }
                }
            }
        }
    }
}
