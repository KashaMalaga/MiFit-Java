package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Z implements AnimationListener {
    final /* synthetic */ Fragment a;
    final /* synthetic */ U b;

    Z(U u, Fragment fragment) {
        this.b = u;
        this.a = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.mAnimatingAway != null) {
            this.a.mAnimatingAway = null;
            this.b.a(this.a, this.a.mStateAfterAnimating, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
