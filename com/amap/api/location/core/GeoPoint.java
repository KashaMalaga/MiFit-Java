package com.amap.api.location.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;

public class GeoPoint implements Parcelable {
    public static final Creator<GeoPoint> CREATOR = new f();
    private long a;
    private long b;
    private double c;
    private double d;

    public GeoPoint() {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.a = 0;
        this.b = 0;
    }

    public GeoPoint(int i, int i2) {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.a = (long) i;
        this.b = (long) i2;
    }

    public GeoPoint(long j, long j2) {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.a = j;
        this.b = j2;
    }

    private GeoPoint(Parcel parcel) {
        this.a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.a = parcel.readLong();
        this.b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        return this.c == geoPoint.c && this.d == geoPoint.d && this.a == geoPoint.a && this.b == geoPoint.b;
    }

    public int getLatitudeE6() {
        return (int) this.a;
    }

    public int getLongitudeE6() {
        return (int) this.b;
    }

    public int hashCode() {
        return (int) ((this.d * 7.0d) + (this.c * 11.0d));
    }

    public String toString() {
        return a.f + this.a + f.i + this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }
}
