package cn.com.smartdevices.bracelet.weight.family;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.aE;
import cn.com.smartdevices.bracelet.weight.ah;

class c implements aE {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void a() {
        C0596r.e("MemberInfoBaseActivity", "syncinfowithserver onSucess");
        J.a().a(this.a.b.h);
        ah.a().a(this.a.b.h);
        this.a.b.s = true;
        C0401a.a(this.a.b.h, C0401a.fo);
    }

    public void b() {
        C0596r.e("MemberInfoBaseActivity", "syncinfowithserver onFailure");
        this.a.b.s = false;
        C0401a.a(this.a.b.h, C0401a.fp);
    }
}
