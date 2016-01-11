package a.b;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder implements a {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    private static final String e = "miui.net.IXiaomiAuthService";

    public b() {
        attachInterface(this, e);
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(e);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle a;
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(e);
                a = a(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case b /*2*/:
                parcel.enforceInterface(e);
                a = b(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case c /*3*/:
                parcel.enforceInterface(e);
                a = c(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(a);
                    a.writeToParcel(parcel2, a);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case d /*4*/:
                parcel.enforceInterface(e);
                d(parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString(e);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
