package a.a.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;

class m implements k {
    private IBinder a;

    m(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        return "miui.bluetooth.ble.IBluetoothMiBlePropertyCallback";
    }

    public void a(ParcelUuid parcelUuid, int i, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBlePropertyCallback");
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
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
