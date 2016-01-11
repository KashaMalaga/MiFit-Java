package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.a;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum D {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, SyncShoesDataService.d),
    APP_ID((short) 4, "appId"),
    REQUEST((short) 5, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 6, a.c),
    REASON((short) 7, "reason"),
    CATEGORY((short) 8, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY);
    
    private static final Map<String, D> i = null;
    private final short j;
    private final String k;

    static {
        i = new HashMap();
        Iterator it = EnumSet.allOf(D.class).iterator();
        while (it.hasNext()) {
            D d = (D) it.next();
            i.put(d.a(), d);
        }
    }

    private D(short s, String str) {
        this.j = s;
        this.k = str;
    }

    public String a() {
        return this.k;
    }
}
