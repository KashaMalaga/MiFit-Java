package com.xiaomi.channel.gamesdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;

public class Retobj implements Parcelable {
    public static final Creator<Retobj> CREATOR = new e();
    private int a = -1;
    private String b = a.f;

    public Retobj(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }
}
