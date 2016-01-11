package a.a.a;

import android.bluetooth.BluetoothDevice;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;
import java.util.List;

class C0009g implements C0007e {
    private IBinder a;

    C0009g(IBinder iBinder) {
        this.a = iBinder;
    }

    public List<BluetoothDevice> a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            List<BluetoothDevice> createTypedArrayList = obtain2.createTypedArrayList(BluetoothDevice.CREATOR);
            return createTypedArrayList;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(IBinder iBinder, String str, ParcelUuid parcelUuid) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeStrongBinder(iBinder);
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(IBinder iBinder, String str, ParcelUuid parcelUuid, h hVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeStrongBinder(iBinder);
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(String str, ParcelUuid parcelUuid) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
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

    public boolean a(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean a(String str, int i) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            obtain.writeInt(i);
            this.a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean a(String str, ParcelUuid parcelUuid, int i, k kVar) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
            this.a.transact(9, obtain, obtain2, 0);
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

    public boolean a(String str, ParcelUuid parcelUuid, int i, byte[] bArr) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeByteArray(bArr);
            this.a.transact(11, obtain, obtain2, 0);
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

    public boolean a(String str, ParcelUuid parcelUuid, String str2) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str2);
            this.a.transact(13, obtain, obtain2, 0);
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

    public boolean a(String str, ParcelUuid parcelUuid, byte[] bArr) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeByteArray(bArr);
            this.a.transact(16, obtain, obtain2, 0);
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

    public byte[] a(String str, ParcelUuid parcelUuid, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            this.a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public int b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            this.a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void b(String str, ParcelUuid parcelUuid) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean b(String str, ParcelUuid parcelUuid, int i) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            this.a.transact(14, obtain, obtain2, 0);
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

    public boolean b(String str, ParcelUuid parcelUuid, int i, k kVar) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
            this.a.transact(10, obtain, obtain2, 0);
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

    public byte[] b(String str, ParcelUuid parcelUuid, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeByteArray(bArr);
            this.a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int c(String str, ParcelUuid parcelUuid) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String c() {
        return "miui.bluetooth.ble.IBluetoothMiBle";
    }

    public boolean d(String str, ParcelUuid parcelUuid) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IBluetoothMiBle");
            obtain.writeString(str);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(15, obtain, obtain2, 0);
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
}
