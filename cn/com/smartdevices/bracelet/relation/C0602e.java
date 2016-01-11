package cn.com.smartdevices.bracelet.relation;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0602e implements AnimationListener {
    final /* synthetic */ C0601d a;

    C0602e(C0601d c0601d) {
        this.a = c0601d;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.a.J.setVisibility(8);
        this.a.a.J.clearAnimation();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
