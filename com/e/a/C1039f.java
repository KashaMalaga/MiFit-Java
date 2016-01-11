package com.e.a;

import java.util.ArrayList;

class C1039f extends C1037d {
    boolean a = false;
    final /* synthetic */ C1038e b;
    private final /* synthetic */ ArrayList c;

    C1039f(C1038e c1038e, ArrayList arrayList) {
        this.b = c1038e;
        this.c = arrayList;
    }

    public void b(C1034a c1034a) {
        if (!this.a) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                C1044k c1044k = (C1044k) this.c.get(i);
                c1044k.a.start();
                this.b.c.add(c1044k.a);
            }
        }
    }

    public void c(C1034a c1034a) {
        this.a = true;
    }
}
