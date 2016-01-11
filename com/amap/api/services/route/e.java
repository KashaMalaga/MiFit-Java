package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e implements Creator<Doorway> {
    e() {
    }

    public Doorway a(Parcel parcel) {
        return new Doorway(parcel);
    }

    public Doorway[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
