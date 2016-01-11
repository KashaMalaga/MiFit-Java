package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import cn.com.smartdevices.bracelet.C0596r;

class k implements Runnable {
    final /* synthetic */ BluetoothGatt a;
    final /* synthetic */ BluetoothGattCharacteristic b;
    final /* synthetic */ C1118a c;

    k(C1118a c1118a, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.c = c1118a;
        this.a = bluetoothGatt;
        this.b = bluetoothGattCharacteristic;
    }

    public void run() {
        C0596r.e();
        C0596r.a(this.c.f);
        C0596r.a(this.a);
        if (this.a == null) {
            this.c.l.lock();
            try {
                this.c.o = z.h;
                C0596r.b("NOTIFY: synchronizedReadCharacteristic(): " + this.c.o);
                this.c.n = false;
                this.c.m.signal();
            } finally {
                this.c.l.unlock();
            }
        } else {
            boolean readCharacteristic = this.a.readCharacteristic(this.b);
            C0596r.a(readCharacteristic);
            if (!readCharacteristic) {
                this.c.l.lock();
                try {
                    this.c.o = z.i;
                    C0596r.b("NOTIFY: synchronizedReadCharacteristic(): " + this.c.o);
                    this.c.n = false;
                    this.c.m.signal();
                } finally {
                    this.c.l.unlock();
                }
            }
        }
    }
}
