package cn.com.smartdevices.bracelet.chart.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;

class h implements AnimatorUpdateListener {
    final /* synthetic */ BaseChartView a;

    h(BaseChartView baseChartView) {
        this.a = baseChartView;
    }

    @SuppressLint({"NewApi"})
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.o = valueAnimator.getAnimatedFraction();
        this.a.postInvalidateOnAnimation();
    }
}
