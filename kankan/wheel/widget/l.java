package kankan.wheel.widget;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class l {
    public static final int a = 1;
    private static final int b = 400;
    private o c;
    private Context d;
    private GestureDetector e;
    private Scroller f;
    private int g;
    private float h;
    private boolean i;
    private SimpleOnGestureListener j = new m(this);
    private final int k = 0;
    private final int l = a;
    private Handler m = new n(this);

    public l(Context context, o oVar) {
        this.e = new GestureDetector(context, this.j);
        this.e.setIsLongpressEnabled(false);
        this.f = new Scroller(context);
        this.c = oVar;
        this.d = context;
    }

    private void a(int i) {
        c();
        this.m.sendEmptyMessage(i);
    }

    private void c() {
        this.m.removeMessages(0);
        this.m.removeMessages(a);
    }

    private void d() {
        this.c.c();
        a((int) a);
    }

    private void e() {
        if (!this.i) {
            this.i = true;
            this.c.a();
        }
    }

    public void a() {
        this.f.forceFinished(true);
    }

    public void a(int i, int i2) {
        this.f.forceFinished(true);
        this.g = 0;
        this.f.startScroll(0, 0, 0, i, i2 != 0 ? i2 : b);
        a(0);
        e();
    }

    public void a(Interpolator interpolator) {
        this.f.forceFinished(true);
        this.f = new Scroller(this.d, interpolator);
    }

    public boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
                this.h = motionEvent.getY();
                this.f.forceFinished(true);
                c();
                break;
            case a.k /*2*/:
                int y = (int) (motionEvent.getY() - this.h);
                if (y != 0) {
                    e();
                    this.c.a(y);
                    this.h = motionEvent.getY();
                    break;
                }
                break;
        }
        if (!this.e.onTouchEvent(motionEvent) && motionEvent.getAction() == a) {
            d();
        }
        return true;
    }

    void b() {
        if (this.i) {
            this.c.b();
            this.i = false;
        }
    }
}
