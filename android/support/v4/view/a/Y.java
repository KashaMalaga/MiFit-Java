package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Parcelable;
import android.view.View;
import java.util.List;

public class Y {
    private static final ab a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new ac();
        } else if (VERSION.SDK_INT >= 15) {
            a = new aa();
        } else if (VERSION.SDK_INT >= 14) {
            a = new Z();
        } else {
            a = new ad();
        }
    }

    public Y(Object obj) {
        this.b = obj;
    }

    public static Y a(Y y) {
        return new Y(a.a(y.b));
    }

    public static Y b() {
        return new Y(a.a());
    }

    public Object a() {
        return this.b;
    }

    public void a(int i) {
        a.d(this.b, i);
    }

    public void a(Parcelable parcelable) {
        a.a(this.b, parcelable);
    }

    public void a(View view) {
        a.a(this.b, view);
    }

    public void a(View view, int i) {
        a.a(this.b, view, i);
    }

    public void a(CharSequence charSequence) {
        a.b(this.b, charSequence);
    }

    public void a(boolean z) {
        a.a(this.b, z);
    }

    public void b(int i) {
        a.b(this.b, i);
    }

    public void b(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public void b(boolean z) {
        a.b(this.b, z);
    }

    public C0113o c() {
        return a.m(this.b);
    }

    public void c(int i) {
        a.c(this.b, i);
    }

    public void c(CharSequence charSequence) {
        a.c(this.b, charSequence);
    }

    public void c(boolean z) {
        a.d(this.b, z);
    }

    public int d() {
        return a.p(this.b);
    }

    public void d(int i) {
        a.h(this.b, i);
    }

    public void d(boolean z) {
        a.c(this.b, z);
    }

    public void e(int i) {
        a.f(this.b, i);
    }

    public void e(boolean z) {
        a.e(this.b, z);
    }

    public boolean e() {
        return a.q(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Y y = (Y) obj;
        return this.b == null ? y.b == null : this.b.equals(y.b);
    }

    public void f(int i) {
        a.g(this.b, i);
    }

    public boolean f() {
        return a.r(this.b);
    }

    public void g(int i) {
        a.i(this.b, i);
    }

    public boolean g() {
        return a.t(this.b);
    }

    public void h(int i) {
        a.j(this.b, i);
    }

    public boolean h() {
        return a.s(this.b);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public void i(int i) {
        a.a(this.b, i);
    }

    public boolean i() {
        return a.u(this.b);
    }

    public int j() {
        return a.h(this.b);
    }

    public void j(int i) {
        a.e(this.b, i);
    }

    public int k() {
        return a.f(this.b);
    }

    public int l() {
        return a.g(this.b);
    }

    public int m() {
        return a.o(this.b);
    }

    public int n() {
        return a.k(this.b);
    }

    public int o() {
        return a.l(this.b);
    }

    public int p() {
        return a.w(this.b);
    }

    public int q() {
        return a.x(this.b);
    }

    public int r() {
        return a.b(this.b);
    }

    public int s() {
        return a.j(this.b);
    }

    public CharSequence t() {
        return a.d(this.b);
    }

    public List<CharSequence> u() {
        return a.n(this.b);
    }

    public CharSequence v() {
        return a.c(this.b);
    }

    public CharSequence w() {
        return a.e(this.b);
    }

    public Parcelable x() {
        return a.i(this.b);
    }

    public void y() {
        a.v(this.b);
    }
}
