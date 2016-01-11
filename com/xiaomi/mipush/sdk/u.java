package com.xiaomi.mipush.sdk;

import a.a.a.B;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import cn.com.smartdevices.bracelet.ui.C0763dl;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.d.a;
import com.xiaomi.channel.a.e.d;
import com.xiaomi.h.a.C1094a;
import com.xiaomi.h.a.C1098e;
import com.xiaomi.h.a.K;
import com.xiaomi.h.a.S;
import com.xiaomi.h.a.w;
import com.xiaomi.push.service.ad;
import com.xiaomi.push.service.ae;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.thrift.b;

public class u {
    private static u b;
    private static final ArrayList<v> e = new ArrayList();
    private boolean a = false;
    private Context c;
    private String d;
    private Intent f = null;
    private Integer g = null;

    private u(Context context) {
        this.c = context.getApplicationContext();
        this.d = d.a(6);
        this.a = g();
    }

    public static u a(Context context) {
        if (b == null) {
            b = new u(context);
        }
        return b;
    }

    private final <T extends b<T, ?>> void a(T t, C1094a c1094a, boolean z, boolean z2, C1098e c1098e, boolean z3) {
        if (m.a(this.c).i()) {
            Intent h = h();
            b a = q.a(this.c, t, c1094a, z);
            if (c1098e != null) {
                a.a(c1098e);
            }
            byte[] a2 = S.a(a);
            if (a2 == null) {
                c.a("send message fail, because msgBytes is null.");
                return;
            }
            h.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            h.putExtra("mipush_payload", a2);
            h.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            this.c.startService(h);
        } else if (z2) {
            a((b) t, c1094a, z);
        } else {
            c.a("drop the message before initialization.");
        }
    }

    private boolean g() {
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= B.n;
        } catch (Exception e) {
            return false;
        }
    }

    private Intent h() {
        Intent intent = new Intent();
        String packageName = this.c.getPackageName();
        if (!b() || "com.xiaomi.xmsf".equals(packageName)) {
            k();
            intent.setComponent(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
        } else {
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", i());
            intent.putExtra("mipush_app_package", packageName);
            j();
        }
        return intent;
    }

    private String i() {
        try {
            if (this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= B.o) {
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception e) {
        }
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    private void j() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 2, 1);
        } catch (Throwable th) {
        }
    }

    private void k() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 1, 1);
        } catch (Throwable th) {
        }
    }

    private boolean l() {
        String packageName = this.c.getPackageName();
        return packageName.contains(C0763dl.b) || packageName.contains("xiaomi") || (this.c.getApplicationInfo().flags & 1) != 0;
    }

    public void a() {
        this.c.startService(h());
    }

    public void a(int i) {
        Intent h = h();
        h.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        h.putExtra(ad.v, this.c.getPackageName());
        h.putExtra(ad.w, i);
        this.c.startService(h);
    }

    public final void a(K k) {
        Intent h = h();
        byte[] a = S.a(q.a(this.c, k, C1094a.UnRegistration));
        if (a == null) {
            c.a("unregister fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        h.putExtra("mipush_app_id", m.a(this.c).c());
        h.putExtra("mipush_payload", a);
        this.c.startService(h);
    }

    public final void a(w wVar, boolean z) {
        this.f = null;
        Intent h = h();
        byte[] a = S.a(q.a(this.c, wVar, C1094a.Registration));
        if (a == null) {
            c.a("register fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.REGISTER_APP");
        h.putExtra("mipush_app_id", m.a(this.c).c());
        h.putExtra("mipush_payload", a);
        h.putExtra("mipush_session", this.d);
        h.putExtra("mipush_env_chanage", z);
        h.putExtra("mipush_env_type", m.a(this.c).m());
        if (a.d(this.c) && f()) {
            this.c.startService(h);
        } else {
            this.f = h;
        }
    }

    public final <T extends b<T, ?>> void a(T t, C1094a c1094a, C1098e c1098e) {
        a(t, c1094a, !c1094a.equals(C1094a.Registration), c1098e);
    }

    public <T extends b<T, ?>> void a(T t, C1094a c1094a, boolean z) {
        v vVar = new v();
        vVar.a = t;
        vVar.b = c1094a;
        vVar.c = z;
        synchronized (e) {
            e.add(vVar);
            if (e.size() > 10) {
                e.remove(0);
            }
        }
    }

    public final <T extends b<T, ?>> void a(T t, C1094a c1094a, boolean z, C1098e c1098e) {
        a(t, c1094a, z, true, c1098e, true);
    }

    public final <T extends b<T, ?>> void a(T t, C1094a c1094a, boolean z, C1098e c1098e, boolean z2) {
        a(t, c1094a, z, true, c1098e, z2);
    }

    public void b(int i) {
        Intent h = h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(ad.v, this.c.getPackageName());
        h.putExtra(ad.x, i);
        h.putExtra(ad.z, com.xiaomi.channel.a.e.c.b(this.c.getPackageName() + i));
        this.c.startService(h);
    }

    public boolean b() {
        return this.a && 1 == m.a(this.c).m();
    }

    public void c() {
        if (this.f != null) {
            this.c.startService(this.f);
            this.f = null;
        }
    }

    public void d() {
        synchronized (e) {
            Iterator it = e.iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                a(vVar.a, vVar.b, vVar.c, false, null, true);
            }
            e.clear();
        }
    }

    public void e() {
        Intent h = h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(ad.v, this.c.getPackageName());
        h.putExtra(ad.z, com.xiaomi.channel.a.e.c.b(this.c.getPackageName()));
        this.c.startService(h);
    }

    public boolean f() {
        if (!b() || !l()) {
            return true;
        }
        if (this.g == null) {
            this.g = Integer.valueOf(ae.a(this.c).b());
            if (this.g.intValue() == 0) {
                this.c.getContentResolver().registerContentObserver(ae.a(this.c).c(), false, new w(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.g.intValue() != 0;
    }
}
