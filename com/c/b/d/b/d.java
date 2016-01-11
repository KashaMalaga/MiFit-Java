package com.c.b.d.b;

import java.io.Serializable;
import java.util.Comparator;

final class d implements Serializable, Comparator<c> {
    private d() {
    }

    public int a(c cVar, c cVar2) {
        return cVar.c() - cVar2.c();
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((c) obj, (c) obj2);
    }
}
