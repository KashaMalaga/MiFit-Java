package cn.com.smartdevices.bracelet.ui;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class C0702bd extends WebViewClient {
    final /* synthetic */ C0701bc a;

    C0702bd(C0701bc c0701bc) {
        this.a = c0701bc;
    }

    public void onPageFinished(WebView webView, String str) {
        this.a.c.setVisibility(4);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.a.c.setVisibility(0);
    }
}
