package cn.com.smartdevices.bracelet.weibo;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.model.ResponseEntity;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;

class w implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ v b;

    w(v vVar, Context context) {
        this.b = vVar;
        this.a = context;
    }

    public void run() {
        ThirdLoginState e;
        ThirdLoginState thirdLoginState = null;
        if (q.g(this.a)) {
            e = q.e(this.a);
        } else {
            if (!q.d(this.a)) {
                ResponseEntity h = this.b.h(this.a);
                if (h.state) {
                    if (h.getData() != null) {
                        thirdLoginState = (ThirdLoginState) h.getData();
                        q.a(this.a, thirdLoginState);
                    }
                    q.b(this.a, true);
                    e = thirdLoginState;
                }
            }
            e = null;
        }
        if (e != null) {
            if (e.bindState == 0) {
                C0596r.e("WeiboHealthManager", "return [cause by unbind]");
                return;
            }
            ResponseEntity g = this.b.g(this.a);
            if (g.state && g.code == 1) {
                int i = ((ThirdLoginState) g.getData()).bindState;
                e.bindState = i;
                q.a(this.a, i);
            }
            if (e.bindState == -1) {
                if (!q.c(this.a)) {
                    this.b.a(true);
                    q.a(this.a, true);
                }
                C0596r.e("WeiboHealthManager", "return [cause by bind invalid]");
                return;
            }
            long j = e.expiresIn;
            if (e.bindState == 1 && j > 0 && j > 432000) {
                C0596r.e("WeiboHealthManager", "return [bind state valid]");
            } else if (j <= 432000) {
                this.b.a(this.a, new x(this));
            }
        }
    }
}
