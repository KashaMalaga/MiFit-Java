package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h implements Creator<DriveStep> {
    h() {
    }

    public DriveStep a(Parcel parcel) {
        return new DriveStep(parcel);
    }

    public DriveStep[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
