package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aV implements AnimationListener {
    final /* synthetic */ FwUpgradeActivity a;

    aV(FwUpgradeActivity fwUpgradeActivity) {
        this.a = fwUpgradeActivity;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.p.setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
