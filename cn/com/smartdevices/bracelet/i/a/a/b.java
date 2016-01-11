package cn.com.smartdevices.bracelet.i.a.a;

import cn.com.smartdevices.bracelet.i.a;
import com.d.a.a.h;
import org.apache.http.Header;

class b extends h {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    b(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (bArr != null) {
            this.a.a = new String(bArr);
        }
        this.b.exception(new a(4, this.a.a, th));
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            this.a.a = new String(bArr);
        }
    }
}
