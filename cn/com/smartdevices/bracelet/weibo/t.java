package cn.com.smartdevices.bracelet.weibo;

import android.content.Context;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.tencent.connect.common.Constants;
import com.xiaomi.mipush.sdk.f;
import kankan.wheel.widget.a;

public class t extends C0854a {
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final String k = "https://api.weibo.com/2/users";
    private static final SparseArray<String> l = new SparseArray();

    static {
        l.put(h, "https://api.weibo.com/2/users/show.json");
        l.put(i, "https://api.weibo.com/2/users/domain_show.json");
        l.put(j, "https://api.weibo.com/2/users/counts.json");
    }

    public t(Context context, String str, ThirdLoginState thirdLoginState) {
        super(context, str, thirdLoginState);
    }

    private WeiboParameters b(long[] jArr) {
        WeiboParameters weiboParameters = new WeiboParameters(this.g);
        StringBuilder stringBuilder = new StringBuilder();
        int length = jArr.length;
        for (int i = h; i < length; i += i) {
            stringBuilder.append(jArr[i]).append(f.i);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        weiboParameters.put("uids", stringBuilder.toString());
        return weiboParameters;
    }

    public String a(long j) {
        WeiboParameters weiboParameters = new WeiboParameters(this.g);
        weiboParameters.put(a.n, j);
        return a((String) l.get(h), weiboParameters, Constants.HTTP_GET);
    }

    public String a(String str) {
        WeiboParameters weiboParameters = new WeiboParameters(this.g);
        weiboParameters.put("screen_name", str);
        return a((String) l.get(h), weiboParameters, Constants.HTTP_GET);
    }

    public String a(long[] jArr) {
        return a((String) l.get(j), b(jArr), Constants.HTTP_GET);
    }

    public void a(long j, RequestListener requestListener) {
        WeiboParameters weiboParameters = new WeiboParameters(this.g);
        weiboParameters.put(a.n, j);
        a((String) l.get(h), weiboParameters, Constants.HTTP_GET, requestListener);
    }

    public void a(String str, RequestListener requestListener) {
        WeiboParameters weiboParameters = new WeiboParameters(this.g);
        weiboParameters.put("screen_name", str);
        a((String) l.get(h), weiboParameters, Constants.HTTP_GET, requestListener);
    }

    public void a(long[] jArr, RequestListener requestListener) {
        a((String) l.get(j), b(jArr), Constants.HTTP_GET, requestListener);
    }

    public String b(String str) {
        WeiboParameters weiboParameters = new WeiboParameters(this.g);
        weiboParameters.put("domain", str);
        return a((String) l.get(i), weiboParameters, Constants.HTTP_GET);
    }

    public void b(String str, RequestListener requestListener) {
        WeiboParameters weiboParameters = new WeiboParameters(this.g);
        weiboParameters.put("domain", str);
        a((String) l.get(i), weiboParameters, Constants.HTTP_GET, requestListener);
    }
}
