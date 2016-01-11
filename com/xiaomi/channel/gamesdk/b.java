package com.xiaomi.channel.gamesdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.xiaomi.channel.b.x;
import com.xiaomi.channel.gamesdk.a.a;

public class b {
    public static final String a = "code";
    public static final String b = "data";
    public static final String c = "flag";
    public static final int d = 0;
    public static final int e = -1;
    public static final int f = 20001;
    public static final int g = 20002;
    public static final int h = 20003;
    public static final int i = 20004;
    public static final int j = 20005;
    public static final int k = 20006;
    public static final int l = 20007;
    public static final int m = 20008;
    public static final int n = 20009;
    public static final int o = 20010;
    public static final int p = 20011;
    public static final int q = 20012;
    public static final int r = -10003;
    public static final int s = -10004;
    public static final int t = 1146;
    public static final Intent u = new Intent();
    private static final String v = "http://www.miliao.com/from=android&version=%d";
    private static final String w = "GameServiceClient";
    private static b x;
    private Context A;
    private ServiceConnection B = new c(this);
    private a y;
    private final Object z = new Object();

    static {
        u.setComponent(new ComponentName("com.xiaomi.channel", "com.xiaomi.channel.gameService.GameService"));
    }

    private b(Context context) {
        if (context != null) {
            try {
                this.A = context.getApplicationContext();
                g();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(Context context) {
        return x.a(context, t);
    }

    public static synchronized b b(Context context) {
        b bVar;
        synchronized (b.class) {
            if (x == null) {
                x = new b(context);
            }
            bVar = x;
        }
        return bVar;
    }

    public static int c(Context context) {
        if (!x.d(context)) {
            return a.a;
        }
        if (!x.a(context, t)) {
            return a.b;
        }
        new Thread(new d(context)).start();
        return d;
    }

    private void g() {
        if (a(this.A)) {
            synchronized (this.z) {
                try {
                    this.A.bindService(u, this.B, 1);
                    try {
                        this.z.wait(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public Retobj a(String str) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.a(str);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public Retobj a(String str, String str2) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.a(str2, str);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public Retobj a(String str, String str2, String str3, String str4) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.a(str, str2, str3, str4);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public String a(Bundle bundle) {
        return !x.d(this.A) ? String.valueOf(a.a) : !x.a(this.A, t) ? String.valueOf(a.b) : !a() ? String.valueOf(a.e) : bundle != null ? this.y.a(bundle) : com.xiaomi.e.a.f;
    }

    public boolean a() {
        if (this.y != null) {
            return true;
        }
        g();
        return this.y != null;
    }

    public Bundle b(String str, String str2) {
        return (a() && this.y != null) ? this.y.b(str, str2) : null;
    }

    public Retobj b(String str) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.b(str);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public synchronized void b() {
        if (this.y != null) {
            this.A.unbindService(this.B);
            this.y = null;
        }
        x = null;
        this.A = null;
    }

    public Bundle c() {
        return (a() && this.y != null) ? this.y.a() : null;
    }

    public Retobj c(String str) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.c(str);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public Retobj c(String str, String str2) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.c(str, str2);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public Retobj d() {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.b();
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public Retobj d(String str) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.d(str);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public Retobj d(String str, String str2) {
        Retobj retobj = new Retobj();
        if (!x.d(this.A)) {
            retobj.a((int) a.a);
            return retobj;
        } else if (!x.a(this.A, t)) {
            retobj.a((int) a.b);
            return retobj;
        } else if (a()) {
            return this.y.d(str, str2);
        } else {
            retobj.a((int) a.e);
            return retobj;
        }
    }

    public void e() {
        int c = x.c(this.A);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(v, new Object[]{Integer.valueOf(c)})));
        intent.setFlags(268435456);
        this.A.startActivity(intent);
    }

    public String f() {
        return !x.d(this.A) ? String.valueOf(a.a) : !x.a(this.A, t) ? String.valueOf(a.b) : !a() ? String.valueOf(a.e) : this.y.c();
    }
}
