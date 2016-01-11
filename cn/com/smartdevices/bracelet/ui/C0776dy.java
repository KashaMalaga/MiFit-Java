package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import org.apache.http.Header;

class C0776dy extends h {
    final /* synthetic */ SearchWeightScaleActivity a;

    C0776dy(SearchWeightScaleActivity searchWeightScaleActivity) {
        this.a = searchWeightScaleActivity;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        Keeper.setSyncWeightInfoToServer(1);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr != null) {
            String str = new String(bArr);
            C0596r.e("search weight", "updateBindedWeightInfo result:" + str);
            if (n.a(this.a.getApplicationContext(), str).c()) {
                Keeper.setSyncWeightInfoToServer(2);
            }
        }
    }
}
