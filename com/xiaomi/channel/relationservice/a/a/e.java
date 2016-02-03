package com.xiaomi.channel.relationservice.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.xiaomi.channel.relationservice.data.BuddyData;
import java.util.List;

public abstract class e extends Binder implements d {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    static final int g = 7;
    static final int h = 8;
    static final int i = 9;
    static final int j = 10;
    static final int k = 11;
    static final int l = 12;
    static final int m = 13;
    static final int n = 14;
    static final int o = 15;
    static final int p = 16;
    private static final String q = "com.xiaomi.channel.relationservice.api.aidl.IBuddyService";

    public e() {
        attachInterface(this, q);
    }

    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(q);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new f(iBinder) : (d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        int i3 = 0;
        boolean a;
        BuddyData buddyData;
        int b;
        String a2;
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(q);
                List a3 = a(parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(a3);
                return true;
            case b /*2*/:
                parcel.enforceInterface(q);
                a = a(parcel.createTypedArrayList(BuddyData.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(a ? a : 0);
                return true;
            case c /*3*/:
                parcel.enforceInterface(q);
                if (parcel.readInt() != 0) {
                    buddyData = (BuddyData) BuddyData.CREATOR.createFromParcel(parcel);
                }
                a = a(buddyData);
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case d /*4*/:
                parcel.enforceInterface(q);
                b = b(parcel.createStringArrayList());
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            case e /*5*/:
                parcel.enforceInterface(q);
                b = a(parcel.readString(), parcel.createStringArray(), parcel.createTypedArrayList(Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            case f /*6*/:
                parcel.enforceInterface(q);
                a = a();
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case g /*7*/:
                parcel.enforceInterface(q);
                a(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case h /*8*/:
                parcel.enforceInterface(q);
                b(b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case i /*9*/:
                parcel.enforceInterface(q);
                a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            case j /*10*/:
                parcel.enforceInterface(q);
                a = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case k /*11*/:
                parcel.enforceInterface(q);
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                a = a(bundle);
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case l /*12*/:
                parcel.enforceInterface(q);
                a = c(parcel.createStringArrayList());
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case m /*13*/:
                parcel.enforceInterface(q);
                b = b();
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            case n /*14*/:
                parcel.enforceInterface(q);
                a = c();
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case o /*15*/:
                parcel.enforceInterface(q);
                a2 = d();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            case p /*16*/:
                parcel.enforceInterface(q);
                buddyData = b(parcel.readString());
                parcel2.writeNoException();
                if (buddyData != null) {
                    parcel2.writeInt(a);
                    buddyData.writeToParcel(parcel2, a);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString(q);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
