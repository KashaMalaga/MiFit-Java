package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.open.SocialConstants;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1107n {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    MESSAGE_TS((short) 5, "messageTs"),
    TOPIC((short) 6, NativeInterface.PARAM_SHARE_TOPIC),
    ALIAS_NAME((short) 7, "aliasName"),
    REQUEST((short) 8, SocialConstants.TYPE_REQUEST),
    PACKAGE_NAME((short) 9, o.d),
    CATEGORY((short) 10, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, C1107n> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(C1107n.class).iterator();
        while (it.hasNext()) {
            C1107n c1107n = (C1107n) it.next();
            k.put(c1107n.a(), c1107n);
        }
    }

    private C1107n(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
