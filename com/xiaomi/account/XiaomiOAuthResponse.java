package com.xiaomi.account;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.xiaomi.account.openauth.h;

public class XiaomiOAuthResponse implements Parcelable {
    public static final Creator<XiaomiOAuthResponse> CREATOR = new g();
    private static final String a = XiaomiOAuthResponse.class.getName();
    private a b;

    public XiaomiOAuthResponse(Parcel parcel) {
        this.b = b.a(parcel.readStrongBinder());
    }

    public XiaomiOAuthResponse(a aVar) {
        this.b = aVar;
    }

    public static void a(a aVar) {
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable e) {
                Log.e(a, "RuntimeException", e);
            } catch (Throwable e2) {
                Log.e(a, "RemoteException", e2);
            }
        }
    }

    public static void a(a aVar, Bundle bundle) {
        if (aVar != null && bundle != null) {
            try {
                aVar.a(bundle);
            } catch (Throwable e) {
                Log.e(a, "RemoteException", e);
                Bundle bundle2 = new Bundle();
                bundle2.putInt(h.ag, -1);
                bundle2.putString(h.ah, e.getMessage());
                try {
                    aVar.a(bundle2);
                } catch (Throwable e2) {
                    Log.e(a, "RuntimeException", e2);
                } catch (Throwable e22) {
                    Log.e(a, "RemoteException", e22);
                }
            } catch (Throwable e222) {
                Log.e(a, "RemoteException", e222);
            }
        }
    }

    public void a() {
        a(this.b);
    }

    public void a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(h.ag, i);
        bundle.putString(h.ah, str);
        a(this.b, bundle);
    }

    public void a(Bundle bundle) {
        a(this.b, bundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.b.asBinder());
    }
}
