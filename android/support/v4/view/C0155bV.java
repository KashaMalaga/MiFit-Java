package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class C0155bV extends AnimatorListenerAdapter {
    final /* synthetic */ cb a;
    final /* synthetic */ View b;

    C0155bV(cb cbVar, View view) {
        this.a = cbVar;
        this.b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.a.c(this.b);
    }

    public void onAnimationEnd(Animator animator) {
        this.a.b(this.b);
    }

    public void onAnimationStart(Animator animator) {
        this.a.a(this.b);
    }
}
