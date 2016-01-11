package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.huami.android.widget.f;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum F {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    PACKAGE_NAME((short) 5, o.d),
    TOPIC((short) 6, NativeInterface.PARAM_SHARE_TOPIC),
    ALIAS_NAME((short) 7, "aliasName"),
    MESSAGE((short) 8, f.a),
    NEED_ACK((short) 9, "needAck"),
    PARAMS((short) 10, "params"),
    CATEGORY((short) 11, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY),
    USER_ACCOUNT((short) 12, "userAccount");
    
    private static final Map<String, F> m = null;
    private final short n;
    private final String o;

    static {
        m = new HashMap();
        Iterator it = EnumSet.allOf(F.class).iterator();
        while (it.hasNext()) {
            F f = (F) it.next();
            m.put(f.a(), f);
        }
    }

    private F(short s, String str) {
        this.n = s;
        this.o = str;
    }

    public String a() {
        return this.o;
    }
}
