package cn.com.smartdevices.bracelet.weight.family;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.aE;
import cn.com.smartdevices.bracelet.weight.ah;

class g implements aE {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void a() {
        C0596r.e("MemberInfoSetWeightActivity", "syncinfowithserver onSucess");
        J.a().a(this.a.c.p);
        ah.a().a(this.a.c.p);
        this.a.c.u = true;
        C0401a.a(this.a.c.p, C0401a.fo);
    }

    public void b() {
        C0596r.e("MemberInfoSetWeightActivity", "syncinfowithserver onFailure");
        this.a.c.u = false;
        C0401a.a(this.a.c.p, C0401a.fp);
    }
}
