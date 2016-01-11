package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.a.C0113o;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public final class UserInfo implements Parcelable {
    public static final Creator<UserInfo> CREATOR = new t();
    public static final byte a = (byte) 0;
    public static final byte b = (byte) 1;
    public static final byte c = (byte) 2;
    public static final UserInfo k = new UserInfo(170420175, a, (byte) 23, (byte) -88, (byte) 50, "anri.okita\u0000".getBytes());
    public final int d;
    public final byte e;
    public final byte f;
    public final byte g;
    public final byte h;
    public final byte[] i;
    public byte j;

    public UserInfo(int i, byte b, byte b2, byte b3, byte b4, byte b5, byte[] bArr) {
        this.d = i;
        this.e = b;
        this.f = b2;
        this.g = b3;
        this.h = b4;
        this.i = bArr;
        this.j = b5;
    }

    public UserInfo(int i, byte b, byte b2, byte b3, byte b4, byte[] bArr) {
        this.d = i;
        this.e = b;
        this.f = b2;
        this.g = b3;
        this.h = b4;
        this.i = bArr;
        this.j = a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
        stringBuilder.append("\n     uid: " + this.d);
        stringBuilder.append("\n  gender: " + (this.e == (byte) 0 ? "female" : "male"));
        stringBuilder.append("\n     age: " + this.f + "yrs");
        stringBuilder.append("\n  height: " + (this.g & HeartRateInfo.HR_EMPTY_VALUE) + "cm");
        stringBuilder.append("\n  weight: " + (this.h & HeartRateInfo.HR_EMPTY_VALUE) + "kg");
        stringBuilder.append("\n   alias: " + new String(this.i));
        stringBuilder.append("\n   type: " + this.j);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeByte(this.e);
        parcel.writeByte(this.f);
        parcel.writeByte(this.g);
        parcel.writeByte(this.h);
        parcel.writeString(new String(this.i));
        parcel.writeByte(this.j);
    }
}
