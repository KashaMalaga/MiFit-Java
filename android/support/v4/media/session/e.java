package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;

interface e {
    i a();

    void a(c cVar);

    void a(c cVar, Handler handler);

    void a(String str, Bundle bundle, ResultReceiver resultReceiver);

    boolean a(KeyEvent keyEvent);

    PlaybackStateCompat b();

    MediaMetadataCompat c();

    int d();

    h e();

    Object f();
}
