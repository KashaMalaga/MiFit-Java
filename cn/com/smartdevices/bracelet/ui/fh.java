package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import com.d.a.a.h;
import com.xiaomi.mipush.sdk.f;
import org.apache.http.Header;

class fh extends h {
    final /* synthetic */ UnBindActivity a;

    fh(UnBindActivity unBindActivity) {
        this.a = unBindActivity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("switch", "onFailure:" + i + f.i + Utils.b(bArr));
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.d("switch", "onSuccess:" + i + f.i + Utils.b(bArr));
    }
}
