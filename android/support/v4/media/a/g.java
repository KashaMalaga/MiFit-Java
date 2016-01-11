package android.support.v4.media.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaRouter.RouteGroup;
import android.media.MediaRouter.RouteInfo;

public final class g {
    public static CharSequence a(Object obj) {
        return ((RouteInfo) obj).getStatus();
    }

    public static CharSequence a(Object obj, Context context) {
        return ((RouteInfo) obj).getName(context);
    }

    public static void a(Object obj, int i) {
        ((RouteInfo) obj).requestSetVolume(i);
    }

    public static void a(Object obj, Object obj2) {
        ((RouteInfo) obj).setTag(obj2);
    }

    public static int b(Object obj) {
        return ((RouteInfo) obj).getSupportedTypes();
    }

    public static void b(Object obj, int i) {
        ((RouteInfo) obj).requestUpdateVolume(i);
    }

    public static Object c(Object obj) {
        return ((RouteInfo) obj).getCategory();
    }

    public static Drawable d(Object obj) {
        return ((RouteInfo) obj).getIconDrawable();
    }

    public static int e(Object obj) {
        return ((RouteInfo) obj).getPlaybackType();
    }

    public static int f(Object obj) {
        return ((RouteInfo) obj).getPlaybackStream();
    }

    public static int g(Object obj) {
        return ((RouteInfo) obj).getVolume();
    }

    public static int h(Object obj) {
        return ((RouteInfo) obj).getVolumeMax();
    }

    public static int i(Object obj) {
        return ((RouteInfo) obj).getVolumeHandling();
    }

    public static Object j(Object obj) {
        return ((RouteInfo) obj).getTag();
    }

    public static Object k(Object obj) {
        return ((RouteInfo) obj).getGroup();
    }

    public static boolean l(Object obj) {
        return obj instanceof RouteGroup;
    }
}
