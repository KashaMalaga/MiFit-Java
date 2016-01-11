package cn.com.smartdevices.bracelet.gps.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class aq extends BroadcastReceiver {
    final /* synthetic */ an a;

    private aq(an anVar) {
        this.a = anVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null) {
            this.a.k();
        }
    }
}
