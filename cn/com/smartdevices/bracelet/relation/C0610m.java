package cn.com.smartdevices.bracelet.relation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C0610m implements AnimatorListener {
    final /* synthetic */ Animator a;
    final /* synthetic */ C0609l b;

    C0610m(C0609l c0609l, Animator animator) {
        this.b = c0609l;
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
        this.b.a.f.a.c(false);
    }
}
