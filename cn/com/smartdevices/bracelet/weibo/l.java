package cn.com.smartdevices.bracelet.weibo;

import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.xiaomi.hm.health.R;

class l implements WeiboAuthListener {
    final /* synthetic */ BindHealthActivity a;
    private t b;

    l(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void onCancel() {
        this.a.a(true);
        this.a.c((int) R.string.weibosdk_toast_auth_canceled);
        C0401a.a(this.a, C0401a.aI);
    }

    public void onComplete(Bundle bundle) {
        C0596r.d("BindWeiboHealthActivity", "AuthListener onComplete -- ");
        new Thread(new m(this, bundle)).start();
    }

    public void onWeiboException(WeiboException weiboException) {
        this.a.a(true);
        this.a.c((int) R.string.weibosdk_toast_auth_canceled_f);
        C0401a.a(this.a, C0401a.aH);
    }
}
