package com.amap.api.services.route;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.channel.b.a;

class m extends Handler {
    final /* synthetic */ RouteSearch a;

    m(RouteSearch routeSearch) {
        this.a = routeSearch;
    }

    public void handleMessage(Message message) {
        if (this.a.b != null) {
            Bundle data;
            if (message.what == 10) {
                data = message.getData();
                if (data != null) {
                    this.a.b.onBusRouteSearched((BusRouteResult) message.obj, data.getInt(a.c));
                }
            } else if (message.what == 11) {
                data = message.getData();
                if (data != null) {
                    this.a.b.onDriveRouteSearched((DriveRouteResult) message.obj, data.getInt(a.c));
                }
            } else if (message.what == 12) {
                data = message.getData();
                if (data != null) {
                    this.a.b.onWalkRouteSearched((WalkRouteResult) message.obj, data.getInt(a.c));
                }
            }
        }
    }
}
