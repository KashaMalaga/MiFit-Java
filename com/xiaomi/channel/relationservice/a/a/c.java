package com.xiaomi.channel.relationservice.a.a;

import android.os.IBinder;
import android.os.Parcel;
import com.xiaomi.channel.relationservice.data.BuddyData;
import java.util.List;

class c implements a {
    private IBinder a;

    c(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        return "com.xiaomi.channel.relationservice.api.aidl.IBuddyChangeListener";
    }

    public void a(List<BuddyData> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyChangeListener");
            obtain.writeTypedList(list);
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

    public void b(List<BuddyData> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyChangeListener");
            obtain.writeTypedList(list);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void c(List<String> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyChangeListener");
            obtain.writeStringList(list);
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void d(List<BuddyData> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyChangeListener");
            obtain.writeTypedList(list);
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
