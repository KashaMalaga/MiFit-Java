package cn.com.smartdevices.bracelet.chart.a;

import android.animation.ValueAnimator;
import android.view.View;

class d {
    d() {
    }

    static void a(View view) {
        view.postDelayed(new e(view), ValueAnimator.getFrameDelay());
    }

    static void a(View view, float f) {
        view.setAlpha(f);
    }

    static void a(View view, Runnable runnable) {
        view.postDelayed(runnable, ValueAnimator.getFrameDelay());
    }
}
