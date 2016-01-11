package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class aw implements AnimatorUpdateListener {
    final /* synthetic */ as a;

    aw(as asVar) {
        this.a = asVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.q.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
