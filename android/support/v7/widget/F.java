package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

final class F extends D {
    F(W w) {
        super(w);
    }

    public int a(View view) {
        return this.a.o(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
    }

    public void a(int i) {
        this.a.j(i);
    }

    public void a(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + this.a.q(view);
    }

    public int c() {
        return this.a.C();
    }

    public int c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.m(view) + layoutParams.topMargin);
    }

    public int d() {
        return this.a.A() - this.a.E();
    }

    public int d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.l(view) + layoutParams.leftMargin);
    }

    public int e() {
        return this.a.A();
    }

    public int f() {
        return (this.a.A() - this.a.C()) - this.a.E();
    }

    public int g() {
        return this.a.E();
    }
}
