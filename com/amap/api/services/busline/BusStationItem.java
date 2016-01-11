package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

public class BusStationItem implements Parcelable {
    public static final Creator<BusStationItem> CREATOR = new c();
    private String a;
    private String b;
    private LatLonPoint c;
    private String d;
    private String e;
    private List<BusLineItem> f;

    private BusStationItem(Parcel parcel) {
        this.b = parcel.readString();
        this.a = parcel.readString();
        this.c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }

    private String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(((BusLineItem) list.get(i)).getBusLineName());
                if (i < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
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
        BusStationItem busStationItem = (BusStationItem) obj;
        return this.a == null ? busStationItem.a == null : this.a.equals(busStationItem.a);
    }

    public String getAdCode() {
        return this.e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f;
    }

    public String getBusStationId() {
        return this.a;
    }

    public String getBusStationName() {
        return this.b;
    }

    public String getCityCode() {
        return this.d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public int hashCode() {
        return (this.a == null ? 0 : this.a.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f = list;
    }

    public void setBusStationId(String str) {
        this.a = str;
    }

    public void setBusStationName(String str) {
        this.b = str;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public String toString() {
        return "BusStationName: " + this.b + " LatLonPoint: " + this.c.toString() + " BusLines: " + a(this.f) + " CityCode: " + this.d + " AdCode: " + this.e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeList(this.f);
    }
}
