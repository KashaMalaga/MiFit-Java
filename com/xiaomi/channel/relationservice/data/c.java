package com.xiaomi.channel.relationservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class c implements Creator<BuddyData> {
    c() {
    }

    public BuddyData a(Parcel parcel) {
        return new BuddyData(parcel);
    }

    public BuddyData[] a(int i) {
        return new BuddyData[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
