package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.edmodo.cropper.cropwindow.CropOverlayView;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new e();
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    private static final String h = "Rating";
    private static final float i = -1.0f;
    private final int j;
    private final float k;
    private Object l;

    private RatingCompat(int i, float f) {
        this.j = i;
        this.k = f;
    }

    public static RatingCompat a(float f) {
        if (f >= 0.0f && f <= CropOverlayView.a) {
            return new RatingCompat(g, f);
        }
        Log.e(h, "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat a(int i) {
        switch (i) {
            case b /*1*/:
            case c /*2*/:
            case d /*3*/:
            case e /*4*/:
            case f /*5*/:
            case g /*6*/:
                return new RatingCompat(i, i);
            default:
                return null;
        }
    }

    public static RatingCompat a(int i, float f) {
        float f2;
        switch (i) {
            case d /*3*/:
                f2 = 3.0f;
                break;
            case e /*4*/:
                f2 = 4.0f;
                break;
            case f /*5*/:
                f2 = 5.0f;
                break;
            default:
                Log.e(h, "Invalid rating style (" + i + ") for a star rating");
                return null;
        }
        if (f >= 0.0f && f <= r1) {
            return new RatingCompat(i, f);
        }
        Log.e(h, "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat a(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && VERSION.SDK_INT >= 21) {
            int b = f.b(obj);
            if (f.a(obj)) {
                switch (b) {
                    case b /*1*/:
                        ratingCompat = a(f.c(obj));
                        break;
                    case c /*2*/:
                        ratingCompat = b(f.d(obj));
                        break;
                    case d /*3*/:
                    case e /*4*/:
                    case f /*5*/:
                        ratingCompat = a(b, f.e(obj));
                        break;
                    case g /*6*/:
                        ratingCompat = a(f.f(obj));
                        break;
                    default:
                        break;
                }
            }
            ratingCompat = a(b);
            ratingCompat.l = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat a(boolean z) {
        return new RatingCompat(b, z ? 1.0f : 0.0f);
    }

    public static RatingCompat b(boolean z) {
        return new RatingCompat(c, z ? 1.0f : 0.0f);
    }

    public boolean a() {
        return this.k >= 0.0f;
    }

    public int b() {
        return this.j;
    }

    public boolean c() {
        boolean z = true;
        if (this.j != b) {
            return false;
        }
        if (this.k != 1.0f) {
            z = false;
        }
        return z;
    }

    public boolean d() {
        return this.j == c && this.k == 1.0f;
    }

    public int describeContents() {
        return this.j;
    }

    public float e() {
        switch (this.j) {
            case d /*3*/:
            case e /*4*/:
            case f /*5*/:
                if (a()) {
                    return this.k;
                }
                break;
        }
        return i;
    }

    public float f() {
        return (this.j == g && a()) ? this.k : i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object g() {
        /*
        r2 = this;
        r0 = r2.l;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x000d;
    L_0x000a:
        r0 = r2.l;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r2.a();
        if (r0 == 0) goto L_0x004a;
    L_0x0013:
        r0 = r2.j;
        switch(r0) {
            case 1: goto L_0x001a;
            case 2: goto L_0x0027;
            case 3: goto L_0x0032;
            case 4: goto L_0x0032;
            case 5: goto L_0x0032;
            case 6: goto L_0x003f;
            default: goto L_0x0018;
        };
    L_0x0018:
        r0 = 0;
        goto L_0x000c;
    L_0x001a:
        r0 = r2.c();
        r0 = android.support.v4.media.f.a(r0);
        r2.l = r0;
    L_0x0024:
        r0 = r2.l;
        goto L_0x000c;
    L_0x0027:
        r0 = r2.d();
        r0 = android.support.v4.media.f.b(r0);
        r2.l = r0;
        goto L_0x0024;
    L_0x0032:
        r0 = r2.j;
        r1 = r2.e();
        r0 = android.support.v4.media.f.a(r0, r1);
        r2.l = r0;
        goto L_0x0024;
    L_0x003f:
        r0 = r2.f();
        r0 = android.support.v4.media.f.a(r0);
        r2.l = r0;
        goto L_0x0018;
    L_0x004a:
        r0 = r2.j;
        r0 = android.support.v4.media.f.a(r0);
        r2.l = r0;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.RatingCompat.g():java.lang.Object");
    }

    public String toString() {
        return "Rating:style=" + this.j + " rating=" + (this.k < 0.0f ? "unrated" : String.valueOf(this.k));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeFloat(this.k);
    }
}
