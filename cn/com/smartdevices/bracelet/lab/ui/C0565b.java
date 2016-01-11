package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Handler;
import android.os.SystemClock;

public abstract class C0565b {
    private static final int c = 1;
    private final long a;
    private long b;
    private final Handler d = new C0567c(this);

    public C0565b(long j, String str) {
        this.a = j;
    }

    public final void a() {
        this.d.removeMessages(c);
    }

    public abstract void b();

    public final synchronized C0565b start() {
        C0565b c0565b;
        if (this.a <= 0) {
            b();
            c0565b = this;
        } else {
            this.b = SystemClock.elapsedRealtime() + this.a;
            this.d.removeMessages(c);
            this.d.sendMessage(this.d.obtainMessage(c));
            c0565b = this;
        }
        return c0565b;
    }
}
