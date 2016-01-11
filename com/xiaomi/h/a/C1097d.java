package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1097d {
    TO((short) 1, "to"),
    ID((short) 2, SyncShoesDataService.d),
    APP_ID((short) 3, "appId"),
    PAYLOAD((short) 4, "payload"),
    CREATE_AT((short) 5, "createAt"),
    TTL((short) 6, "ttl"),
    COLLAPSE_KEY((short) 7, "collapseKey"),
    PACKAGE_NAME((short) 8, o.d);
    
    private static final Map<String, C1097d> i = null;
    private final short j;
    private final String k;

    static {
        i = new HashMap();
        Iterator it = EnumSet.allOf(C1097d.class).iterator();
        while (it.hasNext()) {
            C1097d c1097d = (C1097d) it.next();
            i.put(c1097d.a(), c1097d);
        }
    }

    private C1097d(short s, String str) {
        this.j = s;
        this.k = str;
    }

    public String a() {
        return this.k;
    }
}
