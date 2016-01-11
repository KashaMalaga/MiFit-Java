package android.support.v7.widget;

import android.view.View;

public abstract class D {
    public static final int b = 0;
    public static final int c = 1;
    private static final int d = Integer.MIN_VALUE;
    protected final W a;
    private int e;

    private D(W w) {
        this.e = d;
        this.a = w;
    }

    public static D a(W w) {
        return new E(w);
    }

    public static D a(W w, int i) {
        switch (i) {
            case b /*0*/:
                return a(w);
            case c /*1*/:
                return b(w);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static D b(W w) {
        return new F(w);
    }

    public abstract int a(View view);

    public void a() {
        this.e = f();
    }

    public abstract void a(int i);

    public abstract void a(View view, int i);

    public int b() {
        return d == this.e ? b : f() - this.e;
    }

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();
}
