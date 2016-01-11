package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

final class x extends h {
    final /* synthetic */ C0480n a;
    final /* synthetic */ Context b;
    final /* synthetic */ long c;
    final /* synthetic */ int d;

    x(C0480n c0480n, Context context, long j, int i) {
        this.a = c0480n;
        this.b = context;
        this.c = j;
        this.d = i;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        String a = R.a(bArr);
        this.a.a = false;
        C0596r.e("Sync", "syncContourTrackToServer onFailure:" + a + ", statusCode = " + i);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String a = R.a(bArr);
        n a2 = n.a(this.b, a);
        boolean z = false;
        if (a2.c()) {
            z = p.e(this.b, this.c, this.d);
        }
        this.a.a = z;
        if (!this.a.a) {
            C0596r.e("Sync", "syncContourTrackToServer onSuccess:" + a + " ,code = " + a2.h + ", success = " + a2.c() + " ,isSucceeded = " + z);
        }
    }
}
