package cn.com.smartdevices.bracelet.ui;

import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.model.f;

class C0819t extends d {
    final /* synthetic */ C0818s a;

    C0819t(C0818s c0818s) {
        this.a = c0818s;
    }

    public void a(Object obj) {
        super.a(obj);
        if (obj != null) {
            f fVar = (f) obj;
            int i = 5;
            if (fVar.d == 2) {
                i = 10;
            }
            if (fVar.a > i) {
                this.a.a.b.upgrade(0);
            } else if (!this.a.a.K) {
                this.a.a.v();
                this.a.a.K = true;
            }
        }
    }

    public void b(Object obj) {
        super.b(obj);
    }
}
