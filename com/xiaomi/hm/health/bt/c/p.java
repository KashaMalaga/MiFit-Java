package com.xiaomi.hm.health.bt.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import cn.com.smartdevices.bracelet.C0596r;

class p implements Runnable {
    final /* synthetic */ BluetoothGatt a;
    final /* synthetic */ BluetoothGattDescriptor b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ C1118a d;

    p(C1118a c1118a, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        this.d = c1118a;
        this.a = bluetoothGatt;
        this.b = bluetoothGattDescriptor;
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
                C0596r.b("NOTIFY: synchronizedWriteDescriptor(): " + this.d.o);
                this.d.n = false;
                this.d.m.signal();
            } finally {
                this.d.l.unlock();
            }
        } else {
            this.b.setValue(this.c);
            boolean writeDescriptor = this.a.writeDescriptor(this.b);
            C0596r.a(writeDescriptor);
            if (!writeDescriptor) {
                this.d.l.lock();
                try {
                    this.d.o = z.i;
                    C0596r.b("NOTIFY: synchronizedWriteDescriptor(): " + this.d.o);
                    this.d.n = false;
                    this.d.m.signal();
                } finally {
                    this.d.l.unlock();
                }
            }
        }
    }
}
