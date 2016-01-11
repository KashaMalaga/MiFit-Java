package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v4.view.bK;
import android.view.View;

class C0268m extends C0265r {
    final /* synthetic */ aj a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ bK d;
    final /* synthetic */ C0261g e;

    C0268m(C0261g c0261g, aj ajVar, int i, int i2, bK bKVar) {
        this.e = c0261g;
        this.a = ajVar;
        this.b = i;
        this.c = i2;
        this.d = bKVar;
        super();
    }

    public void a(View view) {
        this.e.h(this.a);
    }

    public void b(View view) {
        this.d.a(null);
        this.e.e(this.a);
        this.e.j.remove(this.a);
        this.e.j();
    }

    public void c(View view) {
        if (this.b != 0) {
            C0151az.a(view, 0.0f);
        }
        if (this.c != 0) {
            C0151az.b(view, 0.0f);
        }
    }
}
