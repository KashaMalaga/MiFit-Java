package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<BusPath> {
    a() {
    }

    public BusPath a(Parcel parcel) {
        return new BusPath(parcel);
    }

    public BusPath[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
