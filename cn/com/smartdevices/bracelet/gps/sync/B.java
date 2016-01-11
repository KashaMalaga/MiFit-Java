package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

final class B extends h {
    final /* synthetic */ C0480n a;
    final /* synthetic */ Context b;

    B(C0480n c0480n, Context context) {
        this.a = c0480n;
        this.b = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        String a = R.a(bArr);
        this.a.a = false;
        C0596r.e("Sync", "syncTrackInfoToSever onFailure:" + a + ", statusCode = " + i);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String a = R.a(bArr);
        n a2 = n.a(this.b, a);
        if (a2.c()) {
            this.a.a = true;
        }
        if (!this.a.a) {
            C0596r.e("Sync", "syncTrackInfoToSever onSuccess:" + a + " ,code = " + a2.h + ", success = " + a2.c());
        }
    }
}
