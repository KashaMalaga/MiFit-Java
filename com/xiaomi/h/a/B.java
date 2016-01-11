package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum B {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    FEEDBACKS((short) 5, "feedbacks"),
    CATEGORY((short) 6, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, B> g = null;
    private final short h;
    private final String i;

    static {
        g = new HashMap();
        Iterator it = EnumSet.allOf(B.class).iterator();
        while (it.hasNext()) {
            B b = (B) it.next();
            g.put(b.a(), b);
        }
    }

    private B(short s, String str) {
        this.h = s;
        this.i = str;
    }

    public String a() {
        return this.i;
    }
}
