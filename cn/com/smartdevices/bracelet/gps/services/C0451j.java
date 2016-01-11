package cn.com.smartdevices.bracelet.gps.services;

import android.os.Handler;
import android.os.SystemClock;

public abstract class C0451j {
    private static final int c = 1;
    private final long a;
    private long b;
    private final Handler d = new C0452k(this);

    public C0451j(long j, String str) {
        this.a = j;
    }

    public final void a() {
        this.d.removeMessages(c);
    }

    public abstract void b();

    public final synchronized C0451j start() {
        C0451j c0451j;
        if (this.a <= 0) {
            b();
            c0451j = this;
        } else {
            this.b = SystemClock.elapsedRealtime() + this.a;
            this.d.removeMessages(c);
            this.d.sendMessage(this.d.obtainMessage(c));
            c0451j = this;
        }
        return c0451j;
    }
}
