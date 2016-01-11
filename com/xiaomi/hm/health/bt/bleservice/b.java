package com.xiaomi.hm.health.bt.bleservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class b implements ServiceConnection {
    b() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder instanceof q) {
            a.b = (r) iBinder;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        a.b = null;
    }
}
