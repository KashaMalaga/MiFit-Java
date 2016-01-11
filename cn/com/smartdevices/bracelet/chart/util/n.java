package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.weight.aA;

final class n implements AnimatorUpdateListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ int b;

    n(TextView textView, int i) {
        this.a = textView;
        this.b = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setText(String.valueOf(aA.c(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.b)));
    }
}
