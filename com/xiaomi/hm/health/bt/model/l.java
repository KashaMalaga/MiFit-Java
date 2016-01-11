package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.xiaomi.hm.health.bt.b.c;

final class l implements Creator<HwConnStatus> {
    l() {
    }

    public HwConnStatus a(Parcel parcel) {
        HwConnStatus hwConnStatus = new HwConnStatus();
        hwConnStatus.k = parcel.readInt();
        hwConnStatus.l = (c) parcel.readSerializable();
        return hwConnStatus;
    }

    public HwConnStatus[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
