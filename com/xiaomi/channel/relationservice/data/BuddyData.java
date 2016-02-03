package com.xiaomi.channel.relationservice.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import com.xiaomi.market.sdk.p;

public class BuddyData implements Parcelable {
    public static final Creator<BuddyData> CREATOR = new c();
    public static final int a = 1;
    @Deprecated
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = 7;
    public static final int g = 8;
    public static final int h = 9;
    @Deprecated
    public static final int i = 10;
    public static final int j = 12;
    public static final int k = 14;
    public static final int l = 15;
    public static final int m = 16;
    public static final int n = 17;
    public static final int o = 18;
    public static final int p = 19;
    public static final int q = 20;
    public static final int r = 21;
    public static final int s = 114;
    public int A = 0;
    public String B = a.f;
    public String C = a.f;
    public String D = a.f;
    public String E = a.f;
    public String F = a.f;
    public String G = a.f;
    public String H = a.f;
    public String I = a.f;
    public String J = a.f;
    public String K = a.f;
    public int L = 0;
    public String M = a.f;
    public long N = 0;
    public String O = a.f;
    public String P = a.f;
    public int Q = 0;
    public long R = 0;
    public String S = a.f;
    public String T = a.f;
    public String U = a.f;
    public String V = a.f;
    public String W = a.f;
    public String X = a.f;
    public String Y = a.f;
    public String Z = a.f;
    public String aa = a.f;
    public long ab = 0;
    public int ac = 0;
    public long t = 0;
    public String u = a.f;
    public String v = a.f;
    public String w = a.f;
    public String x = a.f;
    public String y = a.f;
    public String z = a.f;

    public BuddyData(Cursor cursor) {
        if (cursor != null) {
            this.t = cursor.getLong(0);
            this.x = cursor.getString(e);
            this.Y = cursor.getString(28);
            this.O = cursor.getString(32);
            this.I = cursor.getString(l);
            this.F = cursor.getString(j);
            this.M = cursor.getString(b);
            this.H = cursor.getString(k);
            this.X = cursor.getString(27);
            this.P = cursor.getString(q);
            this.w = cursor.getString(a);
            this.aa = cursor.getString(30);
            this.y = cursor.getString(f);
            this.z = cursor.getString(33);
            this.Z = cursor.getString(29);
            this.V = cursor.getString(25);
            this.W = cursor.getString(26);
            this.L = cursor.getInt(o);
            this.ab = cursor.getLong(31);
            this.N = cursor.getLong(p);
            this.E = cursor.getString(11);
            this.C = cursor.getString(h);
            this.u = cursor.getString(c);
            this.v = cursor.getString(d);
            this.B = cursor.getString(g);
            this.T = cursor.getString(34);
            this.U = cursor.getString(24);
            this.S = cursor.getString(23);
            this.R = cursor.getLong(22);
            this.G = cursor.getString(13);
            this.D = cursor.getString(i);
            this.J = cursor.getString(m);
            this.A = cursor.getInt(3);
            this.Q = cursor.getInt(r);
            this.K = cursor.getString(n);
            this.ac = cursor.getInt(35);
        }
    }

    public BuddyData(Parcel parcel) {
        this.t = parcel.readLong();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readInt();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readInt();
        this.M = parcel.readString();
        this.N = parcel.readLong();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readInt();
        this.R = parcel.readLong();
        this.S = parcel.readString();
        this.T = parcel.readString();
        this.U = parcel.readString();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.Y = parcel.readString();
        this.Z = parcel.readString();
        this.aa = parcel.readString();
        this.ab = parcel.readLong();
        this.ac = parcel.readInt();
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.e, this.x);
        if (this.t > 0) {
            contentValues.put(p.a, Long.valueOf(this.t));
        }
        contentValues.put(a.F, this.Y);
        contentValues.put(a.v, this.O);
        contentValues.put(a.p, this.I);
        contentValues.put(a.m, this.F);
        contentValues.put(a.t, this.M);
        contentValues.put(a.o, this.H);
        contentValues.put(a.E, this.X);
        contentValues.put(a.w, this.P);
        contentValues.put(a.d, this.w);
        contentValues.put(a.H, this.aa);
        contentValues.put(a.f, this.y);
        contentValues.put(a.g, this.z);
        contentValues.put(a.G, this.Z);
        contentValues.put(a.C, this.V);
        contentValues.put(a.D, this.W);
        contentValues.put(a.s, Integer.valueOf(this.L));
        contentValues.put(a.I, Long.valueOf(this.ab));
        contentValues.put(a.u, Long.valueOf(this.N));
        contentValues.put(a.l, this.E);
        contentValues.put(a.j, this.C);
        contentValues.put(a.b, this.u);
        contentValues.put(a.c, this.v);
        contentValues.put(a.i, this.B);
        contentValues.put(a.A, this.T);
        contentValues.put(a.B, this.U);
        contentValues.put(a.z, this.S);
        contentValues.put(a.y, Long.valueOf(this.R));
        contentValues.put(a.n, this.G);
        contentValues.put(a.k, this.D);
        contentValues.put(o.g, this.J);
        contentValues.put(a.h, Integer.valueOf(this.A));
        contentValues.put(a.x, Integer.valueOf(this.Q));
        contentValues.put(a.r, this.K);
        contentValues.put(a.J, Integer.valueOf(this.ac));
        return contentValues;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BuddyData [id=" + this.t + ", phoneNumber=" + this.u + ", phoneNumberMd5=" + this.v + ", displayName=" + this.w + ", accountName=" + this.x + ", email=" + this.y + ", emailMd5=" + this.z + ", type=" + this.A + ", photoUrl=" + this.B + ", morePhotoUrl=" + this.C + ", sex=" + this.D + ", location=" + this.E + ", birthday=" + this.F + ", school=" + this.G + ", company=" + this.H + ", bio=" + this.I + ", signature=" + this.J + ", voiceSignature=" + this.K + ", isVoiceSignatureRead=" + this.L + ", comments=" + this.M + ", lastUpdate=" + this.N + ", bindValues=" + this.O + ", detailFriendRelation=" + this.P + ", verifyType=" + this.Q + ", relationTs=" + this.R + ", relationSource=" + this.S + ", reasonMsg=" + this.T + ", recommendReason=" + this.U + ", homeTown=" + this.V + ", industry=" + this.W + ", correlation=" + this.X + ", accountProperty=" + this.Y + ", extra=" + this.Z + ", domainInfo=" + this.aa + ", lastSendMessageTs=" + this.ab + ", flags=" + this.ac + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.t);
        parcel.writeString(this.u == null ? a.f : this.u);
        parcel.writeString(this.v == null ? a.f : this.v);
        parcel.writeString(this.w == null ? a.f : this.w);
        parcel.writeString(this.x == null ? a.f : this.x);
        parcel.writeString(this.y == null ? a.f : this.y);
        parcel.writeString(this.z == null ? a.f : this.z);
        parcel.writeInt(this.A);
        parcel.writeString(this.B == null ? a.f : this.B);
        parcel.writeString(this.C == null ? a.f : this.C);
        parcel.writeString(this.D == null ? a.f : this.D);
        parcel.writeString(this.E == null ? a.f : this.E);
        parcel.writeString(this.F == null ? a.f : this.F);
        parcel.writeString(this.G == null ? a.f : this.G);
        parcel.writeString(this.H == null ? a.f : this.H);
        parcel.writeString(this.I == null ? a.f : this.I);
        parcel.writeString(this.J == null ? a.f : this.J);
        parcel.writeString(this.K == null ? a.f : this.K);
        parcel.writeInt(this.L);
        parcel.writeString(this.M == null ? a.f : this.M);
        parcel.writeLong(this.N);
        parcel.writeString(this.O == null ? a.f : this.O);
        parcel.writeString(this.P == null ? a.f : this.P);
        parcel.writeInt(this.Q);
        parcel.writeLong(this.R);
        parcel.writeString(this.S == null ? a.f : this.S);
        parcel.writeString(this.T == null ? a.f : this.T);
        parcel.writeString(this.U == null ? a.f : this.U);
        parcel.writeString(this.V == null ? a.f : this.V);
        parcel.writeString(this.W == null ? a.f : this.W);
        parcel.writeString(this.X == null ? a.f : this.X);
        parcel.writeString(this.Y == null ? a.f : this.Y);
        parcel.writeString(this.Z == null ? a.f : this.Z);
        parcel.writeString(this.aa == null ? a.f : this.aa);
        parcel.writeLong(this.ab);
        parcel.writeInt(this.ac);
    }
}
