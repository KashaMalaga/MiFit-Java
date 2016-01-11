package com.xiaomi.h.a;

import com.tencent.open.SocialConstants;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum t {
    ACTION((short) 1, AuthActivity.ACTION_KEY),
    ENCRYPT_ACTION((short) 2, "encryptAction"),
    IS_REQUEST((short) 3, "isRequest"),
    PUSH_ACTION((short) 4, "pushAction"),
    APPID((short) 5, SocialConstants.PARAM_APP_ID),
    PACKAGE_NAME((short) 6, o.d),
    TARGET((short) 7, "target"),
    META_INFO((short) 8, "metaInfo");
    
    private static final Map<String, t> i = null;
    private final short j;
    private final String k;

    static {
        i = new HashMap();
        Iterator it = EnumSet.allOf(t.class).iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            i.put(tVar.a(), tVar);
        }
    }

    private t(short s, String str) {
        this.j = s;
        this.k = str;
    }

    public String a() {
        return this.k;
    }
}
