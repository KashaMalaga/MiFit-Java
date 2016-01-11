package com.amap.api.location.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f implements Creator<GeoPoint> {
    f() {
    }

    public GeoPoint a(Parcel parcel) {
        return new GeoPoint(parcel);
    }

    public GeoPoint[] a(int i) {
        return new GeoPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
