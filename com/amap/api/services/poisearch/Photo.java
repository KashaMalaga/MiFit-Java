package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Photo implements Parcelable {
    public static final Creator<Photo> CREATOR = new f();
    private String a;
    private String b;

    public Photo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public Photo(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.a;
    }

    public String getUrl() {
        return this.b;
    }

    public void setTitle(String str) {
        this.a = str;
    }

    public void setUrl(String str) {
        this.b = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
