package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.hm.health.bt.b.c;

public class HwSyncDataStatus implements Parcelable {
    public static final Creator<HwSyncDataStatus> CREATOR = new n();
    public static final int a = -1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    private int e = a;
    private int f = 0;
    private boolean g = true;
    private c h = c.MILI;

    public HwSyncDataStatus(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public HwSyncDataStatus(int i, int i2, boolean z) {
        this.e = i;
        this.f = i2;
        this.g = z;
    }

    public HwSyncDataStatus(c cVar) {
        this.h = cVar;
    }

    public void a(c cVar) {
        this.h = cVar;
    }

    public boolean a() {
        return this.e == a;
    }

    public boolean b() {
        return this.e == b;
    }

    public boolean c() {
        return this.e == c;
    }

    public boolean d() {
        return this.e == d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.e == b || this.e == c;
    }

    public int f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public c h() {
        return this.h;
    }

    public String toString() {
        return this.e + " : " + this.f + " : " + this.g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeSerializable(this.h);
    }
}
