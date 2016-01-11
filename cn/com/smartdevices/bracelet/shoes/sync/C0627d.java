package cn.com.smartdevices.bracelet.shoes.sync;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.b.c;

final class C0627d implements c {
    final /* synthetic */ C0625b a;

    private C0627d(C0625b c0625b) {
        this.a = c0625b;
    }

    public void a(cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        this.a.b(cVar);
        C0596r.d("SDC", "onDeviceBound identity= " + cVar);
    }

    public void b(cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        boolean z = true;
        if (!(this.a.c == null || cVar == null)) {
            z = cVar.equals(this.a.c.f());
        }
        this.a.i();
        C0596r.d("SDC", "onDeviceUnbound identity:" + cVar + ",isSameConnection:" + z);
    }
}
