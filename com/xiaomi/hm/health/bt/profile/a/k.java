package com.xiaomi.hm.health.bt.profile.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;

class k implements B {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void a(byte[] bArr) {
        boolean z = true;
        if (bArr.length != 1) {
            z = false;
        }
        C0596r.a(z);
        C0596r.d("=================================================");
        C0596r.d("========== NOTIFICATION STATUS CHANGED ==========");
        C0596r.d("=================================================");
        if (!this.a.e(bArr[0]) && this.a.bn != null) {
            this.a.bn.b(this.a.f(), bArr[0]);
        }
    }
}
