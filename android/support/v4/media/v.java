package android.support.v4.media;

import android.media.VolumeProvider;

class v {
    v() {
    }

    public static Object a(int i, int i2, int i3, x xVar) {
        return new w(i, i2, i3, xVar);
    }

    public static void a(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}
