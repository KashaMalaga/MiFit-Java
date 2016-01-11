package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.activity.t;

class f implements t {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void a() {
        this.a.dismissAllowingStateLoss();
        C0596r.e("BindWeiboHealthActivity", "login callback succeed");
        if (BindHealthActivity.a == 1) {
            this.a.a.c();
        }
    }

    public void b() {
        C0596r.e("BindWeiboHealthActivity", "login callback failure");
        C0401a.a(this.a.a, C0401a.aK);
    }
}
