package cn.com.smartdevices.bracelet.lab.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import java.util.ArrayList;
import org.apache.http.Header;

final class g extends h {
    final /* synthetic */ int a;
    final /* synthetic */ h b;
    final /* synthetic */ Context c;

    g(int i, h hVar, Context context) {
        this.a = i;
        this.b = hVar;
        this.c = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        String b = Utils.b(bArr);
        k.a(this.a, false);
        C0596r.e("Sync", "syncFromServer onFailure statusCode = " + i + "  content = " + b + ", type = " + this.a);
        this.b.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        n a = d.a(this.c, this.a, new String(bArr), arrayList);
        boolean z = false;
        if (a.c()) {
            z = b.a(this.c, arrayList, this.a, 1);
        }
        k.a(this.a, z);
        if (z) {
            BLEService.b(this.c);
        }
        this.b.a = z;
        if (!this.b.a) {
            C0596r.e("Sync", "syncFromServer onSuccess = " + a.c() + ", w.code =" + a.h + ", isSucceeded = " + z + ", type = " + this.a);
        }
    }
}
