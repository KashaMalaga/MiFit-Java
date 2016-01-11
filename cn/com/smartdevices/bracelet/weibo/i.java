package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

class i implements RequestListener {
    final /* synthetic */ BindHealthActivity a;

    i(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void onComplete(String str) {
        C0596r.e("BindWeiboHealthActivity", "Get Weibo Response:\n" + str);
        new Thread(new j(this, str)).start();
    }

    public void onWeiboException(WeiboException weiboException) {
        weiboException.printStackTrace();
        C0596r.d("BindWeiboHealthActivity", "Get OpenAPI for user error");
        C0401a.a(this.a, C0401a.aH);
        this.a.a(true);
    }
}
