package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import com.d.a.a.h;
import org.apache.http.Header;

class s extends h {
    final /* synthetic */ LoginActivity a;

    s(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(C0401a.cc, "onFail " + Utils.b(bArr) + ", code = " + i);
        this.a.i();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        this.a.a(i, headerArr, bArr);
    }
}
