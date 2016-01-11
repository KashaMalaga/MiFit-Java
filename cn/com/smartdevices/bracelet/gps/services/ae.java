package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.e.a;
import com.xiaomi.hm.health.bt.a.d;

class ae extends d {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
    }

    public void c(Object obj) {
        if (!(obj instanceof Integer)) {
            return;
        }
        if (((Integer) obj).intValue() == a.d()) {
            C0596r.d("BStep", "mGetCurStepCallback GET_STEPS_FAILED");
        } else {
            this.a.b(-1, ((Integer) obj).intValue());
        }
    }
}
