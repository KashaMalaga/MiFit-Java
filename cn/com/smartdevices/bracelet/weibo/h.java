package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.ResponseEntity;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.r;

class h implements Runnable {
    final /* synthetic */ BindHealthActivity a;

    h(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void run() {
        ResponseEntity a = this.a.j.a(this.a, q.e(this.a), 1);
        if (a.state && a.code == 1) {
            q.a(this.a, 0);
            this.a.b(0);
        } else {
            C0596r.e("BindWeiboHealthActivity", "Unbind OP ERROR");
            String str = a.msg;
            if (str == null || a.f.equals(str)) {
                this.a.c((int) r.weibosdk_toast_unbind_failed);
            } else {
                this.a.a(str);
            }
        }
        this.a.a(true);
    }
}
