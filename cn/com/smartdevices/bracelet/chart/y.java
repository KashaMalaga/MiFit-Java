package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class y implements AnimatorListener {
    final /* synthetic */ LinePieChartView a;

    y(LinePieChartView linePieChartView) {
        this.a = linePieChartView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        ((x) this.a.e).b();
        ((x) this.a.e).g(0.0f);
        this.a.postInvalidateOnAnimation();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        ((x) this.a.e).a();
        ((x) this.a.e).g(0.0f);
        this.a.postInvalidateOnAnimation();
    }
}
