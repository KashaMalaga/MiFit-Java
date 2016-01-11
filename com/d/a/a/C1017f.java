package com.d.a.a;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class C1017f extends HttpEntityWrapper {
    public C1017f(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public InputStream getContent() {
        return new GZIPInputStream(this.wrappedEntity.getContent());
    }

    public long getContentLength() {
        return -1;
    }
}
