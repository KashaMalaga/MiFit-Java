package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class C0032at extends Binder implements C0031as {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    private static final String d = "android.support.v4.app.INotificationSideChannel";

    public C0032at() {
        attachInterface(this, d);
    }

    public static C0031as a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(d);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0031as)) ? new C0033au(iBinder) : (C0031as) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(d);
                a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            case b /*2*/:
                parcel.enforceInterface(d);
                a(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            case c /*3*/:
                parcel.enforceInterface(d);
                a(parcel.readString());
                return true;
            case 1598968902:
                parcel2.writeString(d);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
