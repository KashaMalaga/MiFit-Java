package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;

public final class LatLonPoint implements Parcelable {
    public static final Creator<LatLonPoint> CREATOR = new n();
    private double a;
    private double b;

    public LatLonPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    private LatLonPoint(Parcel parcel) {
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.a, this.b);
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
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.a) != Double.doubleToLongBits(latLonPoint.a) ? false : Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLonPoint.b);
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public String toString() {
        return a.f + this.a + f.i + this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }
}
