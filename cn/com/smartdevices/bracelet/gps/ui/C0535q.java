package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class C0535q extends AnimatorListenerAdapter {
    final /* synthetic */ C0530l a;

    C0535q(C0530l c0530l) {
        this.a = c0530l;
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        this.a.n.a(0);
        this.a.b = true;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.a.b) {
            this.a.b = false;
            return;
        }
        if (this.a.o != null) {
            this.a.o.c();
        }
        this.a.n.setVisibility(4);
        this.a.l.setVisibility(0);
        this.a.l.setX(this.a.e);
        this.a.m.setVisibility(0);
        this.a.m.setX(this.a.e);
    }
}
