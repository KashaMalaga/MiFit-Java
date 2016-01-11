package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g implements Creator<DriveRouteResult> {
    g() {
    }

    public DriveRouteResult a(Parcel parcel) {
        return new DriveRouteResult(parcel);
    }

    public DriveRouteResult[] a(int i) {
        return new DriveRouteResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
