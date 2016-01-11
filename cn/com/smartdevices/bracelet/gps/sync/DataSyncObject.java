package cn.com.smartdevices.bracelet.gps.sync;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;
import java.util.UUID;

public class DataSyncObject implements Parcelable {
    public static final Creator<DataSyncObject> CREATOR = new C0473f();
    public String a;
    public Bundle b;

    public DataSyncObject() {
        this.a = a.f;
        this.b = null;
        this.a = UUID.randomUUID().toString();
    }

    public static boolean a(DataSyncObject dataSyncObject) {
        return dataSyncObject == null || dataSyncObject.b == null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeBundle(this.b);
    }
}
