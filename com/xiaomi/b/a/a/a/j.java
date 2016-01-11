package com.xiaomi.b.a.a.a;

import com.amap.api.services.district.DistrictSearchQuery;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum j {
    CONTRY((short) 1, "contry"),
    PROVINCE((short) 2, DistrictSearchQuery.KEYWORDS_PROVINCE),
    CITY((short) 3, DistrictSearchQuery.KEYWORDS_CITY),
    ISP((short) 4, "isp");
    
    private static final Map<String, j> e = null;
    private final short f;
    private final String g;

    static {
        e = new HashMap();
        Iterator it = EnumSet.allOf(j.class).iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            e.put(jVar.a(), jVar);
        }
    }

    private j(short s, String str) {
        this.f = s;
        this.g = str;
    }

    public String a() {
        return this.g;
    }
}
