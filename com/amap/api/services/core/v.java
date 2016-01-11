package com.amap.api.services.core;

import com.amap.api.services.route.RouteSearch.WalkRouteQuery;
import com.amap.api.services.route.WalkRouteResult;
import java.net.Proxy;

public class v extends s<WalkRouteQuery, WalkRouteResult> {
    public v(WalkRouteQuery walkRouteQuery, Proxy proxy) {
        super(walkRouteQuery, proxy);
    }

    protected WalkRouteResult a(String str) {
        return m.d(str);
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(d.a(null).f());
        stringBuffer.append("&origin=").append(e.a(((WalkRouteQuery) this.task).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(e.a(((WalkRouteQuery) this.task).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        return e.f(stringBuffer.toString());
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/direction/walking?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
