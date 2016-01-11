package cn.com.smartdevices.bracelet.view;

import android.view.animation.Interpolator;

final class Q implements Interpolator {
    Q() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
