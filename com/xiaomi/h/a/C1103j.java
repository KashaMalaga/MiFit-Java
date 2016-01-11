package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1103j {
    UUID((short) 1, g.n),
    OPERATOR((short) 2, "operator"),
    EVENTS((short) 3, "events");
    
    private static final Map<String, C1103j> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(C1103j.class).iterator();
        while (it.hasNext()) {
            C1103j c1103j = (C1103j) it.next();
            d.put(c1103j.a(), c1103j);
        }
    }

    private C1103j(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public String a() {
        return this.f;
    }
}
