package com.amap.api.services.core;

import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;
import com.xiaomi.e.a;
import java.net.Proxy;

public class g extends s<DriveRouteQuery, DriveRouteResult> {
    public g(DriveRouteQuery driveRouteQuery, Proxy proxy) {
        super(driveRouteQuery, proxy);
    }

    protected DriveRouteResult a(String str) {
        return m.c(str);
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(d.a(null).f());
        stringBuffer.append("&origin=").append(e.a(((DriveRouteQuery) this.task).getFromAndTo().getFrom()));
        if (!m.h(((DriveRouteQuery) this.task).getFromAndTo().getStartPoiID())) {
            stringBuffer.append("&originid=").append(((DriveRouteQuery) this.task).getFromAndTo().getStartPoiID());
        }
        stringBuffer.append("&destination=").append(e.a(((DriveRouteQuery) this.task).getFromAndTo().getTo()));
        if (!m.h(((DriveRouteQuery) this.task).getFromAndTo().getDestinationPoiID())) {
            stringBuffer.append("&destinationid=").append(((DriveRouteQuery) this.task).getFromAndTo().getDestinationPoiID());
        }
        stringBuffer.append("&strategy=").append(a.f + ((DriveRouteQuery) this.task).getMode());
        stringBuffer.append("&extensions=all");
        if (((DriveRouteQuery) this.task).hasPassPoint()) {
            stringBuffer.append("&waypoints=").append(((DriveRouteQuery) this.task).getPassedPointStr());
        }
        if (((DriveRouteQuery) this.task).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=").append(((DriveRouteQuery) this.task).getAvoidpolygonsStr());
        }
        if (((DriveRouteQuery) this.task).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=").append(((DriveRouteQuery) this.task).getAvoidRoad());
        }
        stringBuffer.append("&output=json");
        return e.f(stringBuffer.toString());
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/direction/driving?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
