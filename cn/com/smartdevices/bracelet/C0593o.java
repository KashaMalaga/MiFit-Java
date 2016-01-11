package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.j.m;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.util.ArrayList;
import org.apache.http.Header;

class C0593o extends h {
    final /* synthetic */ C0595q a;
    final /* synthetic */ C0591m b;

    C0593o(C0591m c0591m, C0595q c0595q) {
        this.b = c0591m;
        this.a = c0595q;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        Utils.b(bArr);
        C0596r.e("DataManager", "loadNetData onFailure:" + i);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        n a = m.a(C0591m.x, 0, new String(bArr), arrayList);
        if (a.c()) {
            C0591m.a().a(arrayList, 1, this.a);
        }
        C0596r.e("DataManager", "loadNetData onSuccess:" + a.h);
    }
}
