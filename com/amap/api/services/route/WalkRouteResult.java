package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;
import java.util.List;

public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Creator<WalkRouteResult> CREATOR = new u();
    private List<WalkPath> a;
    private WalkRouteQuery b;

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.b = (WalkRouteQuery) parcel.readParcelable(WalkRouteQuery.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.a;
    }

    public WalkRouteQuery getWalkQuery() {
        return this.b;
    }

    public void setPaths(List<WalkPath> list) {
        this.a = list;
    }

    public void setWalkQuery(WalkRouteQuery walkRouteQuery) {
        this.b = walkRouteQuery;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeParcelable(this.b, i);
    }
}
