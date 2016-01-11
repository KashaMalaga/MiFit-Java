package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.e.a;
import com.xiaomi.hm.health.bt.d.e;

final class ah implements e {
    final /* synthetic */ ad a;

    private ah(ad adVar) {
        this.a = adVar;
    }

    public void a(int i) {
        if (i == a.c()) {
            C0596r.d("BStep", "RealtimeActiveCallback ENABLE_REALTIME_STEP_FAILED mIsEnableRTMode " + this.a.e);
            a.a(this.a.e, this.a.j);
        } else if (i == a.d()) {
            C0596r.d("BStep", "RealtimeActiveCallback GET_STEPS_FAILED");
        } else {
            this.a.b(-1, i);
        }
    }
}
