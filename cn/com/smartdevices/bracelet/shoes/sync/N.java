package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.shoes.sync.b.i;
import cn.com.smartdevices.bracelet.shoes.sync.b.m;
import com.d.a.a.h;
import org.apache.http.Header;

final class N extends h {
    final /* synthetic */ int a;
    final /* synthetic */ O b;
    final /* synthetic */ i c;
    final /* synthetic */ Context d;

    N(int i, O o, i iVar, Context context) {
        this.a = i;
        this.b = o;
        this.c = iVar;
        this.d = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(B.a, "onFailure statusCode = " + i + ",content = " + S.a(bArr) + ",type = " + this.a + ",error:" + th);
        this.b.a(false);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        m mVar = new m(this.c.i);
        n a = C0642s.a(this.d, new String(bArr), mVar);
        boolean c = a.c();
        C0596r.e(B.a, "onSuccess statusCode = " + i + ",isSucceeded = " + c + ",type:" + this.a + ",code = " + a.h + ",msg = " + a.i);
        if (c) {
            c &= C0640q.a(this.d, mVar.a());
        }
        this.b.a(mVar.b());
        this.b.a(c);
        if (!c) {
            C0596r.d(B.a, "getSyncDateDataResultFromSever failed! type:" + this.a + ",devceid:" + this.c.i);
        }
    }
}
