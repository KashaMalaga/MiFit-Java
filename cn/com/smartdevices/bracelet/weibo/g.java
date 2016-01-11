package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.model.ResponseEntity;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;

class g implements Runnable {
    final /* synthetic */ BindHealthActivity a;

    g(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void run() {
        ResponseEntity g = this.a.j.g(this.a);
        if (g.state && g.code == 1) {
            int i = ((ThirdLoginState) g.getData()).bindState;
            q.a(this.a, i);
            this.a.b(i);
        }
    }
}
