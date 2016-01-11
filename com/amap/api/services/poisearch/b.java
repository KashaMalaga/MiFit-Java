package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator<Dining> {
    b() {
    }

    public Dining a(Parcel parcel) {
        return new Dining(parcel);
    }

    public Dining[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
