package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;

class C0078o {
    C0078o() {
    }

    private static SharedElementCallback a(C0076p c0076p) {
        return c0076p != null ? new C0079q(c0076p) : null;
    }

    public static void a(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void a(Activity activity, C0076p c0076p) {
        activity.setEnterSharedElementCallback(C0078o.a(c0076p));
    }

    public static void b(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void b(Activity activity, C0076p c0076p) {
        activity.setExitSharedElementCallback(C0078o.a(c0076p));
    }

    public static void c(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
