package com.xiaomi.hm.health.bt.profile.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class f extends d {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void a(Object obj) {
        super.a(obj);
        C0596r.e("MiLiHeartRate", "BleSyncCmdTask:" + obj);
    }
}
