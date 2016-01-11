package a.b;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class c implements a {
    private IBinder a;

    c(IBinder iBinder) {
        this.a = iBinder;
    }

    public Bundle a(Account account, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.net.IXiaomiAuthService");
            if (account != null) {
                obtain.writeInt(1);
                account.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return bundle2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String a() {
        return "miui.net.IXiaomiAuthService";
    }

    public IBinder asBinder() {
        return this.a;
    }

    public Bundle b(Account account, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.net.IXiaomiAuthService");
            if (account != null) {
                obtain.writeInt(1);
                account.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return bundle2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Bundle c(Account account, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.net.IXiaomiAuthService");
            if (account != null) {
                obtain.writeInt(1);
                account.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return bundle2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void d(Account account, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.net.IXiaomiAuthService");
            if (account != null) {
                obtain.writeInt(1);
                account.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
