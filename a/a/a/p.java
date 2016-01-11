package a.a.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelUuid;
import java.util.List;
import java.util.Map;

class p implements n {
    private IBinder a;

    p(IBinder iBinder) {
        this.a = iBinder;
    }

    public int a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            this.a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String a(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Map a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            Map readHashMap = obtain2.readHashMap(getClass().getClassLoader());
            return readHashMap;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(ParcelUuid parcelUuid) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean a(IBinder iBinder, ParcelUuid parcelUuid, int i, q qVar) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeStrongBinder(iBinder);
            if (parcelUuid != null) {
                obtain.writeInt(1);
                parcelUuid.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
            this.a.transact(8, obtain, obtain2, 0);
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

    public boolean a(String str, int i) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeInt(i);
            this.a.transact(14, obtain, obtain2, 0);
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

    public boolean a(String str, int i, C0004b c0004b) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeStrongBinder(c0004b != null ? c0004b.asBinder() : null);
            this.a.transact(10, obtain, obtain2, 0);
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

    public boolean a(String str, String str2, int i) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
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

    public boolean a(String str, String str2, String str3) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
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

    public int b(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public List<String> b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            this.a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            List<String> createStringArrayList = obtain2.createStringArrayList();
            return createStringArrayList;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean b(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            this.a.transact(6, obtain, obtain2, 0);
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

    public boolean b(String str, int i) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeInt(i);
            this.a.transact(15, obtain, obtain2, 0);
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

    public boolean b(String str, int i, C0004b c0004b) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeStrongBinder(c0004b != null ? c0004b.asBinder() : null);
            this.a.transact(11, obtain, obtain2, 0);
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

    public int c(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
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
        return "miui.bluetooth.ble.IMiBleDeviceManager";
    }

    public String c(String str, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("miui.bluetooth.ble.IMiBleDeviceManager");
            obtain.writeString(str);
            obtain.writeInt(i);
            this.a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
