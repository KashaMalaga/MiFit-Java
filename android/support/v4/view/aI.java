package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.L;
import android.view.View;
import android.view.ViewParent;

class aI extends aG {
    aI() {
    }

    public int H(View view) {
        return aW.f(view);
    }

    public int I(View view) {
        return aW.g(view);
    }

    public boolean N(View view) {
        return aW.i(view);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        aW.a(view, i, i2, i3, i4);
    }

    public void a(View view, Runnable runnable) {
        aW.a(view, runnable);
    }

    public void a(View view, Runnable runnable, long j) {
        aW.a(view, runnable, j);
    }

    public void a(View view, boolean z) {
        aW.a(view, z);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return aW.a(view, i, bundle);
    }

    public void b(View view) {
        aW.h(view);
    }

    public void d(View view, int i) {
        if (i == 4) {
            i = 2;
        }
        aW.a(view, i);
    }

    public boolean g(View view) {
        return aW.a(view);
    }

    public void h(View view) {
        aW.b(view);
    }

    public int i(View view) {
        return aW.c(view);
    }

    public L j(View view) {
        Object d = aW.d(view);
        return d != null ? new L(d) : null;
    }

    public ViewParent o(View view) {
        return aW.e(view);
    }
}
