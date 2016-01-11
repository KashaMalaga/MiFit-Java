package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.j.m;
import com.d.a.a.h;
import org.apache.http.Header;

class L extends h {
    final /* synthetic */ BindWeixinActivity a;

    L(BindWeixinActivity bindWeixinActivity) {
        this.a = bindWeixinActivity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        this.a.c();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            this.a.c();
            return;
        }
        String a = m.a(this.a.getApplicationContext(), new String(bArr));
        if (a != null) {
            this.a.n = a;
            this.a.m.sendEmptyMessage(1);
            return;
        }
        this.a.c();
    }
}
