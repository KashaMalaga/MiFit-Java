package com.xiaomi.b.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum h {
    IP((short) 1, "ip"),
    FAILED_COUNT((short) 2, "failed_count"),
    SUCCESS_COUNT((short) 3, "success_count"),
    DURATION((short) 4, "duration"),
    SIZE((short) 5, "size"),
    EXP_INFO((short) 6, "exp_info"),
    HTTP_INFO((short) 7, "http_info");
    
    private static final Map<String, h> h = null;
    private final short i;
    private final String j;

    static {
        h = new HashMap();
        Iterator it = EnumSet.allOf(h.class).iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            h.put(hVar.a(), hVar);
        }
    }

    private h(short s, String str) {
        this.i = s;
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
