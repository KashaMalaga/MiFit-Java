package cn.com.smartdevices.bracelet.ui;

import com.xiaomi.hm.health.bt.a.d;

class K extends d {
    final /* synthetic */ BindWeixinActivity a;

    K(BindWeixinActivity bindWeixinActivity) {
        this.a = bindWeixinActivity;
    }

    public void a() {
        super.a();
        this.a.h();
    }

    public void a(Object obj) {
        super.a(obj);
        if (((Boolean) obj).booleanValue()) {
            this.a.m.sendEmptyMessage(0);
        } else {
            this.a.c();
        }
    }

    public void b(Object obj) {
        super.b(obj);
        this.a.c();
    }
}
