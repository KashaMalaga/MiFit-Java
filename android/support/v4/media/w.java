package android.support.v4.media;

import android.media.VolumeProvider;

final class w extends VolumeProvider {
    final /* synthetic */ x a;

    w(int i, int i2, int i3, x xVar) {
        this.a = xVar;
        super(i, i2, i3);
    }

    public void onAdjustVolume(int i) {
        this.a.b(i);
    }

    public void onSetVolumeTo(int i) {
        this.a.a(i);
    }
}
