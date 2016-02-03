package cn.com.smartdevices.bracelet.weight;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.xiaomi.hm.health.R;

class C0865c implements AnimatorListener {
    final /* synthetic */ BabyWeightActivity a;

    C0865c(BabyWeightActivity babyWeightActivity) {
        this.a = babyWeightActivity;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.v = false;
        this.a.i.setX(this.a.u);
        this.a.i.setAlpha(0);
        this.a.i.setBackgroundResource(R.drawable.baby_weight_adult_with_baby);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new C0866d(this));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(700);
        ofFloat.start();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
