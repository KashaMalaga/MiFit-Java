package com.e.c;

import android.view.View;
import com.e.a.C1034a;
import com.e.a.C1035b;
import com.e.a.R;
import com.e.a.Y;
import java.util.ArrayList;

class m implements Y, C1035b {
    final /* synthetic */ k a;

    private m(k kVar) {
        this.a = kVar;
    }

    public void a(R r) {
        float z = r.z();
        o oVar = (o) this.a.y.get(r);
        if ((oVar.a & 511) != 0) {
            View view = (View) this.a.c.get();
            if (view != null) {
                view.invalidate();
            }
        }
        ArrayList arrayList = oVar.b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                n nVar = (n) arrayList.get(i);
                this.a.c(nVar.a, nVar.b + (nVar.c * z));
            }
        }
        View view2 = (View) this.a.c.get();
        if (view2 != null) {
            view2.invalidate();
        }
    }

    public void a(C1034a c1034a) {
        if (this.a.j != null) {
            this.a.j.a(c1034a);
        }
    }

    public void b(C1034a c1034a) {
        if (this.a.j != null) {
            this.a.j.b(c1034a);
        }
        this.a.y.remove(c1034a);
        if (this.a.y.isEmpty()) {
            this.a.j = null;
        }
    }

    public void c(C1034a c1034a) {
        if (this.a.j != null) {
            this.a.j.c(c1034a);
        }
    }

    public void d(C1034a c1034a) {
        if (this.a.j != null) {
            this.a.j.d(c1034a);
        }
    }
}
