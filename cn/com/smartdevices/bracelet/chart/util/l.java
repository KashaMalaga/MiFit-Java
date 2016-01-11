package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;

final class l implements AnimatorUpdateListener {
    final /* synthetic */ TextView a;

    l(TextView textView) {
        this.a = textView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        String str = (String) valueAnimator.getAnimatedValue("Text");
        C0596r.e("Chart.AnimUtil", "Text : " + str);
        this.a.setText(str);
    }
}
