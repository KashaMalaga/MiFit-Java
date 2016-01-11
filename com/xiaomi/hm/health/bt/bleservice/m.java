package com.xiaomi.hm.health.bt.bleservice;

import android.bluetooth.BluetoothDevice;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.A;

class m implements A {
    final /* synthetic */ BLEService a;

    m(BLEService bLEService) {
        this.a = bLEService;
    }

    public void a(BluetoothDevice bluetoothDevice) {
        C0596r.d("BLEService", "onDeviceConnected................");
    }

    public void b(BluetoothDevice bluetoothDevice) {
        C0596r.d("BLEService", "onDeviceConnectionFailed................");
        this.a.b(4);
    }

    public void c(BluetoothDevice bluetoothDevice) {
        C0596r.d("BLEService", "onDeviceDisconnected................");
        this.a.b(5);
    }

    public void d(BluetoothDevice bluetoothDevice) {
        C0596r.d("BLEService", "onInitializationFailed................");
        this.a.b(4);
    }

    public void e(BluetoothDevice bluetoothDevice) {
        C0596r.d("BLEService", "onInitializationSuccess................");
        this.a.E.sendEmptyMessage(21);
    }
}
