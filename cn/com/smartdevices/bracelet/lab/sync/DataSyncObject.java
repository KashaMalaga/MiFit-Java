package cn.com.smartdevices.bracelet.lab.sync;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.UUID;

public class DataSyncObject implements Parcelable {
    public static final Creator<DataSyncObject> CREATOR = new a();
    public String a = UUID.randomUUID().toString();
    public Bundle b;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeBundle(this.b);
    }
}
