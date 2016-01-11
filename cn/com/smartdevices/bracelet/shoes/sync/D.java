package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.i;
import cn.com.smartdevices.bracelet.shoes.sync.b.k;
import com.d.a.a.h;
import org.apache.http.Header;

final class D extends h {
    final /* synthetic */ cn.com.smartdevices.bracelet.shoes.sync.b.h a;
    final /* synthetic */ i b;
    final /* synthetic */ Context c;
    final /* synthetic */ c d;

    D(cn.com.smartdevices.bracelet.shoes.sync.b.h hVar, i iVar, Context context, c cVar) {
        this.a = hVar;
        this.b = iVar;
        this.c = context;
        this.d = cVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(B.a, "onFailure statusCode = " + i + ",content = " + S.a(bArr) + ",type shoes" + ",error:" + th);
        this.a.a(false);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        k kVar = new k();
        kVar.a = this.b.i;
        boolean c = C0642s.a(this.c, new String(bArr), kVar, this.d).c();
        C0596r.e(B.a, "onSuccess statusCode:" + i + ",isSucceeded:" + c + ",type shoes");
        if (c && kVar.a() != null) {
            c &= C0630g.a(this.c, this.d, kVar.a());
        }
        this.a.a(c);
        if (!this.a.b()) {
            C0596r.d(B.a, "updateShoesInfo isSucceeded = " + c + ",type shoes");
        }
    }
}
