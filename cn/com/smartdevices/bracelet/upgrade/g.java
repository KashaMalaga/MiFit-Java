package cn.com.smartdevices.bracelet.upgrade;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g implements Creator<OtaVersionInfo> {
    g() {
    }

    public OtaVersionInfo a(Parcel parcel) {
        return new OtaVersionInfo(parcel);
    }

    public OtaVersionInfo[] a(int i) {
        return new OtaVersionInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
