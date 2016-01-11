package com.xiaomi.hm.health.bt.bleservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class j extends BroadcastReceiver {
    final /* synthetic */ BLEService a;

    j(BLEService bLEService) {
        this.a = bLEService;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.E.post(new k(this, context, intent));
    }
}
