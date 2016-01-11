package cn.com.smartdevices.bracelet.chart;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class z implements AnimatorUpdateListener {
    final /* synthetic */ LinePieChartView a;

    z(LinePieChartView linePieChartView) {
        this.a = linePieChartView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((x) this.a.e).g(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.postInvalidateOnAnimation();
    }
}
