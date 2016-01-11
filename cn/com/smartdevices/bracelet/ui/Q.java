package cn.com.smartdevices.bracelet.ui;

import com.xiaomi.hm.health.bt.a.d;

class Q extends d {
    final /* synthetic */ BindWeixinActivityNew a;

    Q(BindWeixinActivityNew bindWeixinActivityNew) {
        this.a = bindWeixinActivityNew;
    }

    public void a() {
        super.a();
        this.a.f();
    }

    public void a(Object obj) {
        super.a(obj);
        if (((Boolean) obj).booleanValue()) {
            this.a.f.sendEmptyMessage(0);
        } else {
            this.a.d();
        }
    }

    public void b(Object obj) {
        super.b(obj);
        this.a.d();
    }
}
