package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;

class C0033au implements C0031as {
    private IBinder a;

    C0033au(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        return "android.support.v4.app.INotificationSideChannel";
    }

    public void a(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(str);
            this.a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void a(String str, int i, String str2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            this.a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public void a(String str, int i, String str2, Notification notification) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeString(str2);
            if (notification != null) {
                obtain.writeInt(1);
                notification.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}
