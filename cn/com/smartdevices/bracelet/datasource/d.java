package cn.com.smartdevices.bracelet.datasource;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.d.e;

class d extends com.xiaomi.hm.health.bt.a.d {
    final /* synthetic */ e a;
    final /* synthetic */ c b;

    d(c cVar, e eVar) {
        this.b = cVar;
        this.a = eVar;
    }

    public void a() {
        super.a();
    }

    public void a(Object obj) {
        super.a(obj);
        if (obj == null || !((Boolean) obj).booleanValue()) {
            this.a.a(-3);
            C0596r.d(this.b.TAG, "enable RtStepBracelet failed!!!");
        }
    }

    public void b(Object obj) {
        super.b(obj);
        this.a.a(-3);
        C0596r.d(this.b.TAG, "enable RtStepBracelet failed!!!");
    }
}
