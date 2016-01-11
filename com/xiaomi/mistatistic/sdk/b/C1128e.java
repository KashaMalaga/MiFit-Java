package com.xiaomi.mistatistic.sdk.b;

import android.os.Handler;
import android.os.Looper;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class C1128e {
    private static C1128e a = null;
    private int b = 3;
    private long c;
    private long d;
    private Handler e = new C1129f(this, Looper.getMainLooper());

    private C1128e() {
    }

    public static synchronized C1128e a() {
        C1128e c1128e;
        synchronized (C1128e.class) {
            if (a == null) {
                a = new C1128e();
            }
            c1128e = a;
        }
        return c1128e;
    }

    public void a(int i, long j) {
        m.a().a(new C1133j(this, i, j));
    }

    public void b() {
        m.a().a(new C1132i(this));
        this.e.sendEmptyMessageDelayed(2, 5000);
    }

    public void c() {
        if (this.b == 4) {
            if (!this.e.hasMessages(1)) {
                this.e.sendEmptyMessageDelayed(1, this.c);
            }
        } else if (!this.e.hasMessages(1)) {
            this.e.sendEmptyMessage(1);
        }
    }

    public void d() {
        this.d = System.currentTimeMillis();
        m.b().a(new l(this));
    }

    public boolean e() {
        if (F.b()) {
            return false;
        }
        switch (this.b) {
            case a.i /*0*/:
                return true;
            case l.a /*1*/:
                return C.a(C1125b.a());
            case a.k /*2*/:
                return new t().d() >= 50;
            case a.aQ /*4*/:
                return System.currentTimeMillis() - this.d > this.c;
            default:
                return false;
        }
    }

    public long f() {
        return this.c;
    }
}
