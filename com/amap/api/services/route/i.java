package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i implements Creator<Path> {
    i() {
    }

    public Path a(Parcel parcel) {
        return new Path(parcel);
    }

    public Path[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
