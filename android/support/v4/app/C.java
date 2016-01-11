package android.support.v4.app;

import android.support.v4.l.a;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

class C implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ F d;
    final /* synthetic */ boolean e;
    final /* synthetic */ Fragment f;
    final /* synthetic */ Fragment g;
    final /* synthetic */ A h;

    C(A a, View view, Object obj, ArrayList arrayList, F f, boolean z, Fragment fragment, Fragment fragment2) {
        this.h = a;
        this.a = view;
        this.b = obj;
        this.c = arrayList;
        this.d = f;
        this.e = z;
        this.f = fragment;
        this.g = fragment2;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            C0025al.a(this.b, this.c);
            this.c.clear();
            a a = this.h.a(this.d, this.e, this.f);
            if (a.isEmpty()) {
                this.c.add(this.d.d);
            } else {
                this.c.addAll(a.values());
            }
            C0025al.b(this.b, this.c);
            this.h.a(a, this.d);
            this.h.a(this.d, this.f, this.g, this.e, a);
        }
        return true;
    }
}
