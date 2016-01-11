package com.xiaomi.hm.health.bt.profile.a;

import android.os.Handler;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.xiaomi.hm.health.bt.a.g;

public class d {
    private final String a;
    private final int b;
    private final int c;
    private Handler d;

    public d() {
        this.a = "MiLiHeartRate";
        this.b = 0;
        this.c = a.k;
        this.d = null;
        this.d = new e(this);
    }

    public void a(boolean z, com.xiaomi.hm.health.bt.a.d dVar) {
        new g(g.SLEEP.a(), (z ? h.OPEN : h.CLOSE).a(), dVar).g();
    }

    public void b(boolean z, com.xiaomi.hm.health.bt.a.d dVar) {
        new g(g.MANUAL.a(), (z ? h.OPEN : h.CLOSE).a(), dVar).g();
    }

    public void c(boolean z, com.xiaomi.hm.health.bt.a.d dVar) {
        new g(g.CONTINUOUS.a(), (z ? h.OPEN : h.CLOSE).a(), dVar).g();
        if (z) {
            this.d.sendEmptyMessageDelayed(0, 15000);
        } else {
            this.d.removeCallbacksAndMessages(null);
        }
    }
}
