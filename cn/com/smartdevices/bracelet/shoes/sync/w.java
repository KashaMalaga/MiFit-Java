package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

final class w extends h {
    final /* synthetic */ cn.com.smartdevices.bracelet.shoes.sync.b.h a;
    final /* synthetic */ Context b;

    w(cn.com.smartdevices.bracelet.shoes.sync.b.h hVar, Context context) {
        this.a = hVar;
        this.b = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(B.a, "onFailure statusCode = " + i + ",content = " + S.a(bArr) + ",type shoes");
        this.a.a(false);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        n a = n.a(this.b, new String(bArr));
        if (!a.c()) {
            C0596r.d(B.a, "success:" + a.c() + ",statusCode:" + i + ",type shoes");
        }
        this.a.a(a.c());
    }
}
