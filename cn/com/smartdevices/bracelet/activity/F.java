package cn.com.smartdevices.bracelet.activity;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class F extends WebChromeClient {
    final /* synthetic */ WebActivity a;

    F(WebActivity webActivity) {
        this.a = webActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.a.mWebViewProgress.setProgress(i + 5);
    }
}
