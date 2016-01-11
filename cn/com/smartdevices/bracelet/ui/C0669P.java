package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.m;
import com.d.a.a.h;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbiz.JumpToBizProfile.Req;
import org.apache.http.Header;

class C0669P extends h {
    final /* synthetic */ BindWeixinActivityNew a;

    C0669P(BindWeixinActivityNew bindWeixinActivityNew) {
        this.a = bindWeixinActivityNew;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        this.a.d();
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            this.a.d();
            return;
        }
        String a = m.a(this.a.getApplicationContext(), new String(bArr));
        if (a != null) {
            C0596r.e("BindWeixinActivityNew", "getWXAppSupportAPI:" + this.a.k.getWXAppSupportAPI());
            BaseReq req = new Req();
            req.extMsg = a;
            req.profileType = 1;
            req.toUserName = "gh_f65f9f1aa87a";
            if (this.a.k.sendReq(req)) {
                this.a.e();
                return;
            } else {
                this.a.d();
                return;
            }
        }
        this.a.d();
    }
}
