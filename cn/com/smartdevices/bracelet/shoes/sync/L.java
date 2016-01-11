package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.j;
import com.d.a.a.h;
import org.apache.http.Header;

final class L extends h {
    final /* synthetic */ int a;
    final /* synthetic */ j b;
    final /* synthetic */ Context c;
    final /* synthetic */ c d;

    L(int i, j jVar, Context context, c cVar) {
        this.a = i;
        this.b = jVar;
        this.c = context;
        this.d = cVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(B.a, "onFailure statusCode = " + i + ",content = " + S.a(bArr) + ",type = " + this.a + ",error:" + th);
        this.b.a(false);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        boolean c = C0642s.a(this.c, new String(bArr), this.b).c();
        this.b.a(c);
        if (!c) {
            C0596r.e(B.a, "onSuccess failed! type = " + this.a + ",mac = " + this.d);
        }
    }
}
