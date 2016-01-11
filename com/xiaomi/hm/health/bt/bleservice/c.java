package com.xiaomi.hm.health.bt.bleservice;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.hm.health.bt.profile.a.b;

class c extends b {
    final /* synthetic */ BLEService a;

    c(BLEService bLEService) {
        this.a = bLEService;
    }

    public void a(int i) {
    }

    public void a(BluetoothDevice bluetoothDevice, int i) {
        this.a.c(i);
    }

    public void a(BluetoothDevice bluetoothDevice, int i, int i2) {
        this.a.a(i, i2);
    }
}
