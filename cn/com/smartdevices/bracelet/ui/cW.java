package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

class cW extends h {
    final /* synthetic */ cX a;
    final /* synthetic */ cU b;

    cW(cU cUVar, cX cXVar) {
        this.b = cUVar;
        this.a = cXVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        this.a.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        n a = n.a(this.b.a.getActivity(), Utils.b(bArr));
        this.a.a = a.c();
    }
}
