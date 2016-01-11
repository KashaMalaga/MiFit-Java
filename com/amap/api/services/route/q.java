package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;

final class q implements Creator<WalkRouteQuery> {
    q() {
    }

    public WalkRouteQuery a(Parcel parcel) {
        return new WalkRouteQuery(parcel);
    }

    public WalkRouteQuery[] a(int i) {
        return new WalkRouteQuery[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
