package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class C0539u extends AnimatorListenerAdapter {
    final /* synthetic */ C0530l a;

    C0539u(C0530l c0530l) {
        this.a = c0530l;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.a.o != null) {
            this.a.o.a();
        }
        this.a.g();
    }
}
