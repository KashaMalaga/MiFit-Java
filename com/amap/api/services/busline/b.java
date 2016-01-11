package com.amap.api.services.busline;

import android.os.Handler;
import android.os.Message;

class b extends Handler {
    final /* synthetic */ BusLineSearch a;

    b(BusLineSearch busLineSearch) {
        this.a = busLineSearch;
    }

    public void handleMessage(Message message) {
        if (this.a.c != null) {
            BusLineResult busLineResult = null;
            if (message.what == 0) {
                busLineResult = (BusLineResult) message.obj;
            }
            this.a.c.onBusLineSearched(busLineResult, message.what);
        }
    }
}
