package com.amap.api.mapcore.util;

import com.f.a.b.d.a;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;

public abstract class bu {
    int a = a.b;
    int b = a.b;
    HttpHost c = null;

    public abstract HttpEntity getEntity();

    public byte[] getEntityBytes() {
        return null;
    }

    public abstract Map<String, String> getParams();

    public abstract Map<String, String> getRequestHead();

    public abstract String getURL();

    public final void setConnectionTimeout(int i) {
        this.a = i;
    }

    public final void setProxy(HttpHost httpHost) {
        this.c = httpHost;
    }

    public final void setSoTimeout(int i) {
        this.b = i;
    }
}
