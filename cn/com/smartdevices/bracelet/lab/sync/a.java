package cn.com.smartdevices.bracelet.lab.sync;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a implements Creator<DataSyncObject> {
    a() {
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
