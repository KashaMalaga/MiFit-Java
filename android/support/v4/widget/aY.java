package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class aY extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    aY(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.a.a(1.0f - f);
    }
}
