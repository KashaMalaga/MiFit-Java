package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g implements Creator<BraceletBtInfo> {
    g() {
    }

    public BraceletBtInfo a(Parcel parcel) {
        BraceletBtInfo braceletBtInfo = new BraceletBtInfo();
        braceletBtInfo.a = parcel.readInt();
        braceletBtInfo.c = parcel.readString();
        braceletBtInfo.b = parcel.readString();
        braceletBtInfo.d = parcel.readString();
        braceletBtInfo.e = parcel.readString();
        return braceletBtInfo;
    }

    public BraceletBtInfo[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
