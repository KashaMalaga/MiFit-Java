package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import cn.com.smartdevices.bracelet.C0596r;

class m implements Runnable {
    final /* synthetic */ BluetoothGatt a;
    final /* synthetic */ BluetoothGattDescriptor b;
    final /* synthetic */ C1118a c;

    m(C1118a c1118a, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.c = c1118a;
        this.a = bluetoothGatt;
        this.b = bluetoothGattDescriptor;
    }

    public void run() {
        C0596r.e();
        C0596r.a(this.c.f);
        C0596r.a(this.a);
        if (this.a == null) {
            this.c.l.lock();
            try {
                this.c.o = z.h;
                C0596r.b("NOTIFY: synchronizedReadDescriptor(): " + this.c.o);
                this.c.n = false;
                this.c.m.signal();
            } finally {
                this.c.l.unlock();
            }
        } else {
            boolean readDescriptor = this.a.readDescriptor(this.b);
            C0596r.a(readDescriptor);
            if (!readDescriptor) {
                this.c.l.lock();
                try {
                    this.c.o = z.i;
                    C0596r.b("NOTIFY: synchronizedReadDescriptor(): " + this.c.o);
                    this.c.n = false;
                    this.c.m.signal();
                } finally {
                    this.c.l.unlock();
                }
            }
        }
    }
}
