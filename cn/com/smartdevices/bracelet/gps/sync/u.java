package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

final class u extends h {
    final /* synthetic */ C0480n a;
    final /* synthetic */ Context b;
    final /* synthetic */ int c;

    u(C0480n c0480n, Context context, int i) {
        this.a = c0480n;
        this.b = context;
        this.c = i;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Sync", "syncSportConfigToSever onFailure:" + R.a(bArr));
        this.a.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        boolean z = false;
        if (n.a(this.b, R.a(bArr)).c()) {
            z = p.i(this.b, this.c);
        }
        this.a.a = z;
        if (!this.a.a) {
            C0596r.e("Sync", "syncSportConfigToSever isSucceeded = " + z + ",sportType = " + this.c);
        }
    }
}
