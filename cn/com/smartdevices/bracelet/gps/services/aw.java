package cn.com.smartdevices.bracelet.gps.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.services.b.l;

final class aw extends BroadcastReceiver {
    final /* synthetic */ SubGPSSportService a;

    private aw(SubGPSSportService subGPSSportService) {
        this.a = subGPSSportService;
    }

    public IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            CharSequence action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if ("android.intent.action.SCREEN_ON".equals(action)) {
                    if (this.a.i != null) {
                        this.a.i.a(true);
                    }
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (!this.a.o && !l.a(this.a.j)) {
                        try {
                            l.a(this.a.j, Class.forName("cn.com.smartdevices.bracelet.gps.ui.GPSMainActivity"));
                        } catch (ClassNotFoundException e) {
                            C0596r.a("RService", e.getMessage());
                        }
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action) && this.a.i != null) {
                    this.a.i.a(false);
                }
            }
        }
    }
}
