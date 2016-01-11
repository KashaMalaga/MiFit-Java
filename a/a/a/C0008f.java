package a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelUuid;
import java.util.List;

public abstract class C0008f extends Binder implements C0007e {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    static final int g = 7;
    static final int h = 8;
    static final int i = 9;
    static final int j = 10;
    static final int k = 11;
    static final int l = 12;
    static final int m = 13;
    static final int n = 14;
    static final int o = 15;
    static final int p = 16;
    static final int q = 17;
    static final int r = 18;
    private static final String s = "miui.bluetooth.ble.IBluetoothMiBle";

    public C0008f() {
        attachInterface(this, s);
    }

    public static C0007e a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(s);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0007e)) ? new C0009g(iBinder) : (C0007e) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        ParcelUuid parcelUuid = null;
        IBinder readStrongBinder;
        String readString;
        boolean a;
        String readString2;
        int c;
        byte[] a2;
        switch (i) {
            case a /*1*/:
                parcel.enforceInterface(s);
                readStrongBinder = parcel.readStrongBinder();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a(readStrongBinder, readString, parcelUuid, i.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case b /*2*/:
                parcel.enforceInterface(s);
                readStrongBinder = parcel.readStrongBinder();
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a(readStrongBinder, readString, parcelUuid);
                parcel2.writeNoException();
                return true;
            case c /*3*/:
                parcel.enforceInterface(s);
                a = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a ? a : 0);
                return true;
            case d /*4*/:
                parcel.enforceInterface(s);
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a(readString2, parcelUuid);
                parcel2.writeNoException();
                return true;
            case e /*5*/:
                parcel.enforceInterface(s);
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                b(readString2, parcelUuid);
                parcel2.writeNoException();
                return true;
            case f /*6*/:
                parcel.enforceInterface(s);
                List a3 = a();
                parcel2.writeNoException();
                parcel2.writeTypedList(a3);
                return true;
            case g /*7*/:
                parcel.enforceInterface(s);
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                c = c(readString2, parcelUuid);
                parcel2.writeNoException();
                parcel2.writeInt(c);
                return true;
            case h /*8*/:
                parcel.enforceInterface(s);
                a = a(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case i /*9*/:
                parcel.enforceInterface(s);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a = a(readString, parcelUuid, parcel.readInt(), l.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case j /*10*/:
                parcel.enforceInterface(s);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a = b(readString, parcelUuid, parcel.readInt(), l.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case k /*11*/:
                parcel.enforceInterface(s);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a = a(readString, parcelUuid, parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case l /*12*/:
                parcel.enforceInterface(s);
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a2 = a(readString2, parcelUuid, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeByteArray(a2);
                return true;
            case m /*13*/:
                parcel.enforceInterface(s);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a = a(readString, parcelUuid, parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case n /*14*/:
                parcel.enforceInterface(s);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a = b(readString, parcelUuid, parcel.readInt());
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case o /*15*/:
                parcel.enforceInterface(s);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a = d(readString, parcelUuid);
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case p /*16*/:
                parcel.enforceInterface(s);
                readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a = a(readString, parcelUuid, parcel.createByteArray());
                parcel2.writeNoException();
                if (a) {
                    i3 = a;
                }
                parcel2.writeInt(i3);
                return true;
            case q /*17*/:
                parcel.enforceInterface(s);
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelUuid = (ParcelUuid) ParcelUuid.CREATOR.createFromParcel(parcel);
                }
                a2 = b(readString2, parcelUuid, parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeByteArray(a2);
                return true;
            case r /*18*/:
                parcel.enforceInterface(s);
                c = b();
                parcel2.writeNoException();
                parcel2.writeInt(c);
                return true;
            case 1598968902:
                parcel2.writeString(s);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
