package org.apache.thrift.protocol;

import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;
import org.apache.thrift.f;

public class i {
    private static int a = Integer.MAX_VALUE;

    public static void a(f fVar, byte b) {
        a(fVar, b, a);
    }

    public static void a(f fVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new f("Maximum skip depth exceeded");
        }
        switch (b) {
            case a.k /*2*/:
                fVar.q();
                return;
            case a.l /*3*/:
                fVar.r();
                return;
            case a.aQ /*4*/:
                fVar.v();
                return;
            case a.bt /*6*/:
                fVar.s();
                return;
            case a.ba /*8*/:
                fVar.t();
                return;
            case a.bd /*10*/:
                fVar.u();
                return;
            case a.aW /*11*/:
                fVar.x();
                return;
            case a.be /*12*/:
                fVar.g();
                while (true) {
                    c i3 = fVar.i();
                    if (i3.b == (byte) 0) {
                        fVar.h();
                        return;
                    } else {
                        a(fVar, i3.b, i - 1);
                        fVar.j();
                    }
                }
            case t.WeightView_wv_bmi_size /*13*/:
                e k = fVar.k();
                while (i2 < k.c) {
                    a(fVar, k.a, i - 1);
                    a(fVar, k.b, i - 1);
                    i2++;
                }
                fVar.l();
                return;
            case t.WeightView_wv_tips /*14*/:
                j o = fVar.o();
                while (i2 < o.b) {
                    a(fVar, o.a, i - 1);
                    i2++;
                }
                fVar.p();
                return;
            case a.aV /*15*/:
                d m = fVar.m();
                while (i2 < m.b) {
                    a(fVar, m.a, i - 1);
                    i2++;
                }
                fVar.n();
                return;
            default:
                return;
        }
    }
}
