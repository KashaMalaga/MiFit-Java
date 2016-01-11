package android.support.v4.media.a;

import android.media.MediaRouter.RouteInfo;
import android.view.Display;

public final class q {
    public static boolean a(Object obj) {
        return ((RouteInfo) obj).isEnabled();
    }

    public static Display b(Object obj) {
        return ((RouteInfo) obj).getPresentationDisplay();
    }
}
