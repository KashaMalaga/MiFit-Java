package cn.com.smartdevices.bracelet.gps.sync;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class C0473f implements Creator<DataSyncObject> {
    C0473f() {
    }

    public DataSyncObject a(Parcel parcel) {
        DataSyncObject dataSyncObject = new DataSyncObject();
        dataSyncObject.a = parcel.readString();
        dataSyncObject.b = parcel.readBundle();
        return dataSyncObject;
    }

    public DataSyncObject[] a(int i) {
        return null;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
