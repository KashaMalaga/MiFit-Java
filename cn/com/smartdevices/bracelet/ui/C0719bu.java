package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0719bu implements AnimationListener {
    final /* synthetic */ InstructionWeightActivity a;

    C0719bu(InstructionWeightActivity instructionWeightActivity) {
        this.a = instructionWeightActivity;
    }

    public void onAnimationEnd(Animation animation) {
        InstructionWeightActivity.P.sendEmptyMessage(2);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
