package com.xiaomi.h.a;

import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.tencent.open.SocialConstants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum C1099f {
    ID((short) 1, SyncShoesDataService.d),
    MESSAGE_TS((short) 2, "messageTs"),
    TOPIC((short) 3, NativeInterface.PARAM_SHARE_TOPIC),
    TITLE((short) 4, SocialConstants.PARAM_TITLE),
    DESCRIPTION((short) 5, SocialConstants.PARAM_COMMENT),
    NOTIFY_TYPE((short) 6, "notifyType"),
    URL((short) 7, SocialConstants.PARAM_URL),
    PASS_THROUGH((short) 8, "passThrough"),
    NOTIFY_ID((short) 9, "notifyId"),
    EXTRA((short) 10, g.g);
    
    private static final Map<String, C1099f> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(C1099f.class).iterator();
        while (it.hasNext()) {
            C1099f c1099f = (C1099f) it.next();
            k.put(c1099f.a(), c1099f);
        }
    }

    private C1099f(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
