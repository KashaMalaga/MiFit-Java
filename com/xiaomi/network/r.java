package com.xiaomi.network;

import com.xiaomi.b.a.a.a.c;
import java.util.List;
import org.json.JSONException;

final class r implements p {
    r() {
    }

    public List<c> a() {
        try {
            return f.k.h();
        } catch (JSONException e) {
            return null;
        }
    }

    public double b() {
        c a = f.k.a("f3.mi-stat.gslb.mi-idc.com");
        return a != null ? a.f() : 0.1d;
    }
}
