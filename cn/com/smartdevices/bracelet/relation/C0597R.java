package cn.com.smartdevices.bracelet.relation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0597R implements AnimationListener {
    final /* synthetic */ Q a;

    C0597R(Q q) {
        this.a = q;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.a.l.setVisibility(8);
        this.a.a.l.clearAnimation();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
