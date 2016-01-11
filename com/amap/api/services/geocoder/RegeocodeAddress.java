package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.List;

public final class RegeocodeAddress implements Parcelable {
    public static final Creator<RegeocodeAddress> CREATOR = new c();
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private StreetNumber h;
    private String i;
    private String j;
    private List<RegeocodeRoad> k;
    private List<Crossroad> l;
    private List<PoiItem> m;

    private RegeocodeAddress(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.k = parcel.readArrayList(Road.class.getClassLoader());
        this.l = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.m = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.j;
    }

    public String getBuilding() {
        return this.g;
    }

    public String getCity() {
        return this.c;
    }

    public String getCityCode() {
        return this.i;
    }

    public List<Crossroad> getCrossroads() {
        return this.l;
    }

    public String getDistrict() {
        return this.d;
    }

    public String getFormatAddress() {
        return this.a;
    }

    public String getNeighborhood() {
        return this.f;
    }

    public List<PoiItem> getPois() {
        return this.m;
    }

    public String getProvince() {
        return this.b;
    }

    public List<RegeocodeRoad> getRoads() {
        return this.k;
    }

    public StreetNumber getStreetNumber() {
        return this.h;
    }

    public String getTownship() {
        return this.e;
    }

    public void setAdCode(String str) {
        this.j = str;
    }

    public void setBuilding(String str) {
        this.g = str;
    }

    public void setCity(String str) {
        this.c = str;
    }

    public void setCityCode(String str) {
        this.i = str;
    }

    public void setCrossroads(List<Crossroad> list) {
        this.l = list;
    }

    public void setDistrict(String str) {
        this.d = str;
    }

    public void setFormatAddress(String str) {
        this.a = str;
    }

    public void setNeighborhood(String str) {
        this.f = str;
    }

    public void setPois(List<PoiItem> list) {
        this.m = list;
    }

    public void setProvince(String str) {
        this.b = str;
    }

    public void setRoads(List<RegeocodeRoad> list) {
        this.k = list;
    }

    public void setStreetNumber(StreetNumber streetNumber) {
        this.h = streetNumber;
    }

    public void setTownship(String str) {
        this.e = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeValue(this.h);
        parcel.writeList(this.k);
        parcel.writeList(this.l);
        parcel.writeList(this.m);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
