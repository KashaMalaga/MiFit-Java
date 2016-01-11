package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ba implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout a;

    ba(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.a.E) {
            this.a.b(null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
