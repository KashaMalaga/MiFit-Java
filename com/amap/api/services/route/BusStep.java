package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class BusStep implements Parcelable {
    public static final Creator<BusStep> CREATOR = new c();
    private RouteBusWalkItem a;
    private List<RouteBusLineItem> b;
    private Doorway c;
    private Doorway d;

    public BusStep(Parcel parcel) {
        this.a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public RouteBusLineItem getBusLine() {
        return (this.b == null || this.b.size() == 0) ? null : (RouteBusLineItem) this.b.get(0);
    }

    public Doorway getEntrance() {
        return this.c;
    }

    public Doorway getExit() {
        return this.d;
    }

    public RouteBusWalkItem getWalk() {
        return this.a;
    }

    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        if (this.b != null) {
            if (this.b.size() == 0) {
                this.b.add(routeBusLineItem);
            }
            this.b.set(0, routeBusLineItem);
        }
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.d = doorway;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.a = routeBusWalkItem;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }
}
