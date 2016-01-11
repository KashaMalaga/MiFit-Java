package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v4.view.bK;
import android.view.View;

class C0270o extends C0265r {
    final /* synthetic */ C0271p a;
    final /* synthetic */ bK b;
    final /* synthetic */ View c;
    final /* synthetic */ C0261g d;

    C0270o(C0261g c0261g, C0271p c0271p, bK bKVar, View view) {
        this.d = c0261g;
        this.a = c0271p;
        this.b = bKVar;
        this.c = view;
        super();
    }

    public void a(View view) {
        this.d.b(this.a.b, false);
    }

    public void b(View view) {
        this.b.a(null);
        C0151az.c(this.c, 1.0f);
        C0151az.a(this.c, 0.0f);
        C0151az.b(this.c, 0.0f);
        this.d.a(this.a.b, false);
        this.d.l.remove(this.a.b);
        this.d.j();
    }
}
