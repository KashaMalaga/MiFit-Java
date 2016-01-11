package a.a.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;

class C0010j implements h {
    private IBinder a;

    C0010j(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        return "miui.bluetooth.ble.IBluetoothMiBleCallback";
    }

    public void a(ParcelUuid parcelUuid, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBleCallback");
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
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
