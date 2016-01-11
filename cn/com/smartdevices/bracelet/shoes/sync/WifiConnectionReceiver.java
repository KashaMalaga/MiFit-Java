package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.shoes.c.c;

public class WifiConnectionReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (c.b(context) <= 1) {
                z = false;
            }
            if (!booleanExtra && r0) {
                LoginData f = a.f(context);
                if (f == null || !f.isValid()) {
                    C0596r.d("Wifi", "Longin isValid");
                } else if (!b.h().t.a.booleanValue()) {
                    C0596r.e(B.a, "!Config.getInstance().SHOES.ENABLE");
                } else if (cn.com.smartdevices.bracelet.shoes.data.a.a(context, System.currentTimeMillis())) {
                    z = J.c(context);
                    C0596r.e("Wifi", "syncTwoWayDataASynced isTriggerd = " + z);
                    if (z) {
                        cn.com.smartdevices.bracelet.shoes.data.a.b(context, System.currentTimeMillis());
                    }
                }
            }
        }
    }
}
