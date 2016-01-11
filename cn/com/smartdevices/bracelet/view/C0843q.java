package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.chart.a.a;
import cn.com.smartdevices.bracelet.view.DynamicView.FlowBgView;

class C0843q implements AnimatorUpdateListener {
    final /* synthetic */ FlowBgView a;

    C0843q(FlowBgView flowBgView) {
        this.a = flowBgView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.e = (float) ((int) (((((Float) valueAnimator.getAnimatedValue()).floatValue() * (1.0f - 0.19482619f)) + 0.19482619f) * this.a.b));
        a.a(this.a);
    }
}
