package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.a;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.util.List;
import org.apache.http.Header;

final class K extends h {
    final /* synthetic */ int a;
    final /* synthetic */ C0480n b;
    final /* synthetic */ Context c;
    final /* synthetic */ List d;

    K(int i, C0480n c0480n, Context context, List list) {
        this.a = i;
        this.b = c0480n;
        this.c = context;
        this.d = list;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Sync", "deleteTargetTrackIdFromServer onFailure statusCode = " + i + "  content = " + R.a(bArr) + ", type = " + this.a);
        this.b.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        a aVar = new a();
        n a = C0476i.a(this.c, new String(bArr), aVar);
        List a2 = aVar.a();
        if (a2.size() > 0) {
            this.d.removeAll(a2);
            p.a(this.c, a2);
        }
        this.b.a = a.c();
        C0596r.e("Sync", "deleteTargetTrackIdFromServer isSucceeded = " + this.b.a + ", type = " + this.a);
    }
}
