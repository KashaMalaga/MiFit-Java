package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.ResponseEntity;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;

class y implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ x b;

    y(x xVar, String str) {
        this.b = xVar;
        this.a = str;
    }

    public void run() {
        C0596r.e("WeiboHealthManager", "refresh Token & save Token:" + this.a);
        ThirdLoginState e = q.e(this.b.a.a);
        ThirdLoginState a = this.b.a.b.a(this.a);
        e.accessToken = a.accessToken;
        e.expiresIn = a.expiresIn;
        e.refreshToken = a.refreshToken;
        e.uid = a.uid;
        q.a(this.b.a.a, e);
        ResponseEntity f = this.b.a.b.f(this.b.a.a);
        if (f.state && f.code == 1) {
            C0596r.e("WeiboHealthManager", "Upload token succeed");
        } else if (!q.c(this.b.a.a)) {
            this.b.a.b.a(true);
            q.a(this.b.a.a, true);
            C0596r.e("WeiboHealthManager", "Upload token error");
        }
    }
}
