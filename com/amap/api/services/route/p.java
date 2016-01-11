package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.FromAndTo;

final class p implements Creator<FromAndTo> {
    p() {
    }

    public FromAndTo a(Parcel parcel) {
        return new FromAndTo(parcel);
    }

    public FromAndTo[] a(int i) {
        return new FromAndTo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
