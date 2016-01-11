package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;

class C0690at implements AnimatorListener {
    final /* synthetic */ View a;
    final /* synthetic */ C0681ak b;
    private boolean c;

    C0690at(C0681ak c0681ak, View view) {
        this.b = c0681ak;
        this.a = view;
    }

    public void onAnimationCancel(Animator animator) {
        C0596r.e("Dynamic.Detail", "Dismiss Anim Canceled!!");
        this.c = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.c) {
            C0596r.e("Dynamic.Detail", "Dismiss Anim Ended!!");
            this.a.setVisibility(4);
            this.b.W = false;
        }
        this.b.V = null;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
