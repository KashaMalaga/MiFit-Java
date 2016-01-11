package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGattCharacteristic;

class f implements Runnable {
    final /* synthetic */ BluetoothGattCharacteristic a;
    final /* synthetic */ C1118a b;

    f(C1118a c1118a, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.b = c1118a;
        this.a = bluetoothGattCharacteristic;
    }

    public void run() {
        this.b.d(this.a);
    }
}
