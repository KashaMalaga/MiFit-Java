package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import org.apache.http.Header;

final class y extends h {
    final /* synthetic */ z a;
    final /* synthetic */ Context b;
    final /* synthetic */ int c;

    y(z zVar, Context context, int i) {
        this.a = zVar;
        this.b = context;
        this.c = i;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(B.a, "onFailure statusCode:" + i + ",content:" + S.a(bArr) + ",type shoes");
        this.a.c = false;
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        boolean c = C0642s.a(this.b, this.c, new String(bArr), this.a).c();
        this.a.c = c;
        if (!this.a.c) {
            C0596r.d(B.a, "onSuccess isSucceeded:" + c + ",type:" + this.c);
        }
    }
}
