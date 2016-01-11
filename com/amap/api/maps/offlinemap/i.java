package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i implements Creator<Province> {
    i() {
    }

    public Province a(Parcel parcel) {
        return new Province(parcel);
    }

    public Province[] a(int i) {
        return new Province[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
