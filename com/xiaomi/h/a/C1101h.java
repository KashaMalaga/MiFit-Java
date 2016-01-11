package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.d.C0432i;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import com.tencent.open.SocialConstants;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1101h {
    CHID((short) 1, "chid"),
    TYPE((short) 2, SocialConstants.PARAM_TYPE),
    VALUE((short) 3, C0432i.b),
    CONNPT((short) 4, "connpt"),
    HOST((short) 5, o.A),
    SUBVALUE((short) 6, "subvalue"),
    ANNOTATION((short) 7, "annotation"),
    USER((short) 8, "user"),
    TIME((short) 9, g.f);
    
    private static final Map<String, C1101h> j = null;
    private final short k;
    private final String l;

    static {
        j = new HashMap();
        Iterator it = EnumSet.allOf(C1101h.class).iterator();
        while (it.hasNext()) {
            C1101h c1101h = (C1101h) it.next();
            j.put(c1101h.a(), c1101h);
        }
    }

    private C1101h(short s, String str) {
        this.k = s;
        this.l = str;
    }

    public String a() {
        return this.l;
    }
}
