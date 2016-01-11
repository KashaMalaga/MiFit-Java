package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v4.view.bK;
import android.view.View;

class C0269n extends C0265r {
    final /* synthetic */ C0271p a;
    final /* synthetic */ bK b;
    final /* synthetic */ C0261g c;

    C0269n(C0261g c0261g, C0271p c0271p, bK bKVar) {
        this.c = c0261g;
        this.a = c0271p;
        this.b = bKVar;
        super();
    }

    public void a(View view) {
        this.c.b(this.a.a, true);
    }

    public void b(View view) {
        this.b.a(null);
        C0151az.c(view, 1.0f);
        C0151az.a(view, 0.0f);
        C0151az.b(view, 0.0f);
        this.c.a(this.a.a, true);
        this.c.l.remove(this.a.a);
        this.c.j();
    }
}
