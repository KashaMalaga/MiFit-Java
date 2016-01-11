package cn.com.smartdevices.bracelet.gps.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.sync.C0467k;
import java.util.Iterator;

final class C0505aq implements ServiceConnection {
    final /* synthetic */ C0500ak a;

    private C0505aq(C0500ak c0500ak) {
        this.a = c0500ak;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            iBinder.linkToDeath(this.a.h, 0);
        } catch (RemoteException e) {
            C0596r.a("Run", e.getMessage());
        }
        if (iBinder instanceof C0467k) {
            this.a.i = (C0467k) iBinder;
            this.a.c = new C0502am(this.a);
            this.a.i.a(this.a.c);
            if (this.a.k != null) {
                Iterator it = this.a.k.iterator();
                while (it.hasNext()) {
                    C0504ap c0504ap = (C0504ap) it.next();
                    if (c0504ap.d == 0) {
                        this.a.a(c0504ap.f, c0504ap.e);
                    } else if (c0504ap.d == 1) {
                        this.a.a(c0504ap.e);
                    } else if (c0504ap.d == 2) {
                        this.a.b();
                    }
                }
                this.a.k.clear();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.i = null;
        this.a.d = null;
        C0596r.e("UI", "SyncConnection onServiceDisconnected");
    }
}
