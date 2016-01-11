package android.support.v7.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public class af {
    public static final int a = Integer.MIN_VALUE;
    private int b;
    private int c;
    private int d;
    private Interpolator e;
    private boolean f;
    private int g;

    public af(int i, int i2) {
        this(i, i2, a, null);
    }

    public af(int i, int i2, int i3) {
        this(i, i2, i3, null);
    }

    public af(int i, int i2, int i3, Interpolator interpolator) {
        this.f = false;
        this.g = 0;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = interpolator;
    }

    private void a(RecyclerView recyclerView) {
        if (this.f) {
            e();
            if (this.e != null) {
                recyclerView.ak.a(this.b, this.c, this.d, this.e);
            } else if (this.d == a) {
                recyclerView.ak.b(this.b, this.c);
            } else {
                recyclerView.ak.a(this.b, this.c, this.d);
            }
            this.g++;
            if (this.g > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.f = false;
            return;
        }
        this.g = 0;
    }

    private void e() {
        if (this.e != null && this.d < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (this.d < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.f = true;
        this.b = i;
    }

    public void a(int i, int i2, int i3, Interpolator interpolator) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = interpolator;
        this.f = true;
    }

    public void a(Interpolator interpolator) {
        this.f = true;
        this.e = interpolator;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.f = true;
        this.c = i;
    }

    public int c() {
        return this.d;
    }

    public void c(int i) {
        this.f = true;
        this.d = i;
    }

    public Interpolator d() {
        return this.e;
    }
}
