package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class v implements Creator<WalkStep> {
    v() {
    }

    public WalkStep a(Parcel parcel) {
        return new WalkStep(parcel);
    }

    public WalkStep[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
