package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class bd extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    bd(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.a.a(this.a.K + ((-this.a.K) * f));
        this.a.b(f);
    }
}
