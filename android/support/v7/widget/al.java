package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0125a;
import android.support.v4.view.a.C0113o;
import android.view.View;

class al extends C0125a {
    final /* synthetic */ ak b;

    al(ak akVar) {
        this.b = akVar;
    }

    public void a(View view, C0113o c0113o) {
        super.a(view, c0113o);
        if (this.b.b.e() != null) {
            this.b.b.e().a(view, c0113o);
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        return super.a(view, i, bundle) ? true : this.b.b.e() != null ? this.b.b.e().a(view, i, bundle) : false;
    }
}
