package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.text.TextUtils;
import android.view.KeyEvent;

public final class C0097a {
    private final e a;

    public C0097a(Context context, Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        } else if (VERSION.SDK_INT >= 21) {
            this.a = new f(context, token);
        } else {
            this.a = new g();
        }
    }

    public C0097a(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        } else if (VERSION.SDK_INT >= 21) {
            this.a = new f(context, mediaSessionCompat);
        } else {
            this.a = new g();
        }
    }

    public i a() {
        return this.a.a();
    }

    public void a(c cVar) {
        a(cVar, null);
    }

    public void a(c cVar, Handler handler) {
        if (cVar == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        this.a.a(cVar, handler);
    }

    public void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        this.a.a(str, bundle, resultReceiver);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.a.a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public PlaybackStateCompat b() {
        return this.a.b();
    }

    public void b(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.a.a(cVar);
    }

    public MediaMetadataCompat c() {
        return this.a.c();
    }

    public int d() {
        return this.a.d();
    }

    public h e() {
        return this.a.e();
    }

    public Object f() {
        return this.a.f();
    }
}
