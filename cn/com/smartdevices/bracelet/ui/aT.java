package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aT implements AnimationListener {
    final /* synthetic */ FwUpgradeActivity a;

    aT(FwUpgradeActivity fwUpgradeActivity) {
        this.a = fwUpgradeActivity;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.m == 2) {
            this.a.s.setVisibility(4);
        } else {
            this.a.r.setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
