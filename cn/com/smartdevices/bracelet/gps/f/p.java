package cn.com.smartdevices.bracelet.gps.f;

import cn.com.smartdevices.bracelet.gps.model.c;

final class p {
    boolean a;
    c b;
    c c;
    c d;
    c e;
    final /* synthetic */ n f;

    p(n nVar, double d, double d2, double d3) {
        this.f = nVar;
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.b = new c(d, d2, d3);
        this.d = new c(d, d2, d3);
        this.c = new c(d, d2, d3);
        this.e = new c(d, d2, d3);
    }

    p(n nVar, c cVar) {
        this(nVar, cVar.p, cVar.q, cVar.o);
    }
}
