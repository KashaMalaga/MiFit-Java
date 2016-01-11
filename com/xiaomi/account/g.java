package com.xiaomi.account;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g implements Creator<XiaomiOAuthResponse> {
    g() {
    }

    public XiaomiOAuthResponse a(Parcel parcel) {
        return new XiaomiOAuthResponse(parcel);
    }

    public XiaomiOAuthResponse[] a(int i) {
        return new XiaomiOAuthResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
