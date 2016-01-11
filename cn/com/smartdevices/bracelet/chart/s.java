package cn.com.smartdevices.bracelet.chart;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.chart.base.q;

class s implements AnimatorUpdateListener {
    final /* synthetic */ DynamicPieChartView a;

    s(DynamicPieChartView dynamicPieChartView) {
        this.a = dynamicPieChartView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((q) this.a.e).g(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.postInvalidateOnAnimation();
    }
}
