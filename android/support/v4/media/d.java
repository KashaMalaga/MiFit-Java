package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata.Builder;
import android.media.Rating;

public class d {
    public static Object a() {
        return new Builder();
    }

    public static Object a(Object obj) {
        return ((Builder) obj).build();
    }

    public static void a(Object obj, String str, long j) {
        ((Builder) obj).putLong(str, j);
    }

    public static void a(Object obj, String str, Bitmap bitmap) {
        ((Builder) obj).putBitmap(str, bitmap);
    }

    public static void a(Object obj, String str, CharSequence charSequence) {
        ((Builder) obj).putText(str, charSequence);
    }

    public static void a(Object obj, String str, Object obj2) {
        ((Builder) obj).putRating(str, (Rating) obj2);
    }

    public static void a(Object obj, String str, String str2) {
        ((Builder) obj).putString(str, str2);
    }
}
