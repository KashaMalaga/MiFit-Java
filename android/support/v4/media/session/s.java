package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;

interface s {
    void a(int i);

    void a(MediaMetadataCompat mediaMetadataCompat);

    void a(android.support.v4.media.s sVar);

    void a(PlaybackStateCompat playbackStateCompat);

    void a(q qVar, Handler handler);

    void a(String str, Bundle bundle);

    void a(boolean z);

    boolean a();

    void b();

    void b(int i);

    Token c();

    Object d();
}
