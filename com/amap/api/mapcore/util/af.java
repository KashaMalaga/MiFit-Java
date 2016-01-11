package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;

class af extends bu {
    private Map<String, String> d = new HashMap();
    private String e;
    private Map<String, String> f = new HashMap();

    af() {
    }

    void a(String str) {
        this.e = str;
    }

    void a(Map<String, String> map) {
        this.d.clear();
        this.d.putAll(map);
    }

    void b(Map<String, String> map) {
        this.f.clear();
        this.f.putAll(map);
    }

    public HttpEntity getEntity() {
        return null;
    }

    public Map<String, String> getParams() {
        return this.f;
    }

    public Map<String, String> getRequestHead() {
        return this.d;
    }

    public String getURL() {
        return this.e;
    }
}
