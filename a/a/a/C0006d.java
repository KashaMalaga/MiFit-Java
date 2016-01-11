package a.a.a;

import android.os.IBinder;
import android.os.Parcel;

class C0006d implements C0004b {
    private IBinder a;

    C0006d(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        return "miui.bluetooth.ble.IBleEventCallback";
    }

    public boolean a(String str, int i, byte[] bArr) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBleEventCallback");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeByteArray(bArr);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
