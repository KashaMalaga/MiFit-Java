package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchCity implements Parcelable {
    public static final Creator<SearchCity> CREATOR = new s();
    private String a;
    private String b;
    private String c;

    public SearchCity(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.c;
    }

    public String getSearchCityName() {
        return this.a;
    }

    public String getSearchCitycode() {
        return this.b;
    }

    public void setSearchCityName(String str) {
        this.a = str;
    }

    public void setSearchCitycode(String str) {
        this.b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.c = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
