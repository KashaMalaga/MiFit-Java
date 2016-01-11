package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

final class E extends D {
    E(W w) {
        super(w);
    }

    public int a(View view) {
        return this.a.n(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public void a(int i) {
        this.a.i(i);
    }

    public void a(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + this.a.p(view);
    }

    public int c() {
        return this.a.B();
    }

    public int c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.l(view) + layoutParams.leftMargin);
    }

    public int d() {
        return this.a.z() - this.a.D();
    }

    public int d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.m(view) + layoutParams.topMargin);
    }

    public int e() {
        return this.a.z();
    }

    public int f() {
        return (this.a.z() - this.a.B()) - this.a.D();
    }

    public int g() {
        return this.a.D();
    }
}
