package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.location.e;
import com.sina.weibo.sdk.utils.LogUtil;
import com.xiaomi.channel.b.v;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

public abstract class CustomRedirectHandler implements RedirectHandler {
    private static final int MAX_REDIRECT_COUNT = 15;
    private static final String TAG = CustomRedirectHandler.class.getCanonicalName();
    int redirectCount;
    String redirectUrl;
    private String tempRedirectUrl;

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
        LogUtil.d(TAG, "CustomRedirectHandler getLocationURI getRedirectUrl : " + this.tempRedirectUrl);
        return !TextUtils.isEmpty(this.tempRedirectUrl) ? URI.create(this.tempRedirectUrl) : null;
    }

    public int getRedirectCount() {
        return this.redirectCount;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 301 || statusCode == 302) {
            this.tempRedirectUrl = httpResponse.getFirstHeader(e.e).getValue();
            if (!TextUtils.isEmpty(this.tempRedirectUrl) && this.redirectCount < MAX_REDIRECT_COUNT && shouldRedirectUrl(this.tempRedirectUrl)) {
                this.redirectCount++;
                return true;
            }
        } else if (statusCode == v.C) {
            this.redirectUrl = this.tempRedirectUrl;
        } else {
            onReceivedException();
        }
        return false;
    }

    public abstract void onReceivedException();

    public abstract boolean shouldRedirectUrl(String str);
}
