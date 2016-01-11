package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class WalkPath extends Path implements Parcelable {
    public static final Creator<WalkPath> CREATOR = new t();
    private List<WalkStep> a;

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(WalkStep.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public List<WalkStep> getSteps() {
        return this.a;
    }

    public void setSteps(List<WalkStep> list) {
        this.a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }
}
