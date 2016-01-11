package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class aX extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    aX(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.a.a(f);
    }
}
