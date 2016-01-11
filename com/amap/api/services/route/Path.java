package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Path implements Parcelable {
    public static final Creator<Path> CREATOR = new i();
    private float a;
    private long b;

    public Path(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.a;
    }

    public long getDuration() {
        return this.b;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setDuration(long j) {
        this.b = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeLong(this.b);
    }
}
