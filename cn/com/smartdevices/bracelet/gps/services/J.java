package cn.com.smartdevices.bracelet.gps.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class J extends BroadcastReceiver {
    final /* synthetic */ I a;

    J(I i) {
        this.a = i;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.b();
    }
}
