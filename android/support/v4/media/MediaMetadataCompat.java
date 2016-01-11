package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.l.a;
import android.util.Log;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
    private static final String A = "MediaMetadata";
    private static final int B = 0;
    private static final int C = 1;
    public static final Creator<MediaMetadataCompat> CREATOR = new a();
    private static final int D = 2;
    private static final int E = 3;
    private static final a<String, Integer> F = new a();
    public static final String a = "android.media.metadata.TITLE";
    public static final String b = "android.media.metadata.ARTIST";
    public static final String c = "android.media.metadata.DURATION";
    public static final String d = "android.media.metadata.ALBUM";
    public static final String e = "android.media.metadata.AUTHOR";
    public static final String f = "android.media.metadata.WRITER";
    public static final String g = "android.media.metadata.COMPOSER";
    public static final String h = "android.media.metadata.COMPILATION";
    public static final String i = "android.media.metadata.DATE";
    public static final String j = "android.media.metadata.YEAR";
    public static final String k = "android.media.metadata.GENRE";
    public static final String l = "android.media.metadata.TRACK_NUMBER";
    public static final String m = "android.media.metadata.NUM_TRACKS";
    public static final String n = "android.media.metadata.DISC_NUMBER";
    public static final String o = "android.media.metadata.ALBUM_ARTIST";
    public static final String p = "android.media.metadata.ART";
    public static final String q = "android.media.metadata.ART_URI";
    public static final String r = "android.media.metadata.ALBUM_ART";
    public static final String s = "android.media.metadata.ALBUM_ART_URI";
    public static final String t = "android.media.metadata.USER_RATING";
    public static final String u = "android.media.metadata.RATING";
    public static final String v = "android.media.metadata.DISPLAY_TITLE";
    public static final String w = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String x = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String y = "android.media.metadata.DISPLAY_ICON";
    public static final String z = "android.media.metadata.DISPLAY_ICON_URI";
    private final Bundle G;
    private Object H;

    static {
        F.put(a, Integer.valueOf(C));
        F.put(b, Integer.valueOf(C));
        F.put(c, Integer.valueOf(B));
        F.put(d, Integer.valueOf(C));
        F.put(e, Integer.valueOf(C));
        F.put(f, Integer.valueOf(C));
        F.put(g, Integer.valueOf(C));
        F.put(h, Integer.valueOf(C));
        F.put(i, Integer.valueOf(C));
        F.put(j, Integer.valueOf(B));
        F.put(k, Integer.valueOf(C));
        F.put(l, Integer.valueOf(B));
        F.put(m, Integer.valueOf(B));
        F.put(n, Integer.valueOf(B));
        F.put(o, Integer.valueOf(C));
        F.put(p, Integer.valueOf(D));
        F.put(q, Integer.valueOf(C));
        F.put(r, Integer.valueOf(D));
        F.put(s, Integer.valueOf(C));
        F.put(t, Integer.valueOf(E));
        F.put(u, Integer.valueOf(E));
        F.put(v, Integer.valueOf(C));
        F.put(w, Integer.valueOf(C));
        F.put(x, Integer.valueOf(C));
        F.put(y, Integer.valueOf(D));
        F.put(z, Integer.valueOf(C));
    }

    private MediaMetadataCompat(Bundle bundle) {
        this.G = new Bundle(bundle);
    }

    private MediaMetadataCompat(Parcel parcel) {
        this.G = parcel.readBundle();
    }

    public static MediaMetadataCompat a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        b bVar = new b();
        for (String str : c.a(obj)) {
            Integer num = (Integer) F.get(str);
            if (num != null) {
                switch (num.intValue()) {
                    case B /*0*/:
                        bVar.a(str, c.b(obj, str));
                        break;
                    case C /*1*/:
                        bVar.a(str, c.d(obj, str));
                        break;
                    case D /*2*/:
                        bVar.a(str, c.a(obj, str));
                        break;
                    case E /*3*/:
                        bVar.a(str, RatingCompat.a(c.c(obj, str)));
                        break;
                    default:
                        break;
                }
            }
        }
        MediaMetadataCompat a = bVar.a();
        a.H = obj;
        return a;
    }

    public int a() {
        return this.G.size();
    }

    public boolean a(String str) {
        return this.G.containsKey(str);
    }

    public CharSequence b(String str) {
        return this.G.getCharSequence(str);
    }

    public Set<String> b() {
        return this.G.keySet();
    }

    public Object c() {
        if (this.H != null || VERSION.SDK_INT < 21) {
            return this.H;
        }
        Object a = d.a();
        for (String str : b()) {
            Integer num = (Integer) F.get(str);
            if (num != null) {
                switch (num.intValue()) {
                    case B /*0*/:
                        d.a(a, str, d(str));
                        break;
                    case C /*1*/:
                        d.a(a, str, b(str));
                        break;
                    case D /*2*/:
                        d.a(a, str, f(str));
                        break;
                    case E /*3*/:
                        d.a(a, str, e(str).g());
                        break;
                    default:
                        break;
                }
            }
        }
        this.H = d.a(a);
        return this.H;
    }

    public String c(String str) {
        CharSequence charSequence = this.G.getCharSequence(str);
        return charSequence != null ? charSequence.toString() : null;
    }

    public long d(String str) {
        return this.G.getLong(str, 0);
    }

    public int describeContents() {
        return B;
    }

    public RatingCompat e(String str) {
        try {
            return (RatingCompat) this.G.getParcelable(str);
        } catch (Throwable e) {
            Log.w(A, "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public Bitmap f(String str) {
        try {
            return (Bitmap) this.G.getParcelable(str);
        } catch (Throwable e) {
            Log.w(A, "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.G);
    }
}
