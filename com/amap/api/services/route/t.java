package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class t implements Creator<WalkPath> {
    t() {
    }

    public WalkPath a(Parcel parcel) {
        return new WalkPath(parcel);
    }

    public WalkPath[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
