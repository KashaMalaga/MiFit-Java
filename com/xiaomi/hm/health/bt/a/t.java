package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.model.p;
import kankan.wheel.widget.a;

public class t extends C {
    private static final int b = 2;
    private int a = 0;

    public t(int i, d dVar) {
        super(dVar);
        this.a = i;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        p x = this.q.x();
        C0596r.d(p, "set latency:" + this.a + "\ncurrent latency:\n" + x);
        if (x != null) {
            if (this.a == 39) {
                if (x.e <= 60) {
                    dVar.c(Integer.valueOf(8));
                    C0596r.d(p, "same latency,return now!!!");
                    return;
                }
            } else if (this.a == a.ax) {
                if (x.e >= a.aA && x.e <= a.aB) {
                    dVar.c(Integer.valueOf(8));
                    C0596r.d(p, "same latency,return now!!!");
                    return;
                }
            } else if (x.e == this.a) {
                C0596r.d(p, "same latency,return now!!!");
                return;
            }
        }
        C0596r.d(p, "======================do set latency  in======================");
        int i = 0;
        boolean z = false;
        while (true) {
            int i2 = i + 1;
            if (i >= b) {
                break;
            }
            if (this.a == 39) {
                z = this.q.a(39, 49, 0, (int) a.aB, 0);
            } else if (this.a == a.ax) {
                z = this.q.a((int) a.aA, (int) a.aB, 0, (int) a.aB, 0);
            } else if (this.a > 0) {
                z = this.q.a(this.a, this.a, 0, (int) a.aB, 0);
            }
            if (z) {
                break;
            }
            i = i2;
        }
        C0596r.d(p, "======================do set latency out======================");
        if (dVar != null) {
            dVar.c(Integer.valueOf(z ? 8 : -1));
        }
    }
}
