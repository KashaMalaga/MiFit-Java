package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C0841o implements AnimatorUpdateListener {
    final /* synthetic */ DynamicView a;

    C0841o(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.c.setRotationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
