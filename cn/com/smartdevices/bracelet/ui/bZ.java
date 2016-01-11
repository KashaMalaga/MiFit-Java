package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bZ implements AnimatorUpdateListener {
    final /* synthetic */ MainUIActivity a;

    bZ(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.X.setTranslationY(800.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
