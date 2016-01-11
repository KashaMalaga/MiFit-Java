package com.xiaomi.push.service.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.C0056bn;
import android.text.TextUtils;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.a.a;
import com.xiaomi.push.service.ad;

public class PingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new a(context).a(false);
        c.b(intent.getPackage() + " is the package name");
        if (!ad.l.equals(intent.getAction())) {
            c.a("cancel the old ping timer");
            ((AlarmManager) context.getSystemService(C0056bn.f)).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, PingReceiver.class), 0));
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            c.b("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.setAction("com.xiaomi.push.timer");
                context.startService(intent2);
            } catch (Throwable e) {
                c.a(e);
            }
        }
    }
}
