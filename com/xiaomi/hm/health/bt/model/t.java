package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class t implements Creator<UserInfo> {
    t() {
    }

    public UserInfo a(Parcel parcel) {
        return new UserInfo(parcel.readInt(), parcel.readByte(), parcel.readByte(), parcel.readByte(), parcel.readByte(), parcel.readByte(), parcel.readString().getBytes());
    }

    public UserInfo[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
