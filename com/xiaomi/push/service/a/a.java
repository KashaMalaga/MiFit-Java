package com.xiaomi.push.service.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.C0056bn;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.v;
import com.xiaomi.push.service.ad;

public class a {
    private static volatile long c = 0;
    private PendingIntent a = null;
    private Context b = null;

    public a(Context context) {
        this.b = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(alarmManager, new Object[]{Integer.valueOf(0), Long.valueOf(j), pendingIntent});
        } catch (Throwable e) {
            c.a(e);
        }
    }

    public synchronized void a() {
        if (this.a != null) {
            ((AlarmManager) this.b.getSystemService(C0056bn.f)).cancel(this.a);
            this.a = null;
            c.b("unregister timer");
            c = 0;
        }
    }

    public synchronized void a(Intent intent, long j) {
        if (this.a == null) {
            AlarmManager alarmManager = (AlarmManager) this.b.getSystemService(C0056bn.f);
            this.a = PendingIntent.getBroadcast(this.b, 0, intent, 0);
            if (VERSION.SDK_INT >= 19) {
                a(alarmManager, j, this.a);
            } else {
                alarmManager.set(0, j, this.a);
            }
            c.b("register timer " + c);
        }
    }

    public synchronized void a(boolean z) {
        Intent intent = new Intent(ad.l);
        intent.setPackage(this.b.getPackageName());
        long d = (long) v.d();
        if (z || c == 0) {
            c = (SystemClock.elapsedRealtime() % d) + System.currentTimeMillis();
        } else {
            c += d;
            if (c < System.currentTimeMillis()) {
                c = d + System.currentTimeMillis();
            }
        }
        a(intent, c);
    }

    public synchronized boolean b() {
        return this.a != null;
    }
}
