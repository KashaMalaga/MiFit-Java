package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class z implements Creator<PlaybackStateCompat> {
    z() {
    }

    public PlaybackStateCompat a(Parcel parcel) {
        return new PlaybackStateCompat(parcel);
    }

    public PlaybackStateCompat[] a(int i) {
        return new PlaybackStateCompat[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
