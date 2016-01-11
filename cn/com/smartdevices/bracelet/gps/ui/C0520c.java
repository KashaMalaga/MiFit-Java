package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class C0520c extends AnimatorListenerAdapter {
    final /* synthetic */ GPSMainActivity a;

    C0520c(GPSMainActivity gPSMainActivity) {
        this.a = gPSMainActivity;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.k();
    }
}
