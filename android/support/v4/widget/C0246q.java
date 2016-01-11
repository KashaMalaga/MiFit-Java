package android.support.v4.widget;

import android.support.v4.view.C0125a;
import android.support.v4.view.a.C0113o;
import android.view.View;

final class C0246q extends C0125a {
    final /* synthetic */ DrawerLayout b;

    C0246q(DrawerLayout drawerLayout) {
        this.b = drawerLayout;
    }

    public void a(View view, C0113o c0113o) {
        super.a(view, c0113o);
        if (!DrawerLayout.n(view)) {
            c0113o.d(null);
        }
    }
}
