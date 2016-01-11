package com.g.a;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class g {
    private Context a;

    public g(Context context, WebView webView) {
        this.a = context;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new h(this, null));
    }

    public g(Context context, WebView webView, WebChromeClient webChromeClient) {
        this.a = context;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new h(this, webChromeClient));
    }
}
