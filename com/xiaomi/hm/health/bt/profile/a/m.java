package com.xiaomi.hm.health.bt.profile.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class m implements B {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public void a(byte[] bArr) {
        C0596r.a(bArr.length == 10);
        byte b = bArr[9];
        int i = bArr[0] & HeartRateInfo.HR_EMPTY_VALUE;
        switch (b) {
            case a.i /*0*/:
                C0596r.f(">>> UNEXPECTED <<<");
                break;
            case l.a /*1*/:
                C0596r.a("Battery low");
                break;
            case a.k /*2*/:
                C0596r.a("Battery charging");
                break;
            case a.l /*3*/:
                C0596r.a("Battery full (charging)");
                break;
            case a.aQ /*4*/:
                C0596r.a("Battery charger off");
                break;
            default:
                C0596r.f(">>> UNEXPECTED <<<");
                return;
        }
        if (this.a.bm != null) {
            this.a.bm.a(b, i);
        }
        if (this.a.bn != null) {
            this.a.bn.b(this.a.f(), b, i);
        }
    }
}
