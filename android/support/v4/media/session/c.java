package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;

public abstract class c {
    final Object a;

    public c() {
        if (VERSION.SDK_INT >= 21) {
            this.a = k.a(new d());
        } else {
            this.a = null;
        }
    }

    public void a() {
    }

    public void a(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void a(PlaybackStateCompat playbackStateCompat) {
    }

    public void a(String str, Bundle bundle) {
    }
}
