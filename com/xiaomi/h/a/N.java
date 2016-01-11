package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.a;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum N {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    REQUEST((short) 5, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 6, a.c),
    REASON((short) 7, "reason"),
    PACKAGE_NAME((short) 8, o.d);
    
    private static final Map<String, N> i = null;
    private final short j;
    private final String k;

    static {
        i = new HashMap();
        Iterator it = EnumSet.allOf(N.class).iterator();
        while (it.hasNext()) {
            N n = (N) it.next();
            i.put(n.a(), n);
        }
    }

    private N(short s, String str) {
        this.j = s;
        this.k = str;
    }

    public String a() {
        return this.k;
    }
}
