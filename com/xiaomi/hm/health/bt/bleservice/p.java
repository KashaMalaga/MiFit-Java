package com.xiaomi.hm.health.bt.bleservice;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.hm.health.bt.c.A;

class p implements A {
    final /* synthetic */ BLEService a;

    p(BLEService bLEService) {
        this.a = bLEService;
    }

    public void a(BluetoothDevice bluetoothDevice) {
        this.a.a(2, bluetoothDevice);
    }

    public void b(BluetoothDevice bluetoothDevice) {
        this.a.E.sendEmptyMessage(20);
        this.a.a(1, bluetoothDevice);
    }

    public void c(BluetoothDevice bluetoothDevice) {
        this.a.E.sendEmptyMessage(20);
        this.a.a(0, bluetoothDevice);
    }

    public void d(BluetoothDevice bluetoothDevice) {
        this.a.E.sendEmptyMessage(20);
        this.a.a(4, bluetoothDevice);
    }

    public void e(BluetoothDevice bluetoothDevice) {
        this.a.a(3, bluetoothDevice);
    }
}
