package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGattDescriptor;

class h implements Runnable {
    final /* synthetic */ BluetoothGattDescriptor a;
    final /* synthetic */ C1118a b;

    h(C1118a c1118a, BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.b = c1118a;
        this.a = bluetoothGattDescriptor;
    }

    public void run() {
        this.b.b(this.a);
    }
}
