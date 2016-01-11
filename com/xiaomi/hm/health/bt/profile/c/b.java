package com.xiaomi.hm.health.bt.profile.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.af;
import cn.com.smartdevices.bracelet.C0596r;
import kankan.wheel.widget.a;

class b extends BroadcastReceiver {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", af.a)) {
                case a.bd /*10*/:
                    C0596r.e(a.b, "#Broadcast# Bluetooth OFF.");
                    this.a.c();
                    this.a.b(h.CONNECT_FAILED);
                    return;
                case a.be /*12*/:
                    C0596r.e(a.b, "#Broadcast# Bluetooth ON.");
                    this.a.g(this.a.a == null ? null : this.a.a.f());
                    return;
                default:
                    return;
            }
        }
    }
}
