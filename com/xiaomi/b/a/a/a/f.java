package com.xiaomi.b.a.a.a;

import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum f {
    COMMON((short) 1, "common"),
    CATEGORY((short) 2, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY),
    HTTP_API((short) 3, "httpApi"),
    PASSPORT((short) 4, "passport");
    
    private static final Map<String, f> e = null;
    private final short f;
    private final String g;

    static {
        e = new HashMap();
        Iterator it = EnumSet.allOf(f.class).iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            e.put(fVar.a(), fVar);
        }
    }

    private f(short s, String str) {
        this.f = s;
        this.g = str;
    }

    public String a() {
        return this.g;
    }
}
