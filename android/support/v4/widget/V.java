package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class V implements AnimationListener {
    final /* synthetic */ Z a;
    final /* synthetic */ T b;

    V(T t, Z z) {
        this.b = t;
        this.a = z;
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
        this.a.l();
        this.a.a();
        this.a.b(this.a.g());
        if (this.b.c) {
            this.b.c = false;
            animation.setDuration(1333);
            this.a.a(false);
            return;
        }
        this.b.C = (this.b.C + 1.0f) % 5.0f;
    }

    public void onAnimationStart(Animation animation) {
        this.b.C = 0.0f;
    }
}
