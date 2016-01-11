package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

final class f extends AnimatorListenerAdapter {
    f() {
    }

    public void onAnimationEnd(Animator animator) {
        ((View) ((ObjectAnimator) animator).getTarget()).setRotationY(0.0f);
    }
}
