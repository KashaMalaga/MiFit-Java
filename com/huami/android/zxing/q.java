package com.huami.android.zxing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class q extends BroadcastReceiver {
    final /* synthetic */ n a;

    private q(n nVar) {
        this.a = nVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            if ((intent.getIntExtra("plugged", -1) <= 0 ? 1 : null) != null) {
                this.a.a();
            } else {
                this.a.f();
            }
        }
    }
}
