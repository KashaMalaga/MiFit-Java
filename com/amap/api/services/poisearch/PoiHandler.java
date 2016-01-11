package com.amap.api.services.poisearch;

import com.amap.api.services.core.e;
import com.amap.api.services.core.s;
import java.io.InputStream;
import java.net.Proxy;
import kankan.wheel.widget.a;

public abstract class PoiHandler<T, V> extends s<T, V> {
    public PoiHandler(T t, Proxy proxy) {
        super(t, proxy);
    }

    protected String inputStream2String(InputStream inputStream) {
        try {
            return new String(e.a(inputStream), a.bO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected boolean isNullString(String str) {
        return str == null || str.equals(com.xiaomi.e.a.f) || str.equals("[]");
    }
}
