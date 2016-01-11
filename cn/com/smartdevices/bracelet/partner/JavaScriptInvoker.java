package cn.com.smartdevices.bracelet.partner;

import android.webkit.WebView;

public class JavaScriptInvoker {
    private WebView mWebView;

    public JavaScriptInvoker(WebView webView) {
        this.mWebView = webView;
    }

    public void onRightButtonClick(String str) {
        this.mWebView.loadUrl("javascript:unbind('" + str + "');");
    }

    public void setCheckAppInstallResult(String str, boolean z) {
        this.mWebView.loadUrl("javascript:onCheckAppInstalled('" + str + "'," + z + ");");
    }
}
