package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C0538t implements AnimatorUpdateListener {
    final /* synthetic */ C0530l a;

    C0538t(C0530l c0530l) {
        this.a = c0530l;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.l.setX(((1.0f - floatValue) * this.a.c) + (this.a.e * floatValue));
        this.a.m.setX((floatValue * this.a.e) + ((1.0f - floatValue) * this.a.d));
    }
}
