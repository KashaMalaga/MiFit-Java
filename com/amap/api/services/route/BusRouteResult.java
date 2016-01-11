package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;
import java.util.List;

public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Creator<BusRouteResult> CREATOR = new b();
    private float a;
    private List<BusPath> b;
    private BusRouteQuery c;

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.c = (BusRouteQuery) parcel.readParcelable(BusRouteQuery.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public BusRouteQuery getBusQuery() {
        return this.c;
    }

    public List<BusPath> getPaths() {
        return this.b;
    }

    public float getTaxiCost() {
        return this.a;
    }

    public void setBusQuery(BusRouteQuery busRouteQuery) {
        this.c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.b = list;
    }

    public void setTaxiCost(float f) {
        this.a = f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
    }
}
