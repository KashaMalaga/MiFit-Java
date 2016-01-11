package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b implements Creator<Tip> {
    b() {
    }

    public Tip a(Parcel parcel) {
        return new Tip(parcel);
    }

    public Tip[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
