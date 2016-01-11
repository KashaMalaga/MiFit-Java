package android.support.v4.media.a;

import android.graphics.drawable.Drawable;
import android.media.MediaRouter.UserRouteInfo;
import android.media.MediaRouter.VolumeCallback;
import android.media.RemoteControlClient;

public final class i {
    public static void a(Object obj, int i) {
        ((UserRouteInfo) obj).setPlaybackType(i);
    }

    public static void a(Object obj, Drawable drawable) {
        ((UserRouteInfo) obj).setIconDrawable(drawable);
    }

    public static void a(Object obj, CharSequence charSequence) {
        ((UserRouteInfo) obj).setName(charSequence);
    }

    public static void a(Object obj, Object obj2) {
        ((UserRouteInfo) obj).setVolumeCallback((VolumeCallback) obj2);
    }

    public static void b(Object obj, int i) {
        ((UserRouteInfo) obj).setPlaybackStream(i);
    }

    public static void b(Object obj, CharSequence charSequence) {
        ((UserRouteInfo) obj).setStatus(charSequence);
    }

    public static void b(Object obj, Object obj2) {
        ((UserRouteInfo) obj).setRemoteControlClient((RemoteControlClient) obj2);
    }

    public static void c(Object obj, int i) {
        ((UserRouteInfo) obj).setVolume(i);
    }

    public static void d(Object obj, int i) {
        ((UserRouteInfo) obj).setVolumeMax(i);
    }

    public static void e(Object obj, int i) {
        ((UserRouteInfo) obj).setVolumeHandling(i);
    }
}
