package com.xiaomi.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class e extends Binder implements d {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    private static final String g = "com.xiaomi.account.IXiaomiAuthService";

    public e() {
        attachInterface(this, g);
    }

    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(g);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new f(iBinder) : (d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle a;
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(g);
                a = a(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case b /*2*/:
                parcel.enforceInterface(g);
                a = b(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case c /*3*/:
                parcel.enforceInterface(g);
                a = c(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case d /*4*/:
                parcel.enforceInterface(g);
                d(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case e /*5*/:
                parcel.enforceInterface(g);
                boolean a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? a : 0);
                return true;
            case f /*6*/:
                parcel.enforceInterface(g);
                a(b.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString(g);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
