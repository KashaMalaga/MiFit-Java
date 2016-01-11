package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Bundle;

public final class b {
    private final Bundle a;

    public b() {
        this.a = new Bundle();
    }

    public b(MediaMetadataCompat mediaMetadataCompat) {
        this.a = new Bundle(mediaMetadataCompat.G);
    }

    public MediaMetadataCompat a() {
        return new MediaMetadataCompat(this.a);
    }

    public b a(String str, long j) {
        if (!MediaMetadataCompat.F.containsKey(str) || ((Integer) MediaMetadataCompat.F.get(str)).intValue() == 0) {
            this.a.putLong(str, j);
            return this;
        }
        throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
    }

    public b a(String str, Bitmap bitmap) {
        if (!MediaMetadataCompat.F.containsKey(str) || ((Integer) MediaMetadataCompat.F.get(str)).intValue() == 2) {
            this.a.putParcelable(str, bitmap);
            return this;
        }
        throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
    }

    public b a(String str, RatingCompat ratingCompat) {
        if (!MediaMetadataCompat.F.containsKey(str) || ((Integer) MediaMetadataCompat.F.get(str)).intValue() == 3) {
            this.a.putParcelable(str, ratingCompat);
            return this;
        }
        throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
    }

    public b a(String str, CharSequence charSequence) {
        if (!MediaMetadataCompat.F.containsKey(str) || ((Integer) MediaMetadataCompat.F.get(str)).intValue() == 1) {
            this.a.putCharSequence(str, charSequence);
            return this;
        }
        throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
    }

    public b a(String str, String str2) {
        if (!MediaMetadataCompat.F.containsKey(str) || ((Integer) MediaMetadataCompat.F.get(str)).intValue() == 1) {
            this.a.putCharSequence(str, str2);
            return this;
        }
        throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
    }
}
