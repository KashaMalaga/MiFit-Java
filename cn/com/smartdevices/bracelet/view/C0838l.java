package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C0838l implements AnimatorListener {
    final /* synthetic */ DynamicView a;

    C0838l(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.c.setScaleX(1.0f);
        this.a.c.setScaleY(1.0f);
    }
}
