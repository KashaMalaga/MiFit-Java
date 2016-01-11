package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

class bK implements AnimatorUpdateListener {
    final /* synthetic */ bH a;

    bK(bH bHVar) {
        this.a = bHVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((View) this.a.e.getParent()).setLayoutParams(new LayoutParams(-1, ((Integer) valueAnimator.getAnimatedValue()).intValue()));
    }
}
