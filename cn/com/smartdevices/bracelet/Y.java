package cn.com.smartdevices.bracelet;

import com.d.a.a.h;
import org.apache.http.Header;

final class Y extends h {
    Y() {
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.e("Utils", "updateLazyDay2Server onSuccess: " + new String(bArr));
    }
}
