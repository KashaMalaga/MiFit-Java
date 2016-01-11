package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;

class B {
    B() {
    }

    public static int a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static Object a(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4) {
        Builder builder = new Builder();
        builder.setState(i, j, f, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        return builder.build();
    }

    public static long b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }
}
