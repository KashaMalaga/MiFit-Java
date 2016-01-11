package com.c.b.f.a.a;

import java.io.Serializable;
import java.util.Comparator;

final class d implements Serializable, Comparator<com.c.b.i.b.d> {
    private d() {
    }

    public int a(com.c.b.i.b.d dVar, com.c.b.i.b.d dVar2) {
        float c = dVar2.c() - dVar.c();
        return ((double) c) < 0.0d ? -1 : ((double) c) > 0.0d ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((com.c.b.i.b.d) obj, (com.c.b.i.b.d) obj2);
    }
}
