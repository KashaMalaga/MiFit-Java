package com.xiaomi.hm.health.bt.e;

import android.bluetooth.BluetoothDevice;
import cn.com.smartdevices.bracelet.C0596r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

class c implements j {
    final /* synthetic */ UUID a;
    final /* synthetic */ a b;

    c(a aVar, UUID uuid) {
        this.b = aVar;
        this.a = uuid;
    }

    public void a(BluetoothDevice bluetoothDevice, ArrayList<UUID> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            UUID uuid = (UUID) it.next();
            C0596r.d("BleScanCenter", "device:" + bluetoothDevice.getAddress() + ",UUID:" + uuid.toString());
            if (this.a.equals(uuid) && (bluetoothDevice.getName() == null || !bluetoothDevice.getName().equals("AF"))) {
                if (!this.b.p) {
                    this.b.a(bluetoothDevice, uuid.toString());
                }
                this.b.t = this.b.t + 1;
                this.b.s = this.b.s - 1;
                if (this.b.s == 0 && this.b.t == 0 && !this.b.p) {
                    this.b.h.sendEmptyMessage(0);
                    return;
                }
                return;
            }
        }
        this.b.s = this.b.s - 1;
        if (this.b.s == 0) {
        }
    }
}
