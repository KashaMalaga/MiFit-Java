package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new z();
    public static final long a = 1;
    public static final long b = 2;
    public static final long c = 4;
    public static final long d = 8;
    public static final long e = 16;
    public static final long f = 32;
    public static final long g = 64;
    public static final long h = 128;
    public static final long i = 256;
    public static final long j = 512;
    public static final long k = 1024;
    public static final long l = 2048;
    public static final long m = 4096;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 4;
    public static final int s = 5;
    public static final int t = 6;
    public static final int u = 7;
    public static final int v = 8;
    public static final int w = 9;
    public static final int x = 10;
    public static final long y = -1;
    private final long A;
    private final long B;
    private final float C;
    private final long D;
    private final CharSequence E;
    private final long F;
    private Object G;
    private final int z;

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4) {
        this.z = i;
        this.A = j;
        this.B = j2;
        this.C = f;
        this.D = j3;
        this.E = charSequence;
        this.F = j4;
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.z = parcel.readInt();
        this.A = parcel.readLong();
        this.C = parcel.readFloat();
        this.F = parcel.readLong();
        this.B = parcel.readLong();
        this.D = parcel.readLong();
        this.E = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public static PlaybackStateCompat a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(B.a(obj), B.b(obj), B.c(obj), B.d(obj), B.e(obj), B.f(obj), B.g(obj));
        playbackStateCompat.G = obj;
        return playbackStateCompat;
    }

    public int a() {
        return this.z;
    }

    public long b() {
        return this.A;
    }

    public long c() {
        return this.B;
    }

    public float d() {
        return this.C;
    }

    public int describeContents() {
        return n;
    }

    public long e() {
        return this.D;
    }

    public CharSequence f() {
        return this.E;
    }

    public long g() {
        return this.F;
    }

    public Object h() {
        if (this.G != null || VERSION.SDK_INT < 21) {
            return this.G;
        }
        this.G = B.a(this.z, this.A, this.B, this.C, this.D, this.E, this.F);
        return this.G;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.z);
        stringBuilder.append(", position=").append(this.A);
        stringBuilder.append(", buffered position=").append(this.B);
        stringBuilder.append(", speed=").append(this.C);
        stringBuilder.append(", updated=").append(this.F);
        stringBuilder.append(", actions=").append(this.D);
        stringBuilder.append(", error=").append(this.E);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.z);
        parcel.writeLong(this.A);
        parcel.writeFloat(this.C);
        parcel.writeLong(this.F);
        parcel.writeLong(this.B);
        parcel.writeLong(this.D);
        TextUtils.writeToParcel(this.E, parcel, i);
    }
}
