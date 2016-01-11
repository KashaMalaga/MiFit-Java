package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

class C0277w {
    int a;
    int b;
    boolean c;
    final /* synthetic */ LinearLayoutManager d;

    C0277w(LinearLayoutManager linearLayoutManager) {
        this.d = linearLayoutManager;
    }

    void a() {
        this.a = -1;
        this.b = af.a;
        this.c = false;
    }

    public void a(View view) {
        if (this.c) {
            this.b = this.d.n.b(view) + this.d.n.b();
        } else {
            this.b = this.d.n.a(view);
        }
        this.a = this.d.e(view);
    }

    public boolean a(View view, ag agVar) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.e() || layoutParams.g() < 0 || layoutParams.g() >= agVar.h()) {
            return false;
        }
        a(view);
        return true;
    }

    void b() {
        this.b = this.c ? this.d.n.d() : this.d.n.c();
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
    }
}
