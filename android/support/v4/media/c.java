package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import java.util.Set;

class c {
    c() {
    }

    public static Bitmap a(Object obj, String str) {
        return ((MediaMetadata) obj).getBitmap(str);
    }

    public static Set<String> a(Object obj) {
        return ((MediaMetadata) obj).keySet();
    }

    public static long b(Object obj, String str) {
        return ((MediaMetadata) obj).getLong(str);
    }

    public static Object c(Object obj, String str) {
        return ((MediaMetadata) obj).getRating(str);
    }

    public static CharSequence d(Object obj, String str) {
        return ((MediaMetadata) obj).getText(str);
    }
}
