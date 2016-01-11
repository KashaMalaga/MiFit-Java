package a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class C0005c extends Binder implements C0004b {
    static final int a = 1;
    private static final String b = "miui.bluetooth.ble.IBleEventCallback";

    public C0005c() {
        attachInterface(this, b);
    }

    public static C0004b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0004b)) ? new C0006d(iBinder) : (C0004b) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(b);
                boolean a = a(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(a ? a : 0);
                return true;
            case 1598968902:
                parcel2.writeString(b);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
