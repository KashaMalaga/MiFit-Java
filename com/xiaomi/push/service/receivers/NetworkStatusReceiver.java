package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.d.a;
import com.xiaomi.mipush.sdk.m;
import com.xiaomi.mipush.sdk.u;

public class NetworkStatusReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (!(u.a(context).b() || !m.a(context).i() || m.a(context).n())) {
            try {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent2.setAction("com.xiaomi.push.network_status_changed");
                context.startService(intent2);
            } catch (Throwable e) {
                c.a(e);
            }
        }
        if (a.d(context) && u.a(context).f()) {
            u.a(context).c();
        }
    }
}
