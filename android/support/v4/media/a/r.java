package android.support.v4.media.a;

import android.media.MediaRouter;
import android.media.MediaRouter.Callback;

class r extends l {
    r() {
    }

    public static void a(Object obj, int i, Object obj2, int i2) {
        ((MediaRouter) obj).addCallback(i, (Callback) obj2, i2);
    }

    public static Object c(Object obj) {
        return ((MediaRouter) obj).getDefaultRoute();
    }
}
