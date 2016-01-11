package com.e.a;

import android.view.animation.Interpolator;

public abstract class C1051q implements Cloneable {
    float a;
    Class b;
    boolean c = false;
    private Interpolator d = null;

    public static C1051q a(float f) {
        return new C1053s(f);
    }

    public static C1051q a(float f, float f2) {
        return new C1052r(f, f2);
    }

    public static C1051q a(float f, int i) {
        return new C1053s(f, i);
    }

    public static C1051q a(float f, Object obj) {
        return new C1054t(f, obj);
    }

    public static C1051q b(float f) {
        return new C1052r(f);
    }

    public static C1051q c(float f) {
        return new C1054t(f, null);
    }

    public void a(Interpolator interpolator) {
        this.d = interpolator;
    }

    public abstract void a(Object obj);

    public boolean a() {
        return this.c;
    }

    public abstract Object b();

    public float c() {
        return this.a;
    }

    public /* synthetic */ Object clone() {
        return f();
    }

    public Interpolator d() {
        return this.d;
    }

    public void d(float f) {
        this.a = f;
    }

    public Class e() {
        return this.b;
    }

    public abstract C1051q f();
}
