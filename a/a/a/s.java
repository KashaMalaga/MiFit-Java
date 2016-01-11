package a.a.a;

import android.bluetooth.BluetoothDevice;
import android.os.IBinder;
import android.os.Parcel;

class s implements q {
    private IBinder a;

    s(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        return "miui.bluetooth.ble.IScanDeviceCallback";
    }

    public void a(int i, BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IScanDeviceCallback");
            obtain.writeInt(i);
            if (bluetoothDevice != null) {
                obtain.writeInt(1);
                bluetoothDevice.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i2);
            obtain.writeByteArray(bArr);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
