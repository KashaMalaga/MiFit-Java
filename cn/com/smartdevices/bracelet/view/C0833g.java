package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kankan.wheel.widget.a;

class C0833g implements AnimatorListener {
    final /* synthetic */ DynamicView a;

    C0833g(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.f();
        this.a.d();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.b.setRotationY(-180.0f);
        this.a.b.setAlpha(0.0f);
        this.a.b.setTranslationY(a.bP);
        this.a.D.setTranslationY(a.bP);
    }
}
