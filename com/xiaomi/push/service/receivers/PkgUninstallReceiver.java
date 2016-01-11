package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.push.service.C1148n;
import com.xiaomi.push.service.XMPushService;

public class PkgUninstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null) {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.setAction(C1148n.a);
                intent2.putExtra("uninstall_pkg_name", data.getEncodedSchemeSpecificPart());
                context.startService(intent2);
            }
        }
    }
}
