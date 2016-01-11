package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

final class H extends h {
    final /* synthetic */ C0480n a;
    final /* synthetic */ long b;
    final /* synthetic */ Context c;
    final /* synthetic */ C0466z d;

    H(C0480n c0480n, long j, Context context, C0466z c0466z) {
        this.a = c0480n;
        this.b = j;
        this.c = context;
        this.d = c0466z;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        String a = R.a(bArr);
        this.a.a = false;
        C0596r.e("Sync", "syncSportSummaryToServer onFailure statusCode = " + i + "  content = " + a + ", trackId = " + this.b);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        boolean z = false;
        if (n.a(this.c, R.a(bArr)).c()) {
            z = p.g(this.c, this.b, this.d.v());
        }
        this.a.a = z;
        if (!this.a.a) {
            C0596r.e("Sync", "syncSportSummaryToServer onSuccess isSucceeded = " + z + ", trackId = " + this.b);
        }
    }
}
