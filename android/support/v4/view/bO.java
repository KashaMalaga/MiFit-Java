package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class bO extends bM {
    WeakHashMap<View, Integer> b = null;

    bO() {
    }

    public long a(bK bKVar, View view) {
        return bU.a(view);
    }

    public void a(bK bKVar, View view, float f) {
        bU.a(view, f);
    }

    public void a(bK bKVar, View view, long j) {
        bU.a(view, j);
    }

    public void a(bK bKVar, View view, cb cbVar) {
        view.setTag(2113929216, cbVar);
        bU.a(view, new bP(bKVar));
    }

    public void a(bK bKVar, View view, Interpolator interpolator) {
        bU.a(view, interpolator);
    }

    public void a(bK bKVar, View view, Runnable runnable) {
        bU.a(view, new bP(bKVar));
        bKVar.f = runnable;
    }

    public void b(bK bKVar, View view, float f) {
        bU.b(view, f);
    }

    public void b(bK bKVar, View view, long j) {
        bU.b(view, j);
    }

    public void b(bK bKVar, View view, Runnable runnable) {
        bU.a(view, new bP(bKVar));
        bKVar.e = runnable;
    }

    public long c(bK bKVar, View view) {
        return bU.b(view);
    }

    public void c(bK bKVar, View view, float f) {
        bU.c(view, f);
    }

    public void d(bK bKVar, View view) {
        bU.c(view);
    }

    public void d(bK bKVar, View view, float f) {
        bU.d(view, f);
    }

    public void e(bK bKVar, View view) {
        bKVar.g = C0151az.h(view);
        bU.a(view, new bP(bKVar));
    }

    public void e(bK bKVar, View view, float f) {
        bU.e(view, f);
    }

    public void f(bK bKVar, View view, float f) {
        bU.f(view, f);
    }

    public void g(bK bKVar, View view, float f) {
        bU.g(view, f);
    }

    public void h(bK bKVar, View view, float f) {
        bU.h(view, f);
    }

    public void i(bK bKVar, View view, float f) {
        bU.i(view, f);
    }

    public void j(bK bKVar, View view, float f) {
        bU.j(view, f);
    }

    public void k(bK bKVar, View view, float f) {
        bU.k(view, f);
    }

    public void l(bK bKVar, View view, float f) {
        bU.l(view, f);
    }

    public void m(bK bKVar, View view, float f) {
        bU.m(view, f);
    }

    public void n(bK bKVar, View view, float f) {
        bU.n(view, f);
    }

    public void o(bK bKVar, View view, float f) {
        bU.o(view, f);
    }

    public void p(bK bKVar, View view, float f) {
        bU.p(view, f);
    }

    public void q(bK bKVar, View view, float f) {
        bU.q(view, f);
    }

    public void r(bK bKVar, View view, float f) {
        bU.r(view, f);
    }

    public void s(bK bKVar, View view, float f) {
        bU.s(view, f);
    }

    public void start(bK bKVar, View view) {
        bU.start(view);
    }

    public void t(bK bKVar, View view, float f) {
        bU.t(view, f);
    }
}
