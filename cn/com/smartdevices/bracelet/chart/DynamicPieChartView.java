package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.q;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class DynamicPieChartView extends BaseChartView<q> {
    private static final String a = "Chart.DynamicPieChartView";
    private float b;
    private float c;
    private Animator d;
    private int q;

    public DynamicPieChartView(Context context) {
        this(context, null);
    }

    public DynamicPieChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicPieChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new DecelerateInterpolator();
        this.n = 1;
    }

    private void e() {
        float abs = Math.abs(this.c - this.b) / ((q) this.e).f();
        if (abs > 1.0f) {
            abs = 1.0f;
        }
        this.n = (long) (Math.sqrt((double) abs) * 800.0d);
        if (this.n == 0) {
            this.n = 1;
        }
        this.p = d(this.n);
    }

    @SuppressLint({"NewApi"})
    private Animator f() {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addListener(new r(this));
        ofFloat.addUpdateListener(new s(this));
        ofFloat.setDuration(3500);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        return ofFloat;
    }

    public void a(float f) {
        ((q) this.e).c(f);
    }

    public void a(int i) {
        this.q = i;
        if (i != PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.e = new o(getContext());
        } else {
            this.e = new w(getContext());
        }
        if (o.class.isInstance(this.e)) {
            ((o) this.e).a(i);
        }
        invalidate();
    }

    public void a(long j) {
        if (this.d == null) {
            this.d = f();
        }
        if (!this.d.isStarted()) {
            if (j > 0) {
                this.d.setStartDelay(j);
            }
            this.d.start();
        }
    }

    public void b() {
        a(0);
    }

    public void b(float f) {
        this.b = f;
        e();
    }

    public void c(float f) {
        if (this.q == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.b = this.c;
        }
        if (f > ((q) this.e).f()) {
            this.c = ((q) this.e).f();
        } else {
            this.c = f;
        }
        if (this.q == ChartData.d || this.q == ChartData.e) {
            postInvalidate();
        } else {
            e();
        }
    }

    public void c_() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{HeartRateInfo.HR_EMPTY_VALUE, 0});
        ofInt.addListener(new p(this));
        ofInt.addUpdateListener(new q(this));
        ofInt.setDuration(1000);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.start();
    }

    public void d() {
        if (this.d != null) {
            this.d.end();
        }
    }

    public void d(float f) {
        if (w.class.isInstance(this.e)) {
            ((w) this.e).b(f);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.o < 1.0f) {
            ((q) this.e).f(((this.c - this.b) * this.o) + this.b);
            ((q) this.e).a(canvas, 1.0f);
            return;
        }
        ((q) this.e).f(this.c);
        ((q) this.e).a(canvas, this.o);
    }
}
