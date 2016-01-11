package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final class j implements AnimatorUpdateListener {
    final /* synthetic */ TextView a;

    j(TextView textView) {
        this.a = textView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setText((CharSequence) valueAnimator.getAnimatedValue("Text"));
    }
}
