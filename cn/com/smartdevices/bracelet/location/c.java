package cn.com.smartdevices.bracelet.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import cn.com.smartdevices.bracelet.location.Location.Address;

final class c implements Creator<Address> {
    c() {
    }

    public Address a(Parcel parcel) {
        return new Address(parcel);
    }

    public Address[] a(int i) {
        return new Address[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
