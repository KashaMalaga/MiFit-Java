package com.xiaomi.channel.gamesdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.channel.gamesdk.a.b;

class c implements ServiceConnection {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.z) {
            this.a.y = b.a(iBinder);
            this.a.z.notifyAll();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.z) {
            this.a.y = null;
            this.a.z.notifyAll();
        }
    }
}
