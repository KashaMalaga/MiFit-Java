package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aU implements AnimationListener {
    final /* synthetic */ FwUpgradeActivity a;

    aU(FwUpgradeActivity fwUpgradeActivity) {
        this.a = fwUpgradeActivity;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.o.setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
