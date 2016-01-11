package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import com.d.a.a.h;
import org.apache.http.Header;

class cN extends h {
    final /* synthetic */ cL a;

    cN(cL cLVar) {
        this.a = cLVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        C0596r.d("PersonInfoFragment", "logout onFailed: status= " + i + Utils.b(bArr));
        Utils.a(this.a.getActivity());
        this.a.x();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        C0596r.d("PersonInfoFragment", "loginOut:" + Utils.b(bArr));
        new Handler().postDelayed(new cO(this), 1);
    }
}
