package com.xiaomi.hm.view;

import android.os.SystemClock;

class c implements Runnable {
    final /* synthetic */ b a;

    private c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        int b = this.a.a.b();
        if (!this.a.b) {
            if (b > 0) {
                SystemClock.sleep((long) b);
            }
            synchronized (this.a.d) {
                if (!this.a.b) {
                    this.a.c.post(this.a.d);
                }
            }
        }
    }
}
