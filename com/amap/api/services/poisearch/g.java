package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g implements Creator<PoiItemDetail> {
    g() {
    }

    public PoiItemDetail a(Parcel parcel) {
        return new PoiItemDetail(parcel);
    }

    public PoiItemDetail[] a(int i) {
        return new PoiItemDetail[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
