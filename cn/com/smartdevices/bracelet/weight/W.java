package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class W implements AnimatorUpdateListener {
    final /* synthetic */ Q a;

    W(Q q) {
        this.a = q;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
