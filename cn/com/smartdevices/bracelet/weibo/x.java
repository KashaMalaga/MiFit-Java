package cn.com.smartdevices.bracelet.weibo;

import cn.com.smartdevices.bracelet.C0596r;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

class x implements RequestListener {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public void onComplete(String str) {
        new Thread(new y(this, str)).start();
    }

    public void onWeiboException(WeiboException weiboException) {
        C0596r.e("WeiboHealthManager", "refresh token exception " + weiboException);
    }
}
