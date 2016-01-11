package cn.com.smartdevices.bracelet.j;

import cn.com.smartdevices.bracelet.C0596r;
import com.d.a.a.Y;
import org.apache.http.Header;

final class b extends Y {
    final /* synthetic */ String a;
    final /* synthetic */ Y b;

    b(String str, Y y) {
        this.a = str;
        this.b = y;
    }

    public void onFailure(int i, Header[] headerArr, String str, Throwable th) {
        C0596r.d("AdvHttpClient", "-----onFailure---------");
        C0596r.d("AdvHttpClient", "url = " + this.a);
        C0596r.d("AdvHttpClient", "res = " + str);
        C0596r.d("AdvHttpClient", "-----onFailure---------");
        this.b.onFailure(i, headerArr, str, th);
    }

    public void onSuccess(int i, Header[] headerArr, String str) {
        a.b(str, this.a);
        C0596r.e("AdvHttpClient", "-----onSuccess---------");
        C0596r.e("AdvHttpClient", "url = " + this.a);
        C0596r.e("AdvHttpClient", "res = " + str);
        C0596r.e("AdvHttpClient", "-----onSuccess---------");
        this.b.onSuccess(i, headerArr, str);
    }
}
