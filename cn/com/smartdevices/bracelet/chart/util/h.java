package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final class h implements AnimatorUpdateListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ TextView b;

    h(TextView textView, TextView textView2) {
        this.a = textView;
        this.b = textView2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = (1.0f - floatValue) * 0.9f;
        floatValue = (floatValue * 0.5f) + 0.5f;
        this.a.setAlpha(f);
        this.a.setScaleX(f);
        this.a.setScaleY(f);
        this.b.setAlpha(floatValue);
        this.b.setScaleX(floatValue);
        this.b.setScaleY(floatValue);
    }
}
