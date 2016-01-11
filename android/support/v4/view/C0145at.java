package android.support.v4.view;

import android.view.ScaleGestureDetector;

class C0145at {
    private C0145at() {
    }

    public static void a(Object obj, boolean z) {
        ((ScaleGestureDetector) obj).setQuickScaleEnabled(z);
    }

    public static boolean a(Object obj) {
        return ((ScaleGestureDetector) obj).isQuickScaleEnabled();
    }
}
