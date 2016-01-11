package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C0866d implements AnimatorUpdateListener {
    final /* synthetic */ C0865c a;

    C0866d(C0865c c0865c) {
        this.a = c0865c;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a.i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
