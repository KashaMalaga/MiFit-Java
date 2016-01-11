package cn.com.smartdevices.bracelet.weibo;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.xiaomi.e.a;

public abstract class C0854a {
    protected static final String a = "https://api.weibo.com/2";
    protected static final String b = "POST";
    protected static final String c = "GET";
    protected static final String d = "access_token";
    private static final String h = C0854a.class.getName();
    protected ThirdLoginState e;
    protected Context f;
    protected String g;

    public C0854a(Context context, String str, ThirdLoginState thirdLoginState) {
        this.f = context;
        this.g = str;
        this.e = thirdLoginState;
    }

    public ThirdLoginState a() {
        return this.e;
    }

    protected String a(String str, WeiboParameters weiboParameters, String str2) {
        if (this.e == null || TextUtils.isEmpty(str) || weiboParameters == null || TextUtils.isEmpty(str2)) {
            LogUtil.e(h, "Argument error!");
            return a.f;
        }
        weiboParameters.put(d, this.e.accessToken);
        return new AsyncWeiboRunner(this.f).request(str, weiboParameters, str2);
    }

    protected void a(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        if (this.e == null || TextUtils.isEmpty(str) || weiboParameters == null || TextUtils.isEmpty(str2) || requestListener == null) {
            LogUtil.e(h, "Argument error!");
            return;
        }
        weiboParameters.put(d, this.e.accessToken);
        new AsyncWeiboRunner(this.f).requestAsync(str, weiboParameters, str2, requestListener);
    }
}
