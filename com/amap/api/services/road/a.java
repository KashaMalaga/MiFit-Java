package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<Crossroad> {
    a() {
    }

    public Crossroad a(Parcel parcel) {
        return new Crossroad(parcel);
    }

    public Crossroad[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
