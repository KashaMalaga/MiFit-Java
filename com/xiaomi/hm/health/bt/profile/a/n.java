package com.xiaomi.hm.health.bt.profile.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

class n implements B {
    final /* synthetic */ j a;

    n(j jVar) {
        this.a = jVar;
    }

    public void a(byte[] bArr) {
        C0596r.d("MiLiProfile", "HeartRate:" + y.b(bArr));
        if (this.a.bo != null) {
            this.a.bo.a(bArr[1] & HeartRateInfo.HR_EMPTY_VALUE);
        }
    }
}
