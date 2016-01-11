package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.chart.base.q;

class r implements AnimatorListener {
    final /* synthetic */ DynamicPieChartView a;

    r(DynamicPieChartView dynamicPieChartView) {
        this.a = dynamicPieChartView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (o.class.isInstance(this.a.e)) {
            ((o) this.a.e).b();
            ((q) this.a.e).g(0.0f);
        }
        this.a.postInvalidateOnAnimation();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        if (o.class.isInstance(this.a.e)) {
            ((o) this.a.e).a();
            ((q) this.a.e).g(0.0f);
        }
        this.a.postInvalidateOnAnimation();
    }
}
