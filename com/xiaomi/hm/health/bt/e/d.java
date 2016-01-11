package com.xiaomi.hm.health.bt.e;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;

class d implements LeScanCallback {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.a.a(bluetoothDevice, i, bArr);
    }
}
