package cn.com.smartdevices.bracelet.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.com.smartdevices.bracelet.C0596r;

class B extends WebViewClient {
    final /* synthetic */ WebActivity a;

    B(WebActivity webActivity) {
        this.a = webActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        this.a.mWebViewProgress.setVisibility(4);
        this.a.mWebViewCenterProgress.setVisibility(4);
        this.a.mPageLoaded = true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.a.mWebViewProgress.setVisibility(0);
        this.a.mWebErrorTip.setVisibility(8);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        C0596r.e("WebActivity", "LoadError : " + i + ", " + str);
        if (i == -2) {
            this.a.mWebErrorTip.setVisibility(0);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
