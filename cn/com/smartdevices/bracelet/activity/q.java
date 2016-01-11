package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.account.openauth.l;

class q implements u {
    final /* synthetic */ LoginActivity a;

    q(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public void a(Object obj) {
        C0596r.e(C0401a.cc, "onResult: " + obj);
        if (obj != null && (obj instanceof l)) {
            this.a.b((l) obj);
        }
    }
}
