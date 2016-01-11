package com.xiaomi.account.openauth;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class C1067a extends WebViewClient {
    final /* synthetic */ AuthorizeActivity a;

    C1067a(AuthorizeActivity authorizeActivity) {
        this.a = authorizeActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = new String(str);
        int indexOf = str2.indexOf(63);
        String substring;
        if (indexOf > 0) {
            substring = str2.substring(indexOf + 1);
            if (substring.startsWith("code=") || substring.contains("&code=")) {
                this.a.a(AuthorizeActivity.a, str2);
                return true;
            } else if (substring.startsWith("error=") || substring.contains("&error=")) {
                this.a.a(AuthorizeActivity.b, str2);
                return true;
            }
        }
        indexOf = str2.indexOf(35);
        if (indexOf > 0) {
            substring = str2.substring(indexOf + 1);
            if (substring.startsWith("access_token=") || substring.contains("&access_token=")) {
                this.a.a(AuthorizeActivity.a, str2.replace("#", "?"));
                return true;
            } else if (substring.startsWith("error=") || substring.contains("&error=")) {
                this.a.a(AuthorizeActivity.b, str2.replace("#", "?"));
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
