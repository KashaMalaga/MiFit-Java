package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.Log;

class C0851y implements AnimatorUpdateListener {
    final /* synthetic */ C0852z a;
    final /* synthetic */ RippleBackground b;

    C0851y(RippleBackground rippleBackground, C0852z c0852z) {
        this.b = rippleBackground;
        this.a = c0852z;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Log.i("update", valueAnimator.getAnimatedValue().toString() + " ; RADIUS: " + (this.b.getWidth() / 2) + " ; ripple:" + this.b.m);
        this.a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.a.invalidate();
    }
}
