package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f implements Creator<OfflineMapCity> {
    f() {
    }

    public OfflineMapCity a(Parcel parcel) {
        return new OfflineMapCity(parcel);
    }

    public OfflineMapCity[] a(int i) {
        return new OfflineMapCity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
