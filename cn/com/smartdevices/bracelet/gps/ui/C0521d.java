package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class C0521d extends AnimatorListenerAdapter {
    final /* synthetic */ GPSMainActivity a;

    C0521d(GPSMainActivity gPSMainActivity) {
        this.a = gPSMainActivity;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.l();
    }
}
