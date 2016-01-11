package android.support.v4.media.a;

import android.media.MediaRouter.RouteInfo;

public final class s {
    public static CharSequence a(Object obj) {
        return ((RouteInfo) obj).getDescription();
    }

    public static boolean b(Object obj) {
        return ((RouteInfo) obj).isConnecting();
    }
}
