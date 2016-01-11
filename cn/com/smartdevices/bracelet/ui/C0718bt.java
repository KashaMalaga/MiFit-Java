package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0718bt implements AnimationListener {
    final /* synthetic */ InstructionWeightActivity a;

    C0718bt(InstructionWeightActivity instructionWeightActivity) {
        this.a = instructionWeightActivity;
    }

    public void onAnimationEnd(Animation animation) {
        InstructionWeightActivity.P.sendEmptyMessage(1);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.a.u.setVisibility(4);
    }
}
