package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum P {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    TOPIC((short) 5, NativeInterface.PARAM_SHARE_TOPIC),
    PACKAGE_NAME((short) 6, o.d),
    CATEGORY((short) 7, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, P> h = null;
    private final short i;
    private final String j;

    static {
        h = new HashMap();
        Iterator it = EnumSet.allOf(P.class).iterator();
        while (it.hasNext()) {
            P p = (P) it.next();
            h.put(p.a(), p);
        }
    }

    private P(short s, String str) {
        this.i = s;
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
