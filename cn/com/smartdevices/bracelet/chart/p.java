package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import cn.com.smartdevices.bracelet.chart.base.q;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

class p extends AnimatorListenerAdapter {
    final /* synthetic */ DynamicPieChartView a;

    p(DynamicPieChartView dynamicPieChartView) {
        this.a = dynamicPieChartView;
    }

    public void onAnimationEnd(Animator animator) {
        if (o.class.isInstance(this.a.e)) {
            ((q) this.a.e).d(-1);
        }
        this.a.c(0.0f);
    }

    public void onAnimationStart(Animator animator) {
        if (o.class.isInstance(this.a.e)) {
            ((q) this.a.e).d(HeartRateInfo.HR_EMPTY_VALUE);
        }
        this.a.postInvalidateOnAnimation();
    }
}
