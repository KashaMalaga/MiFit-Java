package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.xiaomi.hm.health.bt.b.c;

final class n implements Creator<HwSyncDataStatus> {
    n() {
    }

    public HwSyncDataStatus a(Parcel parcel) {
        boolean z = true;
        HwSyncDataStatus hwSyncDataStatus = new HwSyncDataStatus();
        hwSyncDataStatus.e = parcel.readInt();
        hwSyncDataStatus.f = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        hwSyncDataStatus.g = z;
        hwSyncDataStatus.h = (c) parcel.readSerializable();
        return hwSyncDataStatus;
    }

    public HwSyncDataStatus[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
