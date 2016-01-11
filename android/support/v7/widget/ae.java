package android.support.v7.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;

public abstract class ae {
    private int a = -1;
    private RecyclerView b;
    private W c;
    private boolean d;
    private boolean e;
    private View f;
    private final af g = new af(0, 0);

    private void a(int i, int i2) {
        if (!this.e || this.a == -1) {
            stop();
        }
        this.d = false;
        if (this.f != null) {
            if (a(this.f) == this.a) {
                a(this.f, this.b.p, this.g);
                this.g.a(this.b);
                stop();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f = null;
            }
        }
        if (this.e) {
            a(i, i2, this.b.p, this.g);
            this.g.a(this.b);
        }
    }

    public int a(View view) {
        return this.b.c(view);
    }

    protected abstract void a();

    protected abstract void a(int i, int i2, ag agVar, af afVar);

    protected void a(PointF pointF) {
        double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
        pointF.x = (float) (((double) pointF.x) / sqrt);
        pointF.y = (float) (((double) pointF.y) / sqrt);
    }

    protected abstract void a(View view, ag agVar, af afVar);

    protected abstract void b();

    protected void b(View view) {
        if (a(view) == h()) {
            this.f = view;
        }
    }

    public void d(int i) {
        this.a = i;
    }

    public W e() {
        return this.c;
    }

    public View e(int i) {
        return this.b.D.c(i);
    }

    public void f(int i) {
        this.b.c(i);
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.e;
    }

    public int h() {
        return this.a;
    }

    public int i() {
        return this.b.D.y();
    }

    void start(RecyclerView recyclerView, W w) {
        this.b = recyclerView;
        this.c = w;
        if (this.a == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        this.b.p.e = this.a;
        this.e = true;
        this.d = true;
        this.f = e(h());
        a();
        this.b.ak.a();
    }

    protected final void stop() {
        if (this.e) {
            b();
            this.b.p.e = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            this.e = false;
            this.c.b(this);
            this.c = null;
            this.b = null;
        }
    }
}
