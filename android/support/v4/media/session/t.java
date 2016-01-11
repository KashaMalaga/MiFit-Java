package android.support.v4.media.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.s;
import android.support.v4.media.session.MediaSessionCompat.Token;

class t implements s {
    private final Object a;
    private final Token b = new Token(w.d(this.a));

    public t(Context context, String str) {
        this.a = w.a(context, str);
    }

    public t(Object obj) {
        this.a = w.a(obj);
    }

    public void a(int i) {
        w.a(this.a, i);
    }

    public void a(MediaMetadataCompat mediaMetadataCompat) {
        w.c(this.a, mediaMetadataCompat.c());
    }

    public void a(s sVar) {
        w.a(this.a, sVar.d());
    }

    public void a(PlaybackStateCompat playbackStateCompat) {
        w.b(this.a, playbackStateCompat.h());
    }

    public void a(q qVar, Handler handler) {
        w.a(this.a, qVar.a, handler);
    }

    public void a(String str, Bundle bundle) {
        w.a(this.a, str, bundle);
    }

    public void a(boolean z) {
        w.a(this.a, z);
    }

    public boolean a() {
        return w.b(this.a);
    }

    public void b() {
        w.c(this.a);
    }

    public void b(int i) {
        w.b(this.a, i);
    }

    public Token c() {
        return this.b;
    }

    public Object d() {
        return this.a;
    }
}
