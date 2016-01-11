package com.xiaomi.channel.gamesdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e implements Creator<Retobj> {
    e() {
    }

    public Retobj a(Parcel parcel) {
        return new Retobj(parcel);
    }

    public Retobj[] a(int i) {
        return new Retobj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
