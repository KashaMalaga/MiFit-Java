package a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class u implements ServiceConnection {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.a(o.a(iBinder));
        if (this.a.D != null) {
            this.a.D.a(this.a);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.a(null);
        if (this.a.D != null) {
            this.a.D.b();
        }
    }
}
