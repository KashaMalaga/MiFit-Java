package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;

public class OfflineMapCity extends City {
    public static final Creator<OfflineMapCity> CREATOR = new f();
    private String a = a.f;
    private long b = 0;
    private int c = 0;
    private String d = a.f;
    private int e = 0;

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readLong();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.b;
    }

    public int getState() {
        return this.c;
    }

    public String getUrl() {
        return this.a;
    }

    public String getVersion() {
        return this.d;
    }

    public int getcompleteCode() {
        return this.e;
    }

    public void setCompleteCode(int i) {
        this.e = i;
    }

    public void setSize(long j) {
        this.b = j;
    }

    public void setState(int i) {
        this.c = i;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public void setVersion(String str) {
        this.d = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }
}
