package com.xiaomi.hm.health.bt.profile.b;

import android.bluetooth.BluetoothGattCharacteristic;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;

class h implements B {
    final /* synthetic */ BluetoothGattCharacteristic a;
    final /* synthetic */ f b;

    h(f fVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.b = fVar;
        this.a = bluetoothGattCharacteristic;
    }

    public void a(byte[] bArr) {
        this.b.O = bArr;
        C0596r.e(this.b.z, "cpt response: " + y.b(this.b.O));
        synchronized (this.a) {
            this.a.notify();
        }
    }
}
