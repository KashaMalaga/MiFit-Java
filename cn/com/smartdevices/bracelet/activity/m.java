package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class m implements AnimatorUpdateListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        this.a.a.w.setAlpha(f.floatValue());
        this.a.a.r.setAlpha(f.floatValue());
        this.a.a.t.setAlpha(f.floatValue());
    }
}
