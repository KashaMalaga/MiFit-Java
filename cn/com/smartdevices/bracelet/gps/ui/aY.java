package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class aY implements AnimatorUpdateListener {
    final /* synthetic */ RunningMainActivity a;

    aY(RunningMainActivity runningMainActivity) {
        this.a = runningMainActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.B.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
