package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class DrivePath extends Path implements Parcelable {
    public static final Creator<DrivePath> CREATOR = new f();
    private String a;
    private float b;
    private float c;
    private List<DriveStep> d;

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.createTypedArrayList(DriveStep.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public List<DriveStep> getSteps() {
        return this.d;
    }

    public String getStrategy() {
        return this.a;
    }

    public float getTollDistance() {
        return this.c;
    }

    public float getTolls() {
        return this.b;
    }

    public void setSteps(List<DriveStep> list) {
        this.d = list;
    }

    public void setStrategy(String str) {
        this.a = str;
    }

    public void setTollDistance(float f) {
        this.c = f;
    }

    public void setTolls(float f) {
        this.b = f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeTypedList(this.d);
    }
}
