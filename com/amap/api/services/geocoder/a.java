package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<GeocodeAddress> {
    a() {
    }

    public GeocodeAddress a(Parcel parcel) {
        return new GeocodeAddress(parcel);
    }

    public GeocodeAddress[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
