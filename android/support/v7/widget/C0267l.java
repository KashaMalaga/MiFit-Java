package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v4.view.bK;
import android.view.View;

class C0267l extends C0265r {
    final /* synthetic */ aj a;
    final /* synthetic */ bK b;
    final /* synthetic */ C0261g c;

    C0267l(C0261g c0261g, aj ajVar, bK bKVar) {
        this.c = c0261g;
        this.a = ajVar;
        this.b = bKVar;
        super();
    }

    public void a(View view) {
        this.c.i(this.a);
    }

    public void b(View view) {
        this.b.a(null);
        this.c.f(this.a);
        this.c.i.remove(this.a);
        this.c.j();
    }

    public void c(View view) {
        C0151az.c(view, 1.0f);
    }
}
