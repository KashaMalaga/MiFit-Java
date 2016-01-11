package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator<BusRouteResult> {
    b() {
    }

    public BusRouteResult a(Parcel parcel) {
        return new BusRouteResult(parcel);
    }

    public BusRouteResult[] a(int i) {
        return new BusRouteResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
