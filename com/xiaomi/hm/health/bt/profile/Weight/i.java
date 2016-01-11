package com.xiaomi.hm.health.bt.profile.Weight;

import android.bluetooth.BluetoothGattCharacteristic;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;

class i implements B {
    final /* synthetic */ BluetoothGattCharacteristic a;
    final /* synthetic */ f b;

    i(f fVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.b = fVar;
        this.a = bluetoothGattCharacteristic;
    }

    public void a(byte[] bArr) {
        this.b.G = bArr;
        C0596r.e(f.n, "cpt response: " + y.b(this.b.G));
        synchronized (this.a) {
            this.a.notify();
        }
    }
}
