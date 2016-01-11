package cn.com.smartdevices.bracelet.lab.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.lab.b.c;
import cn.com.smartdevices.bracelet.model.LoginData;

public class LabWifiConnReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        if (intent != null && c.e(context)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (c.b(context) <= 1) {
                z = false;
            }
            if (!booleanExtra && r0) {
                LoginData f = a.f(context);
                if (f != null && f.isValid()) {
                    i.b(context);
                }
            }
        }
    }
}
