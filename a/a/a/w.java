package a.a.a;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;

class w extends r {
    final /* synthetic */ int b;
    final /* synthetic */ LeScanCallback c;
    final /* synthetic */ t d;

    w(t tVar, int i, LeScanCallback leScanCallback) {
        this.d = tVar;
        this.b = i;
        this.c = leScanCallback;
    }

    public void a(int i, BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        if (i == this.b) {
            this.c.onLeScan(bluetoothDevice, i2, bArr);
        }
    }
}
