package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.a;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum z {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    REQUEST((short) 5, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 6, a.c),
    REASON((short) 7, "reason"),
    REG_ID((short) 8, "regId"),
    REG_SECRET((short) 9, "regSecret"),
    PACKAGE_NAME((short) 10, o.d);
    
    private static final Map<String, z> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(z.class).iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            k.put(zVar.a(), zVar);
        }
    }

    private z(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
