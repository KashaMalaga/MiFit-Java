package com.xiaomi.channel.relationservice.a.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.xiaomi.channel.relationservice.data.BuddyData;
import java.util.List;

class f implements d {
    private IBinder a;

    f(IBinder iBinder) {
        this.a = iBinder;
    }

    public int a(String str, String[] strArr, List<Bundle> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeString(str);
            obtain.writeStringArray(strArr);
            obtain.writeTypedList(list);
            this.a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeString(str);
            this.a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public List<BuddyData> a(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeString(str);
            obtain.writeStringArray(strArr);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            obtain.writeString(str5);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            List<BuddyData> createTypedArrayList = obtain2.createTypedArrayList(BuddyData.CREATOR);
            return createTypedArrayList;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void a(a aVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean a() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
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

    public boolean a(Bundle bundle) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
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

    public boolean a(BuddyData buddyData) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            if (buddyData != null) {
                obtain.writeInt(1);
                buddyData.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(3, obtain, obtain2, 0);
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

    public boolean a(String str, String str2) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeString(str);
            obtain.writeString(str2);
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

    public boolean a(List<BuddyData> list) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeTypedList(list);
            this.a.transact(2, obtain, obtain2, 0);
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

    public IBinder asBinder() {
        return this.a;
    }

    public int b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            this.a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int b(List<String> list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeStringList(list);
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public BuddyData b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeString(str);
            this.a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
            BuddyData buddyData = obtain2.readInt() != 0 ? (BuddyData) BuddyData.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return buddyData;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void b(a aVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            this.a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean c() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
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

    public boolean c(List<String> list) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            obtain.writeStringList(list);
            this.a.transact(12, obtain, obtain2, 0);
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

    public String d() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.xiaomi.channel.relationservice.api.aidl.IBuddyService");
            this.a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String e() {
        return "com.xiaomi.channel.relationservice.api.aidl.IBuddyService";
    }
}
