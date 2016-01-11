package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C0725ca implements AnimatorListener {
    final /* synthetic */ MainUIActivity a;

    C0725ca(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.V.smoothSlideTo(1.0f, 0);
        this.a.aa.setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.Y.setScaleX(1.0f);
        this.a.Y.setScaleY(1.0f);
        this.a.Y.setAlpha(1.0f);
        this.a.Y.setVisibility(0);
    }
}
