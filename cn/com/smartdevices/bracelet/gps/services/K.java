package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class K extends d {
    final /* synthetic */ I a;

    K(I i) {
        this.a = i;
    }

    public void a(Object obj) {
        super.a(obj);
        C0596r.d("HRProvider", "start realtime hr:" + obj);
    }
}
