package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.gps.c.a.s;
import com.d.a.a.h;
import org.apache.http.Header;

final class C0486t extends h {
    final /* synthetic */ C0480n a;
    final /* synthetic */ Context b;

    C0486t(C0480n c0480n, Context context) {
        this.a = c0480n;
        this.b = context;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        R.a(bArr);
        this.a.a = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        T t = new T();
        boolean c = C0476i.a(this.b, new String(bArr), t).c();
        if (c && t.a != null) {
            c &= s.a().a(this.b, t.a);
        }
        this.a.a = c;
    }
}
