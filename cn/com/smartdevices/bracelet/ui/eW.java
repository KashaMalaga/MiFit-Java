package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.DecelerateInterpolator;
import kankan.wheel.widget.a;

class eW implements AnimatorListener {
    final /* synthetic */ long a;
    final /* synthetic */ StatisticFragment b;

    eW(StatisticFragment statisticFragment, long j) {
        this.b = statisticFragment;
        this.a = j;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.b.ae.a(this.b.r);
        this.b.af.a(this.b.r);
        Animator a = this.b.b.a();
        a.setDuration(this.a / 2);
        a.setInterpolator(new DecelerateInterpolator(a.bg));
        a.start();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
