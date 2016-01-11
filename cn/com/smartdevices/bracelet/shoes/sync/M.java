package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.n;
import com.d.a.a.h;
import org.apache.http.Header;

final class M extends h {
    final /* synthetic */ cn.com.smartdevices.bracelet.shoes.sync.b.h a;
    final /* synthetic */ int b;
    final /* synthetic */ Context c;
    final /* synthetic */ c d;
    final /* synthetic */ cn.com.smartdevices.bracelet.shoes.model.h e;

    M(cn.com.smartdevices.bracelet.shoes.sync.b.h hVar, int i, Context context, c cVar, cn.com.smartdevices.bracelet.shoes.model.h hVar2) {
        this.a = hVar;
        this.b = i;
        this.c = context;
        this.d = cVar;
        this.e = hVar2;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        String a = S.a(bArr);
        this.a.a(false);
        C0596r.e(B.a, "onFailure statusCode = " + i + "  content = " + a + ",type = " + this.b + ",error:" + th);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        boolean c = C0642s.a(this.c, S.a(bArr), new n()).c();
        if (c) {
            c &= t.b(this.c, this.d, this.e.e());
        }
        this.a.a(c);
        if (!this.a.b()) {
            C0596r.e(B.a, "onSuccess isSucceeded = " + c + ",mac = " + this.e.l() + ",date = " + this.e.e() + ",type = " + this.b);
        }
    }
}
