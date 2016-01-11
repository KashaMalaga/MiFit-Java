package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.util.ArrayList;
import org.apache.http.Header;

final class J extends h {
    final /* synthetic */ int a;
    final /* synthetic */ C0480n b;
    final /* synthetic */ Context c;
    final /* synthetic */ ArrayList d;

    J(int i, C0480n c0480n, Context context, ArrayList arrayList) {
        this.a = i;
        this.b = c0480n;
        this.c = context;
        this.d = arrayList;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Sync", "syncTrackIdListFromServer onFailure statusCode = " + i + ",content = " + R.a(bArr) + ",type = " + this.a);
        this.b.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        n d = C0476i.d(this.c, new String(bArr), this.d);
        this.b.a = d.c();
        if (!this.b.a) {
            C0596r.e("Sync", "syncTrackIdListFromServer onSuccess statusCode = " + i + ",type = " + this.a);
        }
    }
}
