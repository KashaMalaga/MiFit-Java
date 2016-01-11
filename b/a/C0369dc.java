package b.a;

import android.support.v4.view.a.C0113o;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;

public class C0369dc {
    private static int a = Integer.MAX_VALUE;

    public static db a(byte[] bArr, db dbVar) {
        return bArr[0] > C0374dh.n ? new cR() : (bArr.length <= 1 || (bArr[1] & C0113o.h) == 0) ? dbVar : new cR();
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(cY cYVar, byte b) {
        C0369dc.a(cYVar, b, a);
    }

    public static void a(cY cYVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new C0339cy("Maximum skip depth exceeded");
        }
        switch (b) {
            case a.k /*2*/:
                cYVar.t();
                return;
            case a.l /*3*/:
                cYVar.u();
                return;
            case a.aQ /*4*/:
                cYVar.y();
                return;
            case a.bt /*6*/:
                cYVar.v();
                return;
            case a.ba /*8*/:
                cYVar.w();
                return;
            case a.bd /*10*/:
                cYVar.x();
                return;
            case a.aW /*11*/:
                cYVar.A();
                return;
            case a.be /*12*/:
                cYVar.j();
                while (true) {
                    cT l = cYVar.l();
                    if (l.b == (byte) 0) {
                        cYVar.k();
                        return;
                    } else {
                        C0369dc.a(cYVar, l.b, i - 1);
                        cYVar.m();
                    }
                }
            case t.WeightView_wv_bmi_size /*13*/:
                cV n = cYVar.n();
                while (i2 < n.c) {
                    C0369dc.a(cYVar, n.a, i - 1);
                    C0369dc.a(cYVar, n.b, i - 1);
                    i2++;
                }
                cYVar.o();
                return;
            case t.WeightView_wv_tips /*14*/:
                C0370dd r = cYVar.r();
                while (i2 < r.b) {
                    C0369dc.a(cYVar, r.a, i - 1);
                    i2++;
                }
                cYVar.s();
                return;
            case a.aV /*15*/:
                cU p = cYVar.p();
                while (i2 < p.b) {
                    C0369dc.a(cYVar, p.a, i - 1);
                    i2++;
                }
                cYVar.q();
                return;
            default:
                return;
        }
    }
}
