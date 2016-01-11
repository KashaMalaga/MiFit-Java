package com.xiaomi.b.a.a;

import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum b {
    UUID((short) 1, g.n),
    TIME((short) 2, cn.com.smartdevices.bracelet.gps.c.a.g.f),
    CLIENT_IP((short) 3, "clientIp"),
    SERVER_IP((short) 4, "serverIp"),
    SERVER_HOST((short) 5, "serverHost");
    
    private static final Map<String, b> f = null;
    private final short g;
    private final String h;

    static {
        f = new HashMap();
        Iterator it = EnumSet.allOf(b.class).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            f.put(bVar.a(), bVar);
        }
    }

    private b(short s, String str) {
        this.g = s;
        this.h = str;
    }

    public String a() {
        return this.h;
    }
}
