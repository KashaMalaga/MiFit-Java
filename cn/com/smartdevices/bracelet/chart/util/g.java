package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

final class g extends AnimatorListenerAdapter {
    g() {
    }

    public void onAnimationEnd(Animator animator) {
        ((View) ((ObjectAnimator) animator).getTarget()).setRotationX(0.0f);
    }
}
