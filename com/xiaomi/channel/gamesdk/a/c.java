package com.xiaomi.channel.gamesdk.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.xiaomi.channel.gamesdk.Retobj;

class c implements a {
    private IBinder a;

    c(IBinder iBinder) {
        this.a = iBinder;
    }

    public Bundle a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return bundle;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj a(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj a(String str, String str2, String str3, String str4) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public Bundle b(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return bundle;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            this.a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj c(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            this.a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj c(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String c() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            this.a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj d(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            this.a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public Retobj d(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.gamesdk.aidl.IGameService");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            Retobj retobj = obtain2.readInt() != 0 ? (Retobj) Retobj.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return retobj;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String d() {
        return "com.xiaomi.channel.gamesdk.aidl.IGameService";
    }
}
