package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;

final class n implements Creator<BusRouteQuery> {
    n() {
    }

    public BusRouteQuery a(Parcel parcel) {
        return new BusRouteQuery(parcel);
    }

    public BusRouteQuery[] a(int i) {
        return new BusRouteQuery[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
