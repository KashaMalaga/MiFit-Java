package cn.com.smartdevices.bracelet;

import com.d.a.a.h;
import org.apache.http.Header;

final class T extends h {
    final /* synthetic */ int a;

    T(int i) {
        this.a = i;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("Utils", "postActiveHistory onFailure , tag = " + this.a);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            C0596r.d("Utils", "postActiveHistory response = " + new String(bArr) + " , tag = " + this.a);
            return;
        }
        C0596r.d("Utils", "postActiveHistory response = null , tag = " + this.a);
    }
}
