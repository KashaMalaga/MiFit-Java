package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0717bs implements AnimationListener {
    final /* synthetic */ InstructionWeightActivity a;

    C0717bs(InstructionWeightActivity instructionWeightActivity) {
        this.a = instructionWeightActivity;
    }

    public void onAnimationEnd(Animation animation) {
        InstructionWeightActivity.P.sendEmptyMessage(4);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
