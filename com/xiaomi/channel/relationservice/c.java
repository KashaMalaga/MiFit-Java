package com.xiaomi.channel.relationservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.channel.relationservice.a.a.e;

class c implements ServiceConnection {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.f) {
            this.a.e = e.a(iBinder);
            Log.d("RelationServiceClient", "RelationServiceClient::onServiceConnected");
            this.a.f.notifyAll();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.f) {
            this.a.e = null;
            this.a.f.notifyAll();
        }
    }
}
