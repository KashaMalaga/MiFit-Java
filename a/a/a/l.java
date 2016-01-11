package a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;

public abstract class l extends Binder implements k {
    static final int a = 1;
    private static final String b = "miui.bluetooth.ble.IBluetoothMiBlePropertyCallback";

    public l() {
        attachInterface(this, b);
    }

    public static k a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new m(iBinder) : (k) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(b);
                a(parcel.readInt() != 0 ? (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString(b);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
