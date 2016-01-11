package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.o;
import com.d.a.a.h;
import org.apache.http.Header;

final class I extends h {
    final /* synthetic */ int a;
    final /* synthetic */ C0482p b;
    final /* synthetic */ Context c;

    I(int i, C0482p c0482p, Context context) {
        this.a = i;
        this.b = c0482p;
        this.c = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Sync", "syncSummaryFromServerBatch onFailure statusCode = " + i + ",content = " + R.a(bArr) + ",type = " + this.a);
        this.b.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        o oVar = new o();
        C0482p c0482p = null;
        if (C0476i.a(this.c, new String(bArr), oVar).c()) {
            if (oVar.b.size() > 0) {
                c0482p = C0481o.a(this.c, oVar.b);
            } else {
                c0482p = new C0482p();
                c0482p.a = true;
            }
        }
        if (c0482p != null) {
            this.b.a(c0482p);
            c0482p.a();
        }
        if (!this.b.a) {
            C0596r.e("Sync", "syncSummaryFromServerBatch onSuccess isSucceeded = " + this.b.a + ",type = " + this.a);
        }
    }
}
