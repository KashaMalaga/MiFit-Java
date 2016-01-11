package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum L {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    REG_ID((short) 5, "regId"),
    APP_VERSION((short) 6, "appVersion"),
    PACKAGE_NAME((short) 7, o.d),
    TOKEN((short) 8, "token"),
    DEVICE_ID((short) 9, "deviceId"),
    ALIAS_NAME((short) 10, "aliasName");
    
    private static final Map<String, L> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(L.class).iterator();
        while (it.hasNext()) {
            L l = (L) it.next();
            k.put(l.a(), l);
        }
    }

    private L(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
