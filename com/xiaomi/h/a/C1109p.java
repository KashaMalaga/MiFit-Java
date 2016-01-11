package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1109p {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    CMD_NAME((short) 5, "cmdName"),
    CMD_ARGS((short) 6, "cmdArgs"),
    PACKAGE_NAME((short) 7, o.d),
    CATEGORY((short) 9, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, C1109p> i = null;
    private final short j;
    private final String k;

    static {
        i = new HashMap();
        Iterator it = EnumSet.allOf(C1109p.class).iterator();
        while (it.hasNext()) {
            C1109p c1109p = (C1109p) it.next();
            i.put(c1109p.a(), c1109p);
        }
    }

    private C1109p(short s, String str) {
        this.j = s;
        this.k = str;
    }

    public String a() {
        return this.k;
    }
}
