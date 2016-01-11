package com.amap.api.services.core;

import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;
import com.xiaomi.e.a;
import java.net.Proxy;

public class b extends s<BusRouteQuery, BusRouteResult> {
    public b(BusRouteQuery busRouteQuery, Proxy proxy) {
        super(busRouteQuery, proxy);
    }

    protected BusRouteResult a(String str) {
        return m.b(str);
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(d.a(null).f());
        stringBuffer.append("&origin=").append(e.a(((BusRouteQuery) this.task).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(e.a(((BusRouteQuery) this.task).getFromAndTo().getTo()));
        String city = ((BusRouteQuery) this.task).getCity();
        if (!m.h(city)) {
            stringBuffer.append("&city=").append(strEncoder(city, z));
        }
        stringBuffer.append("&strategy=").append(a.f + ((BusRouteQuery) this.task).getMode());
        stringBuffer.append("&nightflag=").append(((BusRouteQuery) this.task).getNightFlag());
        stringBuffer.append("&output=json");
        return e.f(stringBuffer.toString());
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/direction/transit/integrated?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
