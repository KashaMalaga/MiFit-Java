package cn.com.smartdevices.bracelet.gps.f;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.services.a.d;

public class C0440c implements ServiceConnection {
    protected f a = f.BINDING_SERVICE;
    final /* synthetic */ C0438a b;

    protected C0440c(C0438a c0438a) {
        this.b = c0438a;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            iBinder.linkToDeath(this.b.a, 0);
        } catch (RemoteException e) {
            C0596r.a("Run", e.getMessage());
        }
        if (iBinder instanceof d) {
            this.b.f = (d) iBinder;
            this.a = f.SERVICE_READY;
            if (this.b.d != null) {
                this.b.f.a(this.b.d);
            }
            this.b.f.a(this.b);
            this.b.f.b(this.b);
            if (this.b.e != null) {
                this.b.e.a(this.a);
            }
            if (this.b.c.contains(Integer.valueOf(1))) {
                this.b.c.remove(Integer.valueOf(1));
                this.b.b = this.b.f.a(this.b, 4);
            } else {
                this.b.b = this.b.f.f();
            }
            this.b.f();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a = f.SERVICE_UNBINDED;
        this.b.f = null;
        if (this.b.e != null) {
            this.b.e.a(this.a);
        }
    }
}
