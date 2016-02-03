package com.xiaomi.channel.relationservice.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.xiaomi.channel.relationservice.data.BuddyData;

public abstract class b extends Binder implements a {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    private static final String e = "com.xiaomi.channel.relationservice.api.aidl.IBuddyChangeListener";

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
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(e);
                a(parcel.createTypedArrayList(BuddyData.CREATOR));
                parcel2.writeNoException();
                return true;
            case b /*2*/:
                parcel.enforceInterface(e);
                b(parcel.createTypedArrayList(BuddyData.CREATOR));
                parcel2.writeNoException();
                return true;
            case c /*3*/:
                parcel.enforceInterface(e);
                c(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case d /*4*/:
                parcel.enforceInterface(e);
                d(parcel.createTypedArrayList(BuddyData.CREATOR));
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
