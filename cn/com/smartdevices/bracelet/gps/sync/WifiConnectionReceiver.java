package cn.com.smartdevices.bracelet.gps.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.gps.c.b;
import cn.com.smartdevices.bracelet.gps.h.g;
import cn.com.smartdevices.bracelet.model.LoginData;

public class WifiConnectionReceiver extends BroadcastReceiver {
    private static final long a = 10000;

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        if (intent != null && g.e(context)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (g.b(context) <= 1) {
                z = false;
            }
            if (!booleanExtra && r0) {
                LoginData f = a.f(context);
                if (f == null || !f.isValid()) {
                    C0596r.e("Wifi", "isValid");
                    return;
                }
                if (System.currentTimeMillis() - b.c(context) >= a && z.c(context)) {
                    b.a(context, System.currentTimeMillis());
                }
            }
        }
    }
}
