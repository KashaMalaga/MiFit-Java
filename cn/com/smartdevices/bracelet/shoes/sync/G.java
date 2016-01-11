package cn.com.smartdevices.bracelet.shoes.sync;

import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import org.apache.http.Header;

final class G extends h {
    final /* synthetic */ H a;

    G(H h) {
        this.a = h;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.e(B.a, "onFailure statusCode:" + i + ",content:" + S.a(bArr) + ",type shoes" + ",error:" + th);
        this.a.a(false);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
    }
}
