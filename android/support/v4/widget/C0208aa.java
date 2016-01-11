package android.support.v4.widget;

import android.view.animation.AccelerateDecelerateInterpolator;

class C0208aa extends AccelerateDecelerateInterpolator {
    private C0208aa() {
    }

    public float getInterpolation(float f) {
        return super.getInterpolation(Math.min(1.0f, 2.0f * f));
    }
}
