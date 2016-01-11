package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator<BusStationItem> {
    c() {
    }

    public BusStationItem a(Parcel parcel) {
        return new BusStationItem(parcel);
    }

    public BusStationItem[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
