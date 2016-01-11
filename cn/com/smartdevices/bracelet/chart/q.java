package cn.com.smartdevices.bracelet.chart;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class q implements AnimatorUpdateListener {
    final /* synthetic */ DynamicPieChartView a;

    q(DynamicPieChartView dynamicPieChartView) {
        this.a = dynamicPieChartView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((cn.com.smartdevices.bracelet.chart.base.q) this.a.e).d(((Integer) valueAnimator.getAnimatedValue()).intValue());
        this.a.postInvalidateOnAnimation();
    }
}
