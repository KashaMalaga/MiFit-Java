package com.e.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.e.a.C1035b;

class j implements AnimatorListener {
    final /* synthetic */ i a;
    private final /* synthetic */ C1035b b;

    j(i iVar, C1035b c1035b) {
        this.a = iVar;
        this.b = c1035b;
    }

    public void onAnimationCancel(Animator animator) {
        this.b.c(null);
    }

    public void onAnimationEnd(Animator animator) {
        this.b.b(null);
    }

    public void onAnimationRepeat(Animator animator) {
        this.b.d(null);
    }

    public void onAnimationStart(Animator animator) {
        this.b.a(null);
    }
}
