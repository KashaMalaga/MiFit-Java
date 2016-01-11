package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator<RegeocodeAddress> {
    c() {
    }

    public RegeocodeAddress a(Parcel parcel) {
        return new RegeocodeAddress(parcel);
    }

    public RegeocodeAddress[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
