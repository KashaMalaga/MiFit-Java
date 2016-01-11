package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class aX extends AnimatorListenerAdapter {
    final /* synthetic */ RunningMainActivity a;

    aX(RunningMainActivity runningMainActivity) {
        this.a = runningMainActivity;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.C.removeView(this.a.B);
    }
}
