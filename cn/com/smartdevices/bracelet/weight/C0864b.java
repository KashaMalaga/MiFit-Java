package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C0864b implements AnimatorUpdateListener {
    final /* synthetic */ BabyWeightActivity a;

    C0864b(BabyWeightActivity babyWeightActivity) {
        this.a = babyWeightActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.i.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
