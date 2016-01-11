package com.xiaomi.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder implements a {
    static final int a = 1;
    static final int b = 2;
    private static final String c = "com.xiaomi.account.IXiaomiAuthResponse";

    public b() {
        attachInterface(this, c);
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(c);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(c);
                a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case b /*2*/:
                parcel.enforceInterface(c);
                a();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString(c);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
