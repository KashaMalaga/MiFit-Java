package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator<RegeocodeRoad> {
    d() {
    }

    public RegeocodeRoad a(Parcel parcel) {
        return new RegeocodeRoad(parcel);
    }

    public RegeocodeRoad[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
