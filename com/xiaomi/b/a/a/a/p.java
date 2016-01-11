package com.xiaomi.b.a.a.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum p {
    IP((short) 1, "ip"),
    EID((short) 2, "eid"),
    RT((short) 3, "rt");
    
    private static final Map<String, p> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(p.class).iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            d.put(pVar.a(), pVar);
        }
    }

    private p(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public String a() {
        return this.f;
    }
}
