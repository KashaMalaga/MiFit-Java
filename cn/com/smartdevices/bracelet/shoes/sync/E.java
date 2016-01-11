package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.n;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.a;
import com.d.a.a.h;
import org.apache.http.Header;

final class E extends h {
    final /* synthetic */ cn.com.smartdevices.bracelet.shoes.sync.b.h a;
    final /* synthetic */ Context b;
    final /* synthetic */ a c;

    E(cn.com.smartdevices.bracelet.shoes.sync.b.h hVar, Context context, a aVar) {
        this.a = hVar;
        this.b = context;
        this.c = aVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        String a = S.a(bArr);
        this.a.a(false);
        C0596r.e(B.a, "onFailure content:" + a + ", statusCode = " + i + ",error:" + th);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        n a = n.a(this.b, S.a(bArr));
        boolean c = a.c();
        C0596r.e(B.a, "onSuccess: code = " + a.h + ",success = " + c);
        if (c) {
            c &= t.i(this.b, this.c.g());
        }
        this.a.a(c);
        if (!this.a.b()) {
            C0596r.d(B.a, "setMyShoesSyncedToState isSucceeded = " + c);
        }
    }
}
