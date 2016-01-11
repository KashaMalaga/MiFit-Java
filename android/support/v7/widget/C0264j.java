package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class C0264j implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ C0261g b;

    C0264j(C0261g c0261g, ArrayList arrayList) {
        this.b = c0261g;
        this.a = arrayList;
    }

    public void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            this.b.q((aj) it.next());
        }
        this.a.clear();
        this.b.f.remove(this.a);
    }
}
