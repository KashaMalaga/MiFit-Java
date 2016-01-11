package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HwBatteryStatus implements Parcelable {
    public static final Creator<HwBatteryStatus> CREATOR = new k();
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public int e = a;
    public int f = a;

    public HwBatteryStatus(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public static int a(int i) {
        int i2 = b;
        if (i <= 10 && i > 5) {
            return a;
        }
        if (((i > c ? b : a) & (i <= 5 ? b : a)) != 0) {
            return b;
        }
        int i3 = i <= c ? b : a;
        if (i <= 0) {
            i2 = a;
        }
        return (i3 & i2) != 0 ? c : i == 0 ? d : -1;
    }

    public int describeContents() {
        return a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }
}
