package com.xiaomi.hm.health.bt.bleservice;

import android.bluetooth.BluetoothDevice;
import com.xiaomi.hm.health.bt.e.f;
import com.xiaomi.hm.health.bt.e.h;
import com.xiaomi.hm.health.bt.model.e;

class l implements h {
    final /* synthetic */ String a;
    final /* synthetic */ BLEService b;

    l(BLEService bLEService, String str) {
        this.b = bLEService;
        this.a = str;
    }

    public void a(f fVar) {
    }

    public void a(e eVar, f fVar) {
        this.b.S = eVar;
        this.b.j();
    }

    public void b(f fVar) {
        BluetoothDevice a = this.b.S == null ? this.b.b(this.a) : this.b.S.a;
        if (a != null) {
            this.b.a(a, true);
        } else {
            this.b.b(1);
        }
    }
}
