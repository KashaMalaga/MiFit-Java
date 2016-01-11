package cn.com.smartdevices.bracelet.relation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C0613p implements AnimatorListener {
    final /* synthetic */ C0611n a;

    C0613p(C0611n c0611n) {
        this.a = c0611n;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        super.dismiss();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
