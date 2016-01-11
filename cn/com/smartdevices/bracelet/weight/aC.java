package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import cn.com.smartdevices.bracelet.weight.goal.a;

class aC implements aE {
    final /* synthetic */ aB a;

    aC(aB aBVar) {
        this.a = aBVar;
    }

    public void a() {
        QQHealth qQHealth = null;
        if (b.h().c.d.booleanValue()) {
            qQHealth = QQHealth.getInstance();
            if (qQHealth != null) {
                aA.b(qQHealth);
            }
        }
        J.a().a(this.a.a);
        a.a().a(this.a.a);
        ah.a().a(this.a.a);
        if (qQHealth != null) {
            qQHealth.syncDataWeight();
        }
    }

    public void b() {
    }
}
