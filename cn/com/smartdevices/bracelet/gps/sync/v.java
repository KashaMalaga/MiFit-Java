package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.model.n;
import com.d.a.a.h;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.Header;

final class v extends h {
    final /* synthetic */ C0480n a;
    final /* synthetic */ int b;
    final /* synthetic */ Context c;

    v(C0480n c0480n, int i, Context context) {
        this.a = c0480n;
        this.b = i;
        this.c = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        String a = R.a(bArr);
        this.a.a = false;
        C0596r.e("Sync", "syncSportConfigFromServer onFailure statusCode = " + i + ",content = " + a + ",type = " + this.b);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (C0476i.b(this.c, new String(bArr), arrayList).c()) {
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.d() != null) {
                    z = p.a(this.c, new d(nVar.g(), new String(nVar.d())));
                    if (z) {
                        z = p.h(this.c, nVar.g()) & z;
                    }
                }
            }
            this.a.a = z;
            if (!this.a.a) {
                C0596r.e("Sync", "syncSportConfigFromServer onSuccess  statusCode = " + i + ",content = " + ",type = " + this.b + " ,isSucceeded = " + z);
            }
        }
    }
}
