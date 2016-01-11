package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.a.q;

public final class C0082t {
    private C0082t() {
    }

    public static boolean a(@q ActivityManager activityManager) {
        return VERSION.SDK_INT >= 19 ? C0083u.a(activityManager) : false;
    }
}
