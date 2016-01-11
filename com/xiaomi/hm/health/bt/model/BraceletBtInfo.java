package com.xiaomi.hm.health.bt.model;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;

public class BraceletBtInfo implements Parcelable {
    public static final Creator<BraceletBtInfo> CREATOR = new g();
    public int a = -1;
    public String b = a.f;
    public String c = a.f;
    public String d = a.f;
    public String e = a.f;

    public boolean a() {
        return this.b != null && this.b.length() > 0 && BluetoothAdapter.checkBluetoothAddress(this.b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
