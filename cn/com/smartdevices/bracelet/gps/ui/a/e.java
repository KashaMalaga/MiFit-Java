package cn.com.smartdevices.bracelet.gps.ui.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.xiaomi.e.a;

class e extends AnimatorListenerAdapter {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.a.d) {
            if (a.d(this.a) > 0) {
                this.a.i.start();
                return;
            }
            this.a.dismissAllowingStateLoss();
            if (!this.a.d) {
                this.a.g.b();
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        this.a.a.setText(a.f + this.a.b);
    }
}
