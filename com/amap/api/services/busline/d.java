package com.amap.api.services.busline;

import android.os.Handler;
import android.os.Message;

class d extends Handler {
    final /* synthetic */ BusStationSearch a;

    d(BusStationSearch busStationSearch) {
        this.a = busStationSearch;
    }

    public void handleMessage(Message message) {
        if (this.a.c != null) {
            BusStationResult busStationResult = null;
            if (message.what == 0) {
                busStationResult = (BusStationResult) message.obj;
            }
            this.a.c.onBusStationSearched(busStationResult, message.what);
        }
    }
}
