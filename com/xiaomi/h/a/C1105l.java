package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.j.f;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1105l {
    CHANNEL_ID((short) 1, "channelId"),
    USER_ID((short) 2, f.U),
    SERVER((short) 3, "server"),
    RESOURCE((short) 4, "resource"),
    IS_PREVIEW((short) 5, "isPreview");
    
    private static final Map<String, C1105l> f = null;
    private final short g;
    private final String h;

    static {
        f = new HashMap();
        Iterator it = EnumSet.allOf(C1105l.class).iterator();
        while (it.hasNext()) {
            C1105l c1105l = (C1105l) it.next();
            f.put(c1105l.a(), c1105l);
        }
    }

    private C1105l(short s, String str) {
        this.g = s;
        this.h = str;
    }

    public String a() {
        return this.h;
    }
}
