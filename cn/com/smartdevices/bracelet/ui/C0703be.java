package cn.com.smartdevices.bracelet.ui;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

class C0703be extends WebChromeClient {
    final /* synthetic */ C0701bc a;

    C0703be(C0701bc c0701bc) {
        this.a = c0701bc;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.a.c.setProgress(i + 5);
    }
}
