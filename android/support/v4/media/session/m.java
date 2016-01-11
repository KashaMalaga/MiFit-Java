package android.support.v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.PlaybackState;
import android.os.Bundle;

class m<T extends l> extends Callback {
    protected final T a;

    public m(T t) {
        this.a = t;
    }

    public void onMetadataChanged(MediaMetadata mediaMetadata) {
        this.a.b(mediaMetadata);
    }

    public void onPlaybackStateChanged(PlaybackState playbackState) {
        this.a.a(playbackState);
    }

    public void onSessionDestroyed() {
        this.a.a();
    }

    public void onSessionEvent(String str, Bundle bundle) {
        this.a.a(str, bundle);
    }
}
