package cn.com.smartdevices.bracelet.relation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class L implements AnimatorListener {
    final /* synthetic */ J a;

    L(J j) {
        this.a = j;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        super.dismissAllowingStateLoss();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
