package cn.com.smartdevices.bracelet.weibo;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.ResponseEntity;
import com.xiaomi.hm.health.r;

class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ i b;

    j(i iVar, String str) {
        this.b = iVar;
        this.a = str;
    }

    public void run() {
        if (TextUtils.isEmpty(this.a)) {
            this.b.a.a(true);
            C0401a.a(this.b.a, C0401a.aH);
            return;
        }
        String b = s.b(this.a);
        this.b.a.r.nickName = b;
        if (BindHealthActivity.a == 2) {
            q.a(this.b.a, this.b.a.r);
            q.a(this.b.a, b);
            ResponseEntity f = this.b.a.j.f(this.b.a);
            if (f.state && f.code == 1) {
                C0596r.d("BindWeiboHealthActivity", "Upload token OK");
                q.a(this.b.a, 1);
                this.b.a.b(1);
                q.a(this.b.a, false);
                this.b.a.j.a(false);
            } else {
                C0596r.d("BindWeiboHealthActivity", "Upload token ERROR");
            }
            this.b.a.a(true);
            return;
        }
        ResponseEntity a = v.a().a(this.b.a, this.b.a.r, 0);
        if (!a.state) {
            this.b.a.c((int) r.weibosdk_toast_auth_failed);
            C0401a.a(this.b.a, C0401a.aJ);
        } else if (a.code == 1) {
            q.a(this.b.a, this.b.a.r);
            q.a(this.b.a, b);
            q.a(this.b.a, 1);
            q.a(this.b.a, false);
        } else {
            this.b.a.a(a.msg);
            C0401a.a(this.b.a, C0401a.aJ);
        }
        this.b.a.runOnUiThread(new k(this, q.a(this.b.a)));
    }
}
