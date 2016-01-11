package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C0536r implements AnimatorUpdateListener {
    final /* synthetic */ C0530l a;

    C0536r(C0530l c0530l) {
        this.a = c0530l;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue < 100) {
            this.a.n.a(0);
        } else {
            this.a.n.a(intValue - 100);
        }
    }
}
