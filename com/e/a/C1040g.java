package com.e.a;

import java.util.ArrayList;

class C1040g implements C1035b {
    final /* synthetic */ C1038e a;
    private C1038e b;

    C1040g(C1038e c1038e, C1038e c1038e2) {
        this.a = c1038e;
        this.b = c1038e2;
    }

    public void a(C1034a c1034a) {
    }

    public void b(C1034a c1034a) {
        c1034a.b((C1035b) this);
        this.a.c.remove(c1034a);
        ((C1044k) this.b.d.get(c1034a)).f = true;
        if (!this.a.b) {
            int i;
            boolean z;
            ArrayList c = this.b.f;
            int size = c.size();
            for (i = 0; i < size; i++) {
                if (!((C1044k) c.get(i)).f) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                if (this.a.a != null) {
                    ArrayList arrayList = (ArrayList) this.a.a.clone();
                    int size2 = arrayList.size();
                    for (i = 0; i < size2; i++) {
                        ((C1035b) arrayList.get(i)).b(this.b);
                    }
                }
                this.b.i = false;
            }
        }
    }

    public void c(C1034a c1034a) {
        if (!this.a.b && this.a.c.size() == 0 && this.a.a != null) {
            int size = this.a.a.size();
            for (int i = 0; i < size; i++) {
                ((C1035b) this.a.a.get(i)).c(this.b);
            }
        }
    }

    public void d(C1034a c1034a) {
    }
}
