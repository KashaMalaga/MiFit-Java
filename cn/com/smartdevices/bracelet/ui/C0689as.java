package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class C0689as implements AnimatorListener {
    final /* synthetic */ C0681ak a;

    C0689as(C0681ak c0681ak) {
        this.a = c0681ak;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if ((this.a.ag & 8) > 0) {
            this.a.B.d(true);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
