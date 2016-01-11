package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class C0262h implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ C0261g b;

    C0262h(C0261g c0261g, ArrayList arrayList) {
        this.b = c0261g;
        this.a = arrayList;
    }

    public void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            C0272q c0272q = (C0272q) it.next();
            this.b.b(c0272q.a, c0272q.b, c0272q.c, c0272q.d, c0272q.e);
        }
        this.a.clear();
        this.b.g.remove(this.a);
    }
}
