package com.xiaomi.b.a.a.a;

import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.amap.api.location.LocationManagerProxy;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.channel.b.v;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum d {
    CATEGORY((short) 1, WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY),
    UUID((short) 2, g.n),
    VERSION((short) 3, o.x),
    NETWORK((short) 4, LocationManagerProxy.NETWORK_PROVIDER),
    CLIENT_IP((short) 5, "client_ip"),
    LOCATION((short) 6, LocationManagerProxy.KEY_LOCATION_CHANGED),
    HOST_INFO((short) 7, "host_info"),
    VERSION_TYPE((short) 8, "version_type"),
    APP_NAME((short) 9, v.v),
    APP_VERSION((short) 10, "app_version");
    
    private static final Map<String, d> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(d.class).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            k.put(dVar.a(), dVar);
        }
    }

    private d(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public String a() {
        return this.m;
    }
}
