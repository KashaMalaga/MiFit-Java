package android.support.v4.media.session;

import android.media.Rating;
import android.media.session.MediaController.TransportControls;

public class o {
    public static void a(Object obj) {
        ((TransportControls) obj).play();
    }

    public static void a(Object obj, long j) {
        ((TransportControls) obj).seekTo(j);
    }

    public static void a(Object obj, Object obj2) {
        ((TransportControls) obj).setRating((Rating) obj2);
    }

    public static void b(Object obj) {
        ((TransportControls) obj).pause();
    }

    public static void c(Object obj) {
        ((TransportControls) obj).fastForward();
    }

    public static void d(Object obj) {
        ((TransportControls) obj).rewind();
    }

    public static void e(Object obj) {
        ((TransportControls) obj).skipToNext();
    }

    public static void f(Object obj) {
        ((TransportControls) obj).skipToPrevious();
    }

    public static void stop(Object obj) {
        ((TransportControls) obj).stop();
    }
}
