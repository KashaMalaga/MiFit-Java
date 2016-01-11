package cn.com.smartdevices.bracelet.weight;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ax implements AnimatorListener {
    final /* synthetic */ as a;

    ax(as asVar) {
        this.a = asVar;
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
