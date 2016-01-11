package a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

class C implements ServiceConnection {
    final /* synthetic */ B a;

    C(B b) {
        this.a = b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("MiBleProfile", "onServiceConnected()");
        this.a.C = C0008f.a(iBinder);
        this.a.L.sendMessage(this.a.L.obtainMessage(1, 2, 0));
        try {
            this.a.C.a(this.a.I, this.a.B, this.a.F, this.a.O);
        } catch (RemoteException e) {
            e.printStackTrace();
            this.a.L.sendMessage(this.a.L.obtainMessage(1, -1, 0));
        }
        if (this.a.J) {
            this.a.J = false;
            this.a.d();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.C = null;
        this.a.M = 0;
        this.a.L.sendMessage(this.a.L.obtainMessage(1, 0, 0));
    }
}
