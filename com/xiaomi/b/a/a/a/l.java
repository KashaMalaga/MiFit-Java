package com.xiaomi.b.a.a.a;

import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.amap.api.location.LocationManagerProxy;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum l {
    CATEGORY((short) 1, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY),
    UUID((short) 2, g.n),
    VERSION((short) 3, o.x),
    NETWORK((short) 4, LocationManagerProxy.NETWORK_PROVIDER),
    RID((short) 5, "rid"),
    LOCATION((short) 6, LocationManagerProxy.KEY_LOCATION_CHANGED),
    HOST_INFO((short) 7, "host_info");
    
    private static final Map<String, l> h = null;
    private final short i;
    private final String j;

    static {
        h = new HashMap();
        Iterator it = EnumSet.allOf(l.class).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            h.put(lVar.a(), lVar);
        }
    }

    private l(short s, String str) {
        this.i = s;
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
