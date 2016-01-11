package com.c.b.i.b;

import java.io.Serializable;
import java.util.Comparator;

final class h implements Serializable, Comparator<d> {
    private final float a;

    private h(float f) {
        this.a = f;
    }

    public int a(d dVar, d dVar2) {
        float abs = Math.abs(dVar2.c() - this.a);
        float abs2 = Math.abs(dVar.c() - this.a);
        return abs < abs2 ? -1 : abs == abs2 ? 0 : 1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((d) obj, (d) obj2);
    }
}
