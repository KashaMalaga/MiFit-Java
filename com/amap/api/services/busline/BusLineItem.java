package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.e;
import java.util.Date;
import java.util.List;

public class BusLineItem implements Parcelable {
    public static final Creator<BusLineItem> CREATOR = new a();
    private float a;
    private String b;
    private String c;
    private String d;
    private List<LatLonPoint> e;
    private List<LatLonPoint> f;
    private String g;
    private String h;
    private String i;
    private Date j;
    private Date k;
    private String l;
    private float m;
    private float n;
    private List<BusStationItem> o;

    public BusLineItem(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = e.e(parcel.readString());
        this.k = e.e(parcel.readString());
        this.l = parcel.readString();
        this.m = parcel.readFloat();
        this.n = parcel.readFloat();
        this.o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BusLineItem busLineItem = (BusLineItem) obj;
        return this.g == null ? busLineItem.g == null : this.g.equals(busLineItem.g);
    }

    public float getBasicPrice() {
        return this.m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f;
    }

    public String getBusCompany() {
        return this.l;
    }

    public String getBusLineId() {
        return this.g;
    }

    public String getBusLineName() {
        return this.b;
    }

    public String getBusLineType() {
        return this.c;
    }

    public List<BusStationItem> getBusStations() {
        return this.o;
    }

    public String getCityCode() {
        return this.d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.e;
    }

    public float getDistance() {
        return this.a;
    }

    public Date getFirstBusTime() {
        return this.j == null ? null : (Date) this.j.clone();
    }

    public Date getLastBusTime() {
        return this.k == null ? null : (Date) this.k.clone();
    }

    public String getOriginatingStation() {
        return this.h;
    }

    public String getTerminalStation() {
        return this.i;
    }

    public float getTotalPrice() {
        return this.n;
    }

    public int hashCode() {
        return (this.g == null ? 0 : this.g.hashCode()) + 31;
    }

    public void setBasicPrice(float f) {
        this.m = f;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f = list;
    }

    public void setBusCompany(String str) {
        this.l = str;
    }

    public void setBusLineId(String str) {
        this.g = str;
    }

    public void setBusLineName(String str) {
        this.b = str;
    }

    public void setBusLineType(String str) {
        this.c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.o = list;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.e = list;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.j = null;
        } else {
            this.j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.k = null;
        } else {
            this.k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.h = str;
    }

    public void setTerminalStation(String str) {
        this.i = str;
    }

    public void setTotalPrice(float f) {
        this.n = f;
    }

    public String toString() {
        return this.b + " " + e.a(this.j) + "-" + e.a(this.k);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeList(this.e);
        parcel.writeList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(e.a(this.j));
        parcel.writeString(e.a(this.k));
        parcel.writeString(this.l);
        parcel.writeFloat(this.m);
        parcel.writeFloat(this.n);
        parcel.writeList(this.o);
    }
}
