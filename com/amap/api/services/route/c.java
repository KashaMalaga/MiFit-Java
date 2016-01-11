package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator<BusStep> {
    c() {
    }

    public BusStep a(Parcel parcel) {
        return new BusStep(parcel);
    }

    public BusStep[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
