package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public class C0219am {
    static final int c = 16;
    private static final String d = "ScrollerCompat";
    Object a;
    C0220an b;

    private C0219am(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.b = new C0223aq();
        } else if (i >= 9) {
            this.b = new C0222ap();
        } else {
            this.b = new C0221ao();
        }
        this.a = this.b.a(context, interpolator);
    }

    C0219am(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    public static C0219am a(Context context) {
        return C0219am.a(context, null);
    }

    public static C0219am a(Context context, Interpolator interpolator) {
        return new C0219am(context, interpolator);
    }

    public void a(int i, int i2, int i3) {
        this.b.a(this.a, i, i2, i3);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.b.a(this.a, i, i2, i3, i4);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.b.a(this.a, i, i2, i3, i4, i5);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.b.a(this.a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.b.a(this.a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean a() {
        return this.b.a(this.a);
    }

    public int b() {
        return this.b.b(this.a);
    }

    public void b(int i, int i2, int i3) {
        this.b.b(this.a, i, i2, i3);
    }

    public int c() {
        return this.b.c(this.a);
    }

    public int d() {
        return this.b.h(this.a);
    }

    public int e() {
        return this.b.i(this.a);
    }

    public float f() {
        return this.b.d(this.a);
    }

    public boolean g() {
        return this.b.e(this.a);
    }

    public void h() {
        this.b.f(this.a);
    }

    public boolean i() {
        return this.b.g(this.a);
    }
}
