package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class StreetNumber implements Parcelable {
    public static final Creator<StreetNumber> CREATOR = new e();
    private String a;
    private String b;
    private LatLonPoint c;
    private String d;
    private float e;

    private StreetNumber(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readFloat();
    }

    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.d;
    }

    public float getDistance() {
        return this.e;
    }

    public LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public String getNumber() {
        return this.b;
    }

    public String getStreet() {
        return this.a;
    }

    public void setDirection(String str) {
        this.d = str;
    }

    public void setDistance(float f) {
        this.e = f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setNumber(String str) {
        this.b = str;
    }

    public void setStreet(String str) {
        this.a = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
    }
}
