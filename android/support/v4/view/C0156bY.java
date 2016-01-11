package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;

class C0156bY {
    C0156bY() {
    }

    public static Interpolator a(View view) {
        return (Interpolator) view.animate().getInterpolator();
    }
}
