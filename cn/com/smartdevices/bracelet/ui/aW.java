package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class aW implements AnimationListener {
    final /* synthetic */ FwUpgradeActivity a;

    aW(FwUpgradeActivity fwUpgradeActivity) {
        this.a = fwUpgradeActivity;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.q.setVisibility(4);
        this.a.finish();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
