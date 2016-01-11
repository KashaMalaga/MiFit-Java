package cn.com.smartdevices.bracelet.gps.f;

import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

final class q implements A {
    final /* synthetic */ n a;

    private q(n nVar) {
        this.a = nVar;
    }

    public void a(c cVar, int i) {
        switch (i) {
            case a.k /*2*/:
                this.a.f(cVar);
                return;
            default:
                return;
        }
    }

    public void a(List<c> list, g gVar) {
        switch (gVar.j) {
            case a.i /*0*/:
                this.a.m();
                this.a.a((List) list, gVar);
                return;
            default:
                return;
        }
    }

    public void a(List<c> list, g gVar, boolean z) {
        switch (gVar.j) {
            case l.a /*1*/:
                if (z) {
                    this.a.m();
                    this.a.g = this.a.a((List) list, gVar);
                    return;
                } else if (this.a.g == null) {
                    this.a.g = this.a.a((List) list, gVar);
                    return;
                } else {
                    this.a.g.setPoints(cn.com.smartdevices.bracelet.gps.h.a.a((List) list));
                    return;
                }
            default:
                return;
        }
    }
}
