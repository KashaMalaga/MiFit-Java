package cn.com.smartdevices.bracelet.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;

class C0402a extends WebViewClient {
    final /* synthetic */ AdvClickTargetActivity a;

    C0402a(AdvClickTargetActivity advClickTargetActivity) {
        this.a = advClickTargetActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        this.a.f.setVisibility(8);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.a.f.setVisibility(0);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.a.f.setVisibility(8);
        this.a.e.setBackgroundColor(this.a.getResources().getColor(R.color.bg_color_white));
        b.a(this.a.c, (int) R.string.no_network_connection, 1).show();
        super.onReceivedError(webView, i, str, str2);
    }
}
