package cn.com.smartdevices.bracelet.datasource;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.h.a;

public class e extends RtStep {
    private a a = a.a();

    public e() {
        super(3);
    }

    public boolean enable(boolean z, com.xiaomi.hm.health.bt.d.e eVar) {
        boolean a = this.a.a(z, eVar);
        if (!a) {
            eVar.a(-3);
            C0596r.d(this.TAG, "enable RtStepSensorHub failed!!!");
        }
        return a;
    }

    public int getSteps() {
        return this.a.b();
    }
}
