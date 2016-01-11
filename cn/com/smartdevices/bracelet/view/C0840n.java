package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C0840n implements AnimatorListener {
    final /* synthetic */ DynamicView a;

    C0840n(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.c.setRotationY(0.0f);
    }
}
