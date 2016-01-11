package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import com.xiaomi.hm.health.t;

public class LinePieChartView extends BaseChartView<x> {
    private static final String a = "LinePieChartView";
    private Bitmap b;
    private float c;
    private Animator d;

    public LinePieChartView(Context context) {
        this(context, null);
    }

    public LinePieChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinePieChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new x(context);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, t.LinePieChartView);
        a(obtainStyledAttributes.getInt(0, 0));
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        if (resourceId != -1) {
            this.b = BitmapFactory.decodeResource(getResources(), resourceId);
            if (this.b != null) {
                ((x) this.e).a(this.b);
            }
        }
        obtainStyledAttributes.recycle();
        this.m = new DecelerateInterpolator();
        this.n = 1;
    }

    private void g() {
        float f = this.c / ((x) this.e).f();
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.n = (long) (Math.sqrt((double) f) * 800.0d);
        if (this.n == 0) {
            this.n = 1;
        }
    }

    @SuppressLint({"NewApi"})
    private Animator n() {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addListener(new y(this));
        ofFloat.addUpdateListener(new z(this));
        ofFloat.setDuration(3500);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }

    public void a(int i) {
        ((x) this.e).a(i);
        invalidate();
    }

    public void a(long j) {
        ((x) this.e).c((float) j);
    }

    public void a(RectF rectF) {
        ((x) this.e).b(rectF);
    }

    public void b() {
        if (this.d != null) {
            this.d.end();
            ((x) this.e).b();
        }
    }

    public void b(int i) {
        ((x) this.e).c(i);
        postInvalidate();
    }

    public void b(long j) {
        this.c = (float) j;
        g();
    }

    public void c(int i) {
        ((x) this.e).b(i);
    }

    public void c(long j) {
        if (this.d == null) {
            this.d = n();
        }
        if (!this.d.isStarted()) {
            if (j > 0) {
                this.d.setStartDelay(j);
            }
            this.d.start();
        }
    }

    public void d() {
        ((x) this.e).a(0);
        a(false);
    }

    public void d_() {
        c(0);
    }

    public int e() {
        return ((x) this.e).d();
    }

    public int f() {
        return ((x) this.e).c();
    }

    protected void onDraw(Canvas canvas) {
        if (this.o < 1.0f) {
            ((x) this.e).f(this.o * this.c);
            ((x) this.e).a(canvas, 1.0f);
            return;
        }
        ((x) this.e).f(this.c);
        ((x) this.e).a(canvas, this.o);
    }
}
