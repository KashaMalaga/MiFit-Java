package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v4.view.bK;
import android.view.View;

class C0266k extends C0265r {
    final /* synthetic */ aj a;
    final /* synthetic */ bK b;
    final /* synthetic */ C0261g c;

    C0266k(C0261g c0261g, aj ajVar, bK bKVar) {
        this.c = c0261g;
        this.a = ajVar;
        this.b = bKVar;
        super();
    }

    public void a(View view) {
        this.c.g(this.a);
    }

    public void b(View view) {
        this.b.a(null);
        C0151az.c(view, 1.0f);
        this.c.d(this.a);
        this.c.k.remove(this.a);
        this.c.j();
    }
}
