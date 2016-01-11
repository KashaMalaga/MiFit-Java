package com.e.c;

import android.view.View;
import com.e.a.C1034a;
import com.e.a.C1035b;
import com.e.a.R;
import com.e.a.Y;
import java.util.ArrayList;

class f implements Y, C1035b {
    final /* synthetic */ d a;

    private f(d dVar) {
        this.a = dVar;
    }

    public void a(R r) {
        float z = r.z();
        h hVar = (h) this.a.x.get(r);
        if ((hVar.a & 511) != 0) {
            View view = (View) this.a.b.get();
            if (view != null) {
                view.invalidate();
            }
        }
        ArrayList arrayList = hVar.b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                g gVar = (g) arrayList.get(i);
                this.a.c(gVar.a, gVar.b + (gVar.c * z));
            }
        }
        View view2 = (View) this.a.b.get();
        if (view2 != null) {
            view2.invalidate();
        }
    }

    public void a(C1034a c1034a) {
        if (this.a.i != null) {
            this.a.i.a(c1034a);
        }
    }

    public void b(C1034a c1034a) {
        if (this.a.i != null) {
            this.a.i.b(c1034a);
        }
        this.a.x.remove(c1034a);
        if (this.a.x.isEmpty()) {
            this.a.i = null;
        }
    }

    public void c(C1034a c1034a) {
        if (this.a.i != null) {
            this.a.i.c(c1034a);
        }
    }

    public void d(C1034a c1034a) {
        if (this.a.i != null) {
            this.a.i.d(c1034a);
        }
    }
}
