package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class bb extends Animation {
    final /* synthetic */ SwipeRefreshLayout a;

    bb(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.a.a((((int) (((float) ((!this.a.V ? (int) (this.a.R - ((float) Math.abs(this.a.d))) : (int) this.a.R) - this.a.c)) * f)) + this.a.c) - this.a.I.getTop(), false);
    }
}
