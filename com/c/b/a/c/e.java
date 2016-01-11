package com.c.b.a.c;

import java.util.Comparator;

class e implements Comparator<g> {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public int a(g gVar, g gVar2) {
        return gVar.d() - gVar2.d();
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((g) obj, (g) obj2);
    }
}
