package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import kankan.wheel.widget.a;

public class l {
    public static final int a = 1;
    private static final String b = "Chart.Scroller";
    private static final int c = 400;
    private o d;
    private Context e;
    private GestureDetector f;
    private Scroller g;
    private int h;
    private float i;
    private int j;
    private float k;
    private boolean l;
    private boolean m;
    private Handler n;
    private SimpleOnGestureListener o = new n(this);
    private final int p = 0;
    private final int q = a;

    public l(Context context, o oVar) {
        this.e = context;
        this.d = oVar;
        this.f = new GestureDetector(context, this.o);
        this.f.setIsLongpressEnabled(false);
        this.g = new Scroller(context);
        this.n = new m(this);
    }

    private void c() {
        this.n.removeMessages(0);
        this.n.removeMessages(a);
    }

    private void c(int i) {
        c();
        this.n.sendEmptyMessage(i);
    }

    private void d() {
        this.d.b();
        c((int) a);
    }

    private void e() {
        if (!this.l) {
            this.l = true;
            this.d.a();
        }
    }

    void a() {
        if (this.l) {
            this.d.c();
            this.l = false;
        }
    }

    public void a(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        this.m = true;
        this.g.forceFinished(true);
        this.h = 0;
        this.g.startScroll(0, 0, i, 0, i2 != 0 ? i2 : c);
        c(0);
        e();
    }

    public void a(Interpolator interpolator) {
        this.g.forceFinished(true);
        this.g = new Scroller(this.e, interpolator);
    }

    public boolean a(MotionEvent motionEvent) {
        boolean z;
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
                this.i = motionEvent.getX();
                this.k = motionEvent.getY();
                this.g.forceFinished(true);
                c();
                z = true;
                break;
            case a.k /*2*/:
                int x = (int) (motionEvent.getX() - this.i);
                int y = (int) (motionEvent.getY() - this.k);
                if (x != 0) {
                    e();
                    z = this.d.a(x);
                    this.i = motionEvent.getX();
                } else {
                    z = true;
                }
                if (y != 0) {
                    e();
                    z = this.d.b(y);
                    this.k = motionEvent.getY();
                    break;
                }
                break;
            default:
                z = true;
                break;
        }
        if (!this.f.onTouchEvent(motionEvent) && motionEvent.getAction() == a) {
            d();
        }
        return z;
    }

    public void b() {
        if (!this.g.isFinished()) {
            this.g.forceFinished(true);
        }
    }

    public void b(int i) {
        b(i, 0);
    }

    public void b(int i, int i2) {
        this.m = false;
        this.g.forceFinished(true);
        this.j = 0;
        this.g.startScroll(0, 0, 0, i, i2 != 0 ? i2 : c);
        c(0);
        e();
    }
}
