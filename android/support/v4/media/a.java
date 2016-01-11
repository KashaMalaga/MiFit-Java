package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<MediaMetadataCompat> {
    a() {
    }

    public MediaMetadataCompat a(Parcel parcel) {
        return new MediaMetadataCompat(parcel);
    }

    public MediaMetadataCompat[] a(int i) {
        return new MediaMetadataCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
