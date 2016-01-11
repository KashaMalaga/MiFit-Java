package cn.com.smartdevices.bracelet.relation.db;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Creator<Friend> {
    c() {
    }

    public Friend a(Parcel parcel) {
        return new Friend(parcel);
    }

    public Friend[] a(int i) {
        return new Friend[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
