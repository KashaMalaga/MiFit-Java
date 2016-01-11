package cn.com.smartdevices.bracelet.lab.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import java.util.ArrayList;
import org.apache.http.Header;

final class f extends h {
    final /* synthetic */ h a;
    final /* synthetic */ Context b;
    final /* synthetic */ C0595q c;
    final /* synthetic */ C0591m d;
    final /* synthetic */ ArrayList e;

    f(h hVar, Context context, C0595q c0595q, C0591m c0591m, ArrayList arrayList) {
        this.a = hVar;
        this.b = context;
        this.c = c0595q;
        this.d = c0591m;
        this.e = arrayList;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e("Sync", "syncToServer onFailure:" + Utils.b(bArr));
        this.a.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        n a = n.a(this.b, b);
        C0596r.e("Sync", "syncToServer onSuccess:" + b + "  type = " + this.c.b() + " code = " + a.h);
        if (a.c()) {
            this.a.a = this.d.b(this.e, 1, this.c);
            return;
        }
        this.a.a = false;
    }
}
