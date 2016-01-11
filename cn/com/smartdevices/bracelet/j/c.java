package cn.com.smartdevices.bracelet.j;

import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.h;
import com.xiaomi.e.a;
import org.apache.http.Header;

final class c extends h {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    c(String str, h hVar) {
        this.a = str;
        this.b = hVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("AdvHttpClient", "-----onFailure---------");
        C0596r.d("AdvHttpClient", "url = " + this.a);
        C0596r.d("AdvHttpClient", "res = " + a.b(bArr));
        C0596r.d("AdvHttpClient", "-----onFailure---------");
        this.b.onFailure(i, headerArr, bArr, th);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String str = a.f;
        try {
            str = a.b(bArr);
            a.b(str, this.a);
        } catch (Exception e) {
            C0596r.d("AdvHttpClient", "------onSuccess--------");
            C0596r.d("AdvHttpClient", "url = " + this.a);
            C0596r.d("AdvHttpClient", "res = " + str);
            C0596r.d("AdvHttpClient", "------onSuccess--------");
            C0596r.d("AdvHttpClient", e.toString());
        }
        this.b.onSuccess(i, headerArr, bArr);
    }
}
