package cn.com.smartdevices.bracelet.ui;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class C0720bv implements AnimationListener {
    final /* synthetic */ InstructionWeightActivity a;

    C0720bv(InstructionWeightActivity instructionWeightActivity) {
        this.a = instructionWeightActivity;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.a.setVisibility(0);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.28f);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setAnimationListener(new C0721bw(this, translateAnimation));
        this.a.a.startAnimation(translateAnimation);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.a.J.setVisibility(0);
        this.a.a.clearAnimation();
        this.a.a.setVisibility(4);
    }
}
