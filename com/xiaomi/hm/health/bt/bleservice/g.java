package com.xiaomi.hm.health.bt.bleservice;

import android.os.PowerManager.WakeLock;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class g extends d {
    final /* synthetic */ int a;
    final /* synthetic */ WakeLock b;
    final /* synthetic */ BLEService d;

    g(BLEService bLEService, int i, WakeLock wakeLock) {
        this.d = bLEService;
        this.a = i;
        this.b = wakeLock;
    }

    public void a() {
        super.a();
    }

    public void a(Object obj) {
        super.a(obj);
        if (((Integer) obj).intValue() == 8) {
            C0596r.b("BLEService", "setLatency success......" + this.a);
        } else {
            C0596r.b("BLEService", "setLatency failed......" + this.a);
        }
        C0596r.b("BLEService", "waklock release......" + this.a);
        if (this.b.isHeld()) {
            this.b.release();
        }
    }

    public void b(Object obj) {
        super.b(obj);
        C0596r.b("BLEService", "setLatency failed......" + this.a);
        C0596r.b("BLEService", "waklock release......" + this.a);
        if (this.b.isHeld()) {
            this.b.release();
        }
    }
}
