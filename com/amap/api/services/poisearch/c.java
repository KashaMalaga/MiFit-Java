package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator<Discount> {
    c() {
    }

    public Discount a(Parcel parcel) {
        return new Discount(parcel);
    }

    public Discount[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
