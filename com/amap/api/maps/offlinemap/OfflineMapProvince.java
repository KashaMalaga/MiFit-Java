package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OfflineMapProvince extends Province {
    public static final Creator<OfflineMapProvince> CREATOR = new g();
    private String a;
    private int b;
    private long c;
    private String d;
    private int e = 0;

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readLong();
        this.d = parcel.readString();
        this.e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.c;
    }

    public int getState() {
        return this.b;
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
        this.c = j;
    }

    public void setState(int i) {
        this.b = i;
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
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }
}
