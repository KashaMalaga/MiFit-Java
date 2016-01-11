package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum x {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    APP_VERSION((short) 5, "appVersion"),
    PACKAGE_NAME((short) 6, o.d),
    TOKEN((short) 7, "token"),
    DEVICE_ID((short) 8, "deviceId"),
    ALIAS_NAME((short) 9, "aliasName"),
    SDK_VERSION((short) 10, "sdkVersion");
    
    private static final Map<String, x> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(x.class).iterator();
        while (it.hasNext()) {
            x xVar = (x) it.next();
            k.put(xVar.a(), xVar);
        }
    }

    private x(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
