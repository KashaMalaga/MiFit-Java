package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class C0146au {
    static final C0147ax a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new C0149aw();
        } else {
            a = new C0148av();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return a.b(velocityTracker, i);
    }
}
