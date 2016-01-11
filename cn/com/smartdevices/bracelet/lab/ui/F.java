package cn.com.smartdevices.bracelet.lab.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class F implements AnimationListener {
    final /* synthetic */ SportAnalyserActivity a;

    private F(SportAnalyserActivity sportAnalyserActivity) {
        this.a = sportAnalyserActivity;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.v.a(String.valueOf(0));
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
