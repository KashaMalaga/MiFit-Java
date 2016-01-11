package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Creator<RouteBusWalkItem> CREATOR = new k();
    private LatLonPoint a;
    private LatLonPoint b;

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.b;
    }

    public LatLonPoint getOrigin() {
        return this.a;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }
}
