package cn.com.smartdevices.bracelet.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator<Location> {
    b() {
    }

    public Location a(Parcel parcel) {
        return new Location(parcel);
    }

    public Location[] a(int i) {
        return new Location[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
