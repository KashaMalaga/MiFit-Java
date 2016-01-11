package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.MediaMetadata;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.MediaSession.Callback;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;

class w {
    w() {
    }

    public static Object a(Context context, String str) {
        return new MediaSession(context, str);
    }

    public static Object a(x xVar) {
        return new y(xVar);
    }

    public static Object a(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static void a(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    public static void a(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    public static void a(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((Callback) obj2, handler);
    }

    public static void a(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void a(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    public static void b(Object obj, int i) {
        Builder builder = new Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    public static void b(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    public static boolean b(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    public static void c(Object obj) {
        ((MediaSession) obj).release();
    }

    public static void c(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    public static Parcelable d(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }
}
