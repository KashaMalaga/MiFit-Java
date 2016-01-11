package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import cn.com.smartdevices.bracelet.C0596r;

class l implements Runnable {
    final /* synthetic */ BluetoothGatt a;
    final /* synthetic */ BluetoothGattCharacteristic b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ C1118a d;

    l(C1118a c1118a, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.d = c1118a;
        this.a = bluetoothGatt;
        this.b = bluetoothGattCharacteristic;
        this.c = bArr;
    }

    public void run() {
        C0596r.e();
        C0596r.a(this.d.f);
        C0596r.a(this.a);
        if (this.a == null) {
            this.d.l.lock();
            try {
                this.d.o = z.h;
                C0596r.b("NOTIFY: synchronizedWriteCharacteristic(): " + this.d.o);
                this.d.n = false;
                this.d.m.signal();
            } finally {
                this.d.l.unlock();
            }
        } else {
            this.b.setValue(this.c);
            boolean writeCharacteristic = this.a.writeCharacteristic(this.b);
            C0596r.a(writeCharacteristic);
            if (!writeCharacteristic) {
                this.d.l.lock();
                try {
                    this.d.o = z.i;
                    C0596r.b("NOTIFY: synchronizedWriteCharacteristic(): " + this.d.o);
                    this.d.n = false;
                    this.d.m.signal();
                } finally {
                    this.d.l.unlock();
                }
            }
        }
    }
}
