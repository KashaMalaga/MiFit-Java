package cn.com.smartdevices.bracelet.honor;

import cn.com.smartdevices.bracelet.C0596r;
import com.c.a.r;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

class z extends h {
    final /* synthetic */ String a;
    final /* synthetic */ y b;

    z(y yVar, String str) {
        this.b = yVar;
        this.a = str;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
        C0596r.e("MedalManager", "onSync medal data state [ERROR] data" + this.a);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.e("MedalManager", "onSync medal data state [OK] data:" + this.a);
        List h = C0545a.h(this.b.a);
        List list = (List) new r().i().a(this.a, new A(this).getType());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            h.add(list.get(i2));
        }
        C0545a.c(this.b.a, h);
    }
}
