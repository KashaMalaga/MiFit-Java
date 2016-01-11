package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class av implements AnimatorUpdateListener {
    final /* synthetic */ as a;

    av(as asVar) {
        this.a = asVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.q.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
