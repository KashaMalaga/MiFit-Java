package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGattCharacteristic;

class C1121d implements Runnable {
    final /* synthetic */ BluetoothGattCharacteristic a;
    final /* synthetic */ C1118a b;

    C1121d(C1118a c1118a, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.b = c1118a;
        this.a = bluetoothGattCharacteristic;
    }

    public void run() {
        this.b.f(this.a);
    }
}
