package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class V implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ Q b;

    V(Q q, int i) {
        this.b = q;
        this.a = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.b.i.setY((float) (this.a - ((Integer) valueAnimator.getAnimatedValue()).intValue()));
    }
}
