package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.gps.e.a;
import com.xiaomi.hm.health.bt.a.C;
import com.xiaomi.hm.health.bt.a.d;

class H extends C {
    private d a = null;

    public H(d dVar) {
        super(null);
        this.a = dVar;
    }

    public void a(d dVar) {
        if (this.a != null) {
            this.a.c();
        }
        int b = a.b();
        if (this.a != null) {
            this.a.c(Integer.valueOf(b));
        }
    }
}
