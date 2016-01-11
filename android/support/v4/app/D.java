package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class D implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ F b;
    final /* synthetic */ int c;
    final /* synthetic */ Object d;
    final /* synthetic */ A e;

    D(A a, View view, F f, int i, Object obj) {
        this.e = a;
        this.a = view;
        this.b = f;
        this.c = i;
        this.d = obj;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.e.a(this.b, this.c, this.d);
        return true;
    }
}
