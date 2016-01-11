package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class r implements Creator<RouteSearchCity> {
    r() {
    }

    public RouteSearchCity a(Parcel parcel) {
        return new RouteSearchCity(parcel);
    }

    public RouteSearchCity[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
