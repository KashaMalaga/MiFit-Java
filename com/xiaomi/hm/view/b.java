package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.Looper;

public class b {
    private h a = null;
    private boolean b = false;
    private Handler c = new Handler(Looper.getMainLooper());
    private c d = new c();

    public void a() {
        synchronized (this.d) {
            this.c.removeCallbacks(this.d);
            this.b = true;
        }
    }

    public void a(h hVar) {
        this.a = hVar;
    }

    public void b() {
        synchronized (this.d) {
            this.b = false;
            this.c.post(this.d);
        }
    }

    public void c() {
        a();
    }

    public void d() {
        this.b = false;
        this.c.post(this.d);
    }

    public void e() {
        c();
        this.a = null;
    }
}
