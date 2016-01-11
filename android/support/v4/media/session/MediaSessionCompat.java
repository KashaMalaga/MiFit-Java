package android.support.v4.media.session;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.s;
import android.text.TextUtils;

public class MediaSessionCompat {
    public static final int a = 1;
    public static final int b = 2;
    private final s c;

    public final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new v();
        private final Parcelable a;

        Token(Parcelable parcelable) {
            this.a = parcelable;
        }

        public Object a() {
            return this.a;
        }

        public int describeContents() {
            return this.a.describeContents();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
        }
    }

    public MediaSessionCompat(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        } else if (VERSION.SDK_INT >= 21) {
            this.c = new t(context, str);
        } else {
            this.c = new u();
        }
    }

    private MediaSessionCompat(s sVar) {
        this.c = sVar;
    }

    public static MediaSessionCompat a(Object obj) {
        return new MediaSessionCompat(new t(obj));
    }

    public void a(int i) {
        this.c.a(i);
    }

    public void a(MediaMetadataCompat mediaMetadataCompat) {
        this.c.a(mediaMetadataCompat);
    }

    public void a(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.c.a(sVar);
    }

    public void a(PlaybackStateCompat playbackStateCompat) {
        this.c.a(playbackStateCompat);
    }

    public void a(q qVar) {
        a(qVar, null);
    }

    public void a(q qVar, Handler handler) {
        s sVar = this.c;
        if (handler == null) {
            handler = new Handler();
        }
        sVar.a(qVar, handler);
    }

    public void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.c.a(str, bundle);
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public boolean a() {
        return this.c.a();
    }

    public void b() {
        this.c.b();
    }

    public void b(int i) {
        this.c.b(i);
    }

    public Token c() {
        return this.c.c();
    }

    public Object d() {
        return this.c.d();
    }
}
