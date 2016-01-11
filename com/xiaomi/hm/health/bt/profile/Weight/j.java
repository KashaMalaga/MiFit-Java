package com.xiaomi.hm.health.bt.profile.Weight;

import com.xiaomi.hm.health.bt.d.b;

class j implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    j(f fVar, b bVar, String str) {
        this.c = fVar;
        this.a = bVar;
        this.b = str;
    }

    public void run() {
        if (this.a != null) {
            this.a.onStart(0);
        }
        this.c.b(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int a = this.c.b(this.b, this.a);
        if (this.a != null) {
            this.a.onStop(a);
        }
    }
}
