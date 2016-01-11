package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.a;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1111r {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    CMD_NAME((short) 5, "cmdName"),
    REQUEST((short) 6, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 7, a.c),
    REASON((short) 8, "reason"),
    PACKAGE_NAME((short) 9, o.d),
    CMD_ARGS((short) 10, "cmdArgs"),
    CATEGORY((short) 12, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, C1111r> l = null;
    private final short m;
    private final String n;

    static {
        l = new HashMap();
        Iterator it = EnumSet.allOf(C1111r.class).iterator();
        while (it.hasNext()) {
            C1111r c1111r = (C1111r) it.next();
            l.put(c1111r.a(), c1111r);
        }
    }

    private C1111r(short s, String str) {
        this.m = s;
        this.n = str;
    }

    public String a() {
        return this.n;
    }
}
