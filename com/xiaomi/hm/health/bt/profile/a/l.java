package com.xiaomi.hm.health.bt.profile.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

class l implements B {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public void a(byte[] bArr) {
        int length = bArr.length;
        if (length == 2) {
            length = (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        } else if (length == 3) {
            length = (bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        } else if (length == 4) {
            length = (((bArr[0] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[1] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[3] & HeartRateInfo.HR_EMPTY_VALUE) << 24);
        } else {
            C0596r.d("MiLiProfile", "wrong notify data length:" + length);
            return;
        }
        C0596r.a("RealtimeSteps: " + length);
        if (this.a.bq != null) {
            this.a.bq.a(length);
        }
        if (this.a.bn != null) {
            this.a.bn.b(length);
        }
    }
}
