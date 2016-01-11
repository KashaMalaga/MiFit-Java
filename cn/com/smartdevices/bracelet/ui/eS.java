package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class eS implements AnimatorListener {
    final /* synthetic */ eR a;

    eS(eR eRVar) {
        this.a = eRVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.a.aw.setStartDelay(0);
        this.a.a.H = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.a.b.c(false);
    }
}
