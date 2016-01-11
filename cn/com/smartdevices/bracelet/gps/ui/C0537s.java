package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C0537s implements AnimatorUpdateListener {
    final /* synthetic */ C0530l a;

    C0537s(C0530l c0530l) {
        this.a = c0530l;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.l.setX(((1.0f - floatValue) * this.a.e) + (this.a.c * floatValue));
        this.a.m.setX((floatValue * this.a.d) + ((1.0f - floatValue) * this.a.e));
    }
}
