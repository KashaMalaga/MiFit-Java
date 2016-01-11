package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class C0726cb implements AnimatorUpdateListener {
    final /* synthetic */ MainUIActivity a;

    C0726cb(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.Y.setScaleX(floatValue);
        this.a.Y.setScaleY(floatValue);
        this.a.Y.setAlpha(floatValue);
    }
}
