package android.support.v4.media.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.view.KeyEvent;

class f implements e {
    private final Object a;

    public f(Context context, Token token) {
        this.a = k.a(context, token.a());
        if (this.a == null) {
            throw new RemoteException();
        }
    }

    public f(Context context, MediaSessionCompat mediaSessionCompat) {
        this.a = k.a(context, mediaSessionCompat.c().a());
    }

    public i a() {
        Object a = k.a(this.a);
        return a != null ? new j(a) : null;
    }

    public void a(c cVar) {
        k.a(this.a, cVar.a);
    }

    public void a(c cVar, Handler handler) {
        k.a(this.a, cVar.a, handler);
    }

    public void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
        k.a(this.a, str, bundle, resultReceiver);
    }

    public boolean a(KeyEvent keyEvent) {
        return k.a(this.a, keyEvent);
    }

    public PlaybackStateCompat b() {
        Object b = k.b(this.a);
        return b != null ? PlaybackStateCompat.a(b) : null;
    }

    public MediaMetadataCompat c() {
        Object c = k.c(this.a);
        return c != null ? MediaMetadataCompat.a(c) : null;
    }

    public int d() {
        return k.d(this.a);
    }

    public h e() {
        Object e = k.e(this.a);
        return e != null ? new h(n.a(e), n.c(e), n.d(e), n.e(e), n.f(e)) : null;
    }

    public Object f() {
        return this.a;
    }
}
