package cn.com.smartdevices.bracelet.ui;

import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.model.f;

class C0785ef extends d {
    final /* synthetic */ boolean a;
    final /* synthetic */ C0784ee b;

    C0785ef(C0784ee c0784ee, boolean z) {
        this.b = c0784ee;
        this.a = z;
    }

    public void a() {
        super.a();
    }

    public void a(Object obj) {
        super.a(obj);
        if (!this.b.a(this.b.D)) {
            if (obj != null) {
                this.b.j = (f) obj;
            }
            if (this.b.j != null) {
                this.b.c(this.a);
            }
        }
    }

    public void b(Object obj) {
        super.b(obj);
        if (!this.b.a(this.b.D)) {
            this.b.c(this.a);
        }
    }
}
