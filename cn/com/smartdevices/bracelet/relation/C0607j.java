package cn.com.smartdevices.bracelet.relation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C0607j implements AnimatorListener {
    final /* synthetic */ Animator a;
    final /* synthetic */ C0606i b;

    C0607j(C0606i c0606i, Animator animator) {
        this.b = c0606i;
        this.a = animator;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setStartDelay(0);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.b.a.f.b.c(false);
    }
}
