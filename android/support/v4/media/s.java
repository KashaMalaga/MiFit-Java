package android.support.v4.media;

import android.os.Build.VERSION;

public abstract class s {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private final int d;
    private final int e;
    private int f;
    private u g;
    private Object h;

    public s(int i, int i2, int i3) {
        this.d = i;
        this.e = i2;
        this.f = i3;
    }

    public final int a() {
        return this.f;
    }

    public final void a(int i) {
        if (this.g != null) {
            this.g.a(this);
        }
    }

    public void a(u uVar) {
        this.g = uVar;
    }

    public final int b() {
        return this.d;
    }

    public void b(int i) {
    }

    public final int c() {
        return this.e;
    }

    public void c(int i) {
    }

    public Object d() {
        if (this.h != null || VERSION.SDK_INT < 21) {
            return this.h;
        }
        this.h = v.a(this.d, this.e, this.f, new t(this));
        return this.h;
    }
}
