package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class eK implements AnimatorListener {
    final /* synthetic */ StatisticFragment a;

    eK(StatisticFragment statisticFragment) {
        this.a = statisticFragment;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.ae.d(true);
        this.a.af.d(true);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
