package cn.com.smartdevices.bracelet.weight;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.C0596r;

class Y implements AnimatorListener {
    final /* synthetic */ Q a;

    Y(Q q) {
        this.a = q;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        C0596r.e("UserListActivity", "anim end and dismiss");
        if (this.a.p != null) {
            this.a.p.a();
        }
        this.a.dismiss();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
