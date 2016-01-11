package com.xiaomi.hm.health.bt.profile.b;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;

class i implements B {
    final /* synthetic */ byte[] a;
    final /* synthetic */ f b;

    i(f fVar, byte[] bArr) {
        this.b = fVar;
        this.a = bArr;
    }

    public void a(byte[] bArr) {
        C0596r.d(this.b.z, "m_CharLEParams notify:" + y.b(bArr));
        synchronized (this.b.K) {
            this.a[0] = bArr[0];
            this.a[1] = bArr[1];
            this.b.K.notify();
        }
    }
}
