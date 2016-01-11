package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class RegeocodeRoad implements Parcelable {
    public static final Creator<RegeocodeRoad> CREATOR = new d();
    private String a;
    private String b;
    private float c;
    private String d;
    private LatLonPoint e;

    private RegeocodeRoad(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readString();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.d;
    }

    public float getDistance() {
        return this.c;
    }

    public String getId() {
        return this.a;
    }

    public LatLonPoint getLatLngPoint() {
        return this.e;
    }

    public String getName() {
        return this.b;
    }

    public void setDirection(String str) {
        this.d = str;
    }

    public void setDistance(float f) {
        this.c = f;
    }

    public void setId(String str) {
        this.a = str;
    }

    public void setLatLngPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeString(this.d);
        parcel.writeValue(this.e);
    }
}
