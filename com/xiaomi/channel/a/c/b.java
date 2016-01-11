package com.xiaomi.channel.a.c;

import android.os.Handler;
import android.os.Looper;

public class b {
    private c a;
    private Handler b;
    private volatile boolean c;
    private final boolean d;
    private volatile d e;

    public b() {
        this(false);
    }

    public b(boolean z) {
        this.b = null;
        this.c = false;
        this.b = new e(this, Looper.getMainLooper());
        this.d = z;
    }

    public synchronized void a(d dVar) {
        if (this.a == null) {
            this.a = new c(this);
            this.a.setDaemon(this.d);
            this.a.start();
        }
        this.a.a(dVar);
    }

    public void a(d dVar, long j) {
        this.b.postDelayed(new f(this, dVar), j);
    }
}
