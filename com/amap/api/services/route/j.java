package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j implements Creator<RouteBusLineItem> {
    j() {
    }

    public RouteBusLineItem a(Parcel parcel) {
        return new RouteBusLineItem(parcel);
    }

    public RouteBusLineItem[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
