package cn.com.smartdevices.bracelet;

import com.d.a.a.h;
import org.apache.http.Header;

final class P extends h {
    final /* synthetic */ ac a;

    P(ac acVar) {
        this.a = acVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Utils", "delete user weight target fail");
        this.a.b();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            C0596r.e("Utils", "Response delete user target weight : " + new String(bArr));
            this.a.a();
            return;
        }
        this.a.b();
    }
}
