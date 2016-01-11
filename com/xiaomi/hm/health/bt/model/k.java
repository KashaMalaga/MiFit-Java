package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class k implements Creator<HwBatteryStatus> {
    k() {
    }

    public HwBatteryStatus a(Parcel parcel) {
        HwBatteryStatus hwBatteryStatus = new HwBatteryStatus();
        hwBatteryStatus.e = parcel.readInt();
        hwBatteryStatus.f = parcel.readInt();
        return hwBatteryStatus;
    }

    public HwBatteryStatus[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
