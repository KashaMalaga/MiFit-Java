package a.a.a;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class r extends Binder implements q {
    static final int a = 1;
    private static final String b = "miui.bluetooth.ble.IScanDeviceCallback";

    public r() {
        attachInterface(this, b);
    }

    public static q a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof q)) ? new s(iBinder) : (q) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(b);
                a(parcel.readInt(), parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.createByteArray());
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
