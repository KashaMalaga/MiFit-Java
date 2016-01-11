package com.xiaomi.b.a.a.a;

import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum b {
    HOST((short) 1, o.A),
    LAND_NODE_INFO((short) 2, "land_node_info");
    
    private static final Map<String, b> c = null;
    private final short d;
    private final String e;

    static {
        c = new HashMap();
        Iterator it = EnumSet.allOf(b.class).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            c.put(bVar.a(), bVar);
        }
    }

    private b(short s, String str) {
        this.d = s;
        this.e = str;
    }

    public String a() {
        return this.e;
    }
}
