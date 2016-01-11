package com.xiaomi.hm.health.bt.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.hm.health.bt.b.b;
import com.xiaomi.hm.health.bt.b.c;

public class HwConnStatus implements Parcelable {
    public static final Creator<HwConnStatus> CREATOR = new l();
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;
    public static final int j = 8;
    private int k = a;
    private c l = c.MILI;

    public HwConnStatus(int i) {
        this.k = i;
    }

    public HwConnStatus(int i, c cVar) {
        this.k = i;
        this.l = cVar;
    }

    public int a() {
        return this.k;
    }

    public c b() {
        return this.l;
    }

    public b c() {
        return this.l.a();
    }

    public boolean d() {
        return this.k == a;
    }

    public int describeContents() {
        return b;
    }

    public boolean e() {
        return this.k == 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HwConnStatus)) {
            return false;
        }
        HwConnStatus hwConnStatus = (HwConnStatus) obj;
        return this.k == hwConnStatus.a() && this.l.equals(hwConnStatus.b());
    }

    public boolean f() {
        return this.k == c;
    }

    public boolean g() {
        return this.k == d;
    }

    public boolean h() {
        return this.k == f;
    }

    public boolean i() {
        return this.k == g;
    }

    public boolean j() {
        return this.k == i;
    }

    public boolean k() {
        return this.k == h;
    }

    public String toString() {
        return "status : " + this.k;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.k);
        parcel.writeSerializable(this.l);
    }
}
