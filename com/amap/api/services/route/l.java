package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class l implements Creator<RouteResult> {
    l() {
    }

    public RouteResult a(Parcel parcel) {
        return new RouteResult(parcel);
    }

    public RouteResult[] a(int i) {
        return new RouteResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
