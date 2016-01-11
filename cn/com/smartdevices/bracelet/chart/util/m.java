package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final class m implements AnimatorUpdateListener {
    final /* synthetic */ TextView a;

    m(TextView textView) {
        this.a = textView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setText(String.valueOf(((Integer) valueAnimator.getAnimatedValue()).intValue()));
    }
}
