package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0716br implements AnimationListener {
    final /* synthetic */ View a;
    final /* synthetic */ Animation b;
    final /* synthetic */ InstructionWeightActivity c;

    C0716br(InstructionWeightActivity instructionWeightActivity, View view, Animation animation) {
        this.c = instructionWeightActivity;
        this.a = view;
        this.b = animation;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.startAnimation(this.b);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
