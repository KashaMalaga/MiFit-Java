package cn.com.smartdevices.bracelet.activity;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class C0403b extends WebChromeClient {
    final /* synthetic */ AdvClickTargetActivity a;

    C0403b(AdvClickTargetActivity advClickTargetActivity) {
        this.a = advClickTargetActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.a.f.setProgress(i + 5);
    }
}
