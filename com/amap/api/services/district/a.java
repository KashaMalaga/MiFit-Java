package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<DistrictItem> {
    a() {
    }

    public DistrictItem a(Parcel parcel) {
        return new DistrictItem(parcel);
    }

    public DistrictItem[] a(int i) {
        return new DistrictItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
