package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum v {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    TYPE((short) 5, a.h),
    REQUIRE_ACK((short) 6, "requireAck"),
    PAYLOAD((short) 7, "payload"),
    EXTRA((short) 8, a.G),
    PACKAGE_NAME((short) 9, o.d),
    CATEGORY((short) 10, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, v> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(v.class).iterator();
        while (it.hasNext()) {
            v vVar = (v) it.next();
            k.put(vVar.a(), vVar);
        }
    }

    private v(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
