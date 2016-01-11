package com.xiaomi.channel.gamesdk.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.xiaomi.channel.gamesdk.Retobj;

public abstract class b extends Binder implements a {
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
    private static final String n = "com.xiaomi.channel.gamesdk.aidl.IGameService";

    public b() {
        attachInterface(this, n);
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(n);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Retobj a;
        Bundle a2;
        String a3;
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(n);
                a = a(parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case b /*2*/:
                parcel.enforceInterface(n);
                a = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case c /*3*/:
                parcel.enforceInterface(n);
                a2 = a();
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(a);
                    a2.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case d /*4*/:
                parcel.enforceInterface(n);
                a2 = b(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(a);
                    a2.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case e /*5*/:
                parcel.enforceInterface(n);
                a = a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case f /*6*/:
                parcel.enforceInterface(n);
                a = b();
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case g /*7*/:
                parcel.enforceInterface(n);
                a = b(parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case h /*8*/:
                parcel.enforceInterface(n);
                a = c(parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case i /*9*/:
                parcel.enforceInterface(n);
                a = c(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case j /*10*/:
                parcel.enforceInterface(n);
                a = d(parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case k /*11*/:
                parcel.enforceInterface(n);
                a3 = a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            case l /*12*/:
                parcel.enforceInterface(n);
                a = d(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case m /*13*/:
                parcel.enforceInterface(n);
                a3 = c();
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            case 1598968902:
                parcel2.writeString(n);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
