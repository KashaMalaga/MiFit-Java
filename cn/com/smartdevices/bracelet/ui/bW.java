package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bW implements AnimatorListener {
    final /* synthetic */ float a;
    final /* synthetic */ MainUIActivity b;

    bW(MainUIActivity mainUIActivity, float f) {
        this.b = mainUIActivity;
        this.a = f;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.b.ae.setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.b.ae.setVisibility(0);
        this.b.ae.setTranslationY(-this.a);
        this.b.af.setFlagsToFalse();
    }
}
