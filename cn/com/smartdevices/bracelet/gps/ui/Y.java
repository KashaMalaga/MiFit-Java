package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class Y implements AnimatorUpdateListener {
    final /* synthetic */ HistoryActivity a;

    Y(HistoryActivity historyActivity) {
        this.a = historyActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.t = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.n.setProgress(this.a.t);
        if (this.a.t >= 100) {
            this.a.A = true;
        }
    }
}
