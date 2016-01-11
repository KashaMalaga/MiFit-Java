package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.account.openauth.l;

class p implements u {
    final /* synthetic */ LoginActivity a;

    p(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public void a(Object obj) {
        C0596r.e(C0401a.cc, "get code = " + obj.toString());
        this.a.a((l) obj);
    }
}
