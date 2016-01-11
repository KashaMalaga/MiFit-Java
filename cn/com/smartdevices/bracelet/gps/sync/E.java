package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;

final class E extends h {
    final /* synthetic */ int a;
    final /* synthetic */ C0480n b;
    final /* synthetic */ Context c;
    final /* synthetic */ long d;

    E(int i, C0480n c0480n, Context context, long j) {
        this.a = i;
        this.b = c0480n;
        this.c = context;
        this.d = j;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Sync", "syncSportDataFromServer onFailure statusCode = " + i + ",content = " + R.a(bArr) + ",type = " + this.a);
        this.b.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        List arrayList = new ArrayList();
        n c = C0476i.c(this.c, new String(bArr), arrayList);
        boolean z = false;
        C0596r.e("Sync", "syncSportDataFromServer w.success = " + c.c() + ",type = " + this.a + ",trackId = " + this.d);
        if (c.c()) {
            z = C0472e.a(this.c, this.d, arrayList);
            if (z) {
                z = p.f(this.c, this.d, this.a);
            }
        }
        this.b.a = z;
        if (!z) {
            C0596r.e("Sync", "syncSportDataFromServer isSucceededToSaveToDB = " + z + ",type = " + this.a + ",trackId = " + this.d);
        }
    }
}
