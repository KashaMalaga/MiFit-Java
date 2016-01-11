package cn.com.smartdevices.bracelet;

import com.xiaomi.hm.health.bt.a.d;

class M extends d {
    final /* synthetic */ TimeChangedReceiver a;

    M(TimeChangedReceiver timeChangedReceiver) {
        this.a = timeChangedReceiver;
    }

    public void a(Object obj) {
        super.a(obj);
        if (obj == null || !((Boolean) obj).booleanValue()) {
            C0596r.d(TimeChangedReceiver.a, "setDateTime failed!!!");
        } else {
            C0596r.d(TimeChangedReceiver.a, "setDateTime success!!!");
        }
    }

    public void b(Object obj) {
        super.b(obj);
        C0596r.d(TimeChangedReceiver.a, "setDateTime failed!!!");
    }
}
