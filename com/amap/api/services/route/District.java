package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class District implements Parcelable {
    public static final Creator<District> CREATOR = new d();
    private String a;
    private String b;

    public District(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.b;
    }

    public String getDistrictName() {
        return this.a;
    }

    public void setDistrictAdcode(String str) {
        this.b = str;
    }

    public void setDistrictName(String str) {
        this.a = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
