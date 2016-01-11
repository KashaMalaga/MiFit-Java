package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e implements Creator<RatingCompat> {
    e() {
    }

    public RatingCompat a(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }

    public RatingCompat[] a(int i) {
        return new RatingCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
