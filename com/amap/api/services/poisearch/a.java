package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<Cinema> {
    a() {
    }

    public Cinema a(Parcel parcel) {
        return new Cinema(parcel);
    }

    public Cinema[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
