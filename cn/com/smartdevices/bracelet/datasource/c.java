package cn.com.smartdevices.bracelet.datasource;

import com.xiaomi.hm.health.bt.a.o;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.profile.a.j;

public class c extends RtStep {
    public c() {
        super(0);
    }

    public boolean enable(boolean z, e eVar) {
        new o(new d(this, eVar), z, eVar).g();
        return true;
    }

    public int getSteps() {
        j a = a.a();
        return (a == null || !a.u()) ? -1 : a.k_();
    }
}
