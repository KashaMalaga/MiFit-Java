package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class u implements Creator<WalkRouteResult> {
    u() {
    }

    public WalkRouteResult a(Parcel parcel) {
        return new WalkRouteResult(parcel);
    }

    public WalkRouteResult[] a(int i) {
        return new WalkRouteResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
