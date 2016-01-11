package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0721bw implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ C0720bv b;

    C0721bw(C0720bv c0720bv, Animation animation) {
        this.b = c0720bv;
        this.a = animation;
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        InstructionWeightActivity.P.sendEmptyMessageDelayed(5, this.a.getDuration());
    }
}
