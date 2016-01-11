package com.xiaomi.hm.health.bt.profile.a;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;

class c extends Handler {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.X /*5*/:
                this.a.a(message.arg1);
                return;
            case a.bt /*6*/:
                this.a.a((BluetoothDevice) message.obj, message.arg1);
                return;
            case a.bc /*7*/:
                this.a.a((BluetoothDevice) message.obj, message.arg1, message.arg2);
                return;
            default:
                return;
        }
    }
}
