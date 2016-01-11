package cn.com.smartdevices.bracelet.chart.base;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.b.d;

public abstract class BaseChartView<T extends g<? extends k>> extends View {
    private static final String a = "Chart.BaseView";
    protected T e;
    protected d f;
    protected boolean g;
    protected l h;
    protected boolean i;
    protected int j;
    protected boolean k;
    protected boolean l;
    protected Interpolator m;
    protected long n;
    protected float o;
    protected Animator p;

    public BaseChartView(Context context) {
        this(context, null);
    }

    public BaseChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = true;
        this.o = 1.0f;
        this.m = new LinearInterpolator();
        this.n = 500;
    }

    @SuppressLint({"NewApi"})
    private void a(float f, boolean z) {
        if (z) {
            a();
            if (!this.p.isStarted()) {
                this.p.start();
                return;
            }
            return;
        }
        this.o = f;
        postInvalidateOnAnimation();
    }

    public Animator a() {
        if (this.p == null) {
            this.p = d(this.n);
        }
        return this.p;
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public void a(boolean z) {
        a(z ? 0.0f : 1.0f, z);
    }

    public void c() {
        a(1.0f, false);
    }

    public void c(boolean z) {
        this.l = z;
    }

    public Animator d(long j) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f});
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(this.m);
        ofFloat.addUpdateListener(new h(this));
        return ofFloat;
    }

    public void d(boolean z) {
        this.g = z;
    }

    public void e(float f) {
        a(f, false);
    }

    public void h() {
        this.k = true;
    }

    public void i() {
        this.k = false;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return this.l;
    }

    public long l() {
        return this.n;
    }

    public d m() {
        return this.f;
    }

    protected void onDraw(Canvas canvas) {
        this.e.a(canvas, this.o);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        rect.left = getPaddingLeft();
        rect.top = getPaddingTop();
        rect.right = i - getPaddingRight();
        rect.bottom = i2 - getPaddingBottom();
        this.e.a(rect);
    }
}
