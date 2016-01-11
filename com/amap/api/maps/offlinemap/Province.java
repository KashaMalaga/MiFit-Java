package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class Province implements Parcelable {
    public static final Creator<Province> CREATOR = new i();
    private String a;
    private String b;
    private String c;
    private String d;
    private ArrayList<OfflineMapCity> e;

    public Province(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        return this.e == null ? new ArrayList() : this.e;
    }

    public String getJianpin() {
        return this.b;
    }

    public String getPinyin() {
        return this.c;
    }

    public String getProvinceCode() {
        return this.d;
    }

    public String getProvinceName() {
        return this.a;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.e = arrayList;
    }

    public void setJianpin(String str) {
        this.b = str;
    }

    public void setPinyin(String str) {
        this.c = str;
    }

    public void setProvinceCode(String str) {
        this.d = str;
    }

    public void setProvinceName(String str) {
        this.a = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeTypedList(this.e);
    }
}
