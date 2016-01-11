package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.a;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum R {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    REQUEST((short) 5, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 6, a.c),
    REASON((short) 7, "reason"),
    TOPIC((short) 8, NativeInterface.PARAM_SHARE_TOPIC),
    PACKAGE_NAME((short) 9, o.d),
    CATEGORY((short) 10, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, R> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(R.class).iterator();
        while (it.hasNext()) {
            R r = (R) it.next();
            k.put(r.a(), r);
        }
    }

    private R(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
