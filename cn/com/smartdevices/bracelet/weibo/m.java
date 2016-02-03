package cn.com.smartdevices.bracelet.weibo;

import android.os.Bundle;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.hm.health.R;

class m implements Runnable {
    final /* synthetic */ Bundle a;
    final /* synthetic */ l b;

    m(l lVar, Bundle bundle) {
        this.b = lVar;
        this.a = bundle;
    }

    public void run() {
        this.b.a.r = this.b.a.j.a(this.a);
        C0596r.d("BindWeiboHealthActivity", "parseAccessToken return = " + this.b.a.r.toString());
        if (this.b.a.r.isSessionValid()) {
            this.b.b = new t(this.b.a, com.huami.android.widget.share.m.l, this.b.a.r);
            this.b.b.a(Long.parseLong(this.b.a.r.uid), this.b.a.t);
            return;
        }
        String string = this.a.getString(b.a);
        String string2 = this.b.a.getString(R.string.weibosdk_toast_auth_failed);
        if (!TextUtils.isEmpty(string)) {
            string2 = string2 + "\nObtained the code: " + string;
        }
        C0401a.a(this.b.a, C0401a.aH);
        this.b.a.a(string2);
        this.b.a.a(true);
        C0596r.e("BindWeiboHealthActivity", "return[ error code " + string + " session invalid]");
    }
}
