package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Creator<RouteBusLineItem> CREATOR = new j();
    private BusStationItem a;
    private BusStationItem b;
    private List<LatLonPoint> c;
    private int d;
    private List<BusStationItem> e;
    private float f;

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        if (this.b == null) {
            if (routeBusLineItem.b != null) {
                return false;
            }
        } else if (!this.b.equals(routeBusLineItem.b)) {
            return false;
        }
        return this.a == null ? routeBusLineItem.a == null : this.a.equals(routeBusLineItem.a);
    }

    public BusStationItem getArrivalBusStation() {
        return this.b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.a;
    }

    public float getDuration() {
        return this.f;
    }

    public int getPassStationNum() {
        return this.d;
    }

    public List<BusStationItem> getPassStations() {
        return this.e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.c;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.b == null ? 0 : this.b.hashCode()) + (super.hashCode() * 31)) * 31;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.a = busStationItem;
    }

    public void setDuration(float f) {
        this.f = f;
    }

    public void setPassStationNum(int i) {
        this.d = i;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeFloat(this.f);
    }
}
