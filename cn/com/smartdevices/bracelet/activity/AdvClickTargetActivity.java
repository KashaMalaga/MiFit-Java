package cn.com.smartdevices.bracelet.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.huami.android.view.b;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.R;

public class AdvClickTargetActivity extends SystemBarTintActivity {
    private static final String g = "AdvClickTargetActivity";
    private String a;
    private String b;
    private Context c;
    private TextView d;
    private WebView e = null;
    private ProgressBar f = null;
    private WebViewClient h = new C0402a(this);
    private WebChromeClient i = new C0403b(this);

    private void a() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.a = intent.getStringExtra(SocialConstants.PARAM_URL);
        if (this.a.indexOf("http") != 0) {
            C0596r.d(g, "before url = " + this.a);
            this.a = "http://" + this.a;
            C0596r.d(g, "after url = " + this.a);
        }
        this.b = intent.getStringExtra(SocialConstants.PARAM_TITLE);
    }

    private void b() {
        this.d = (TextView) findViewById(R.id.title_tv);
        this.d.setText(this.b);
        if (C.a(this.c)) {
            this.e = (WebView) findViewById(R.id.webview);
            this.f = (ProgressBar) findViewById(R.id.webview_progress);
            this.e.getSettings().setJavaScriptEnabled(true);
            this.e.setWebViewClient(this.h);
            this.e.setWebChromeClient(this.i);
            this.e.loadUrl(this.a);
            return;
        }
        b.a(this.c, (int) R.string.no_network_connection, 1).show();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_click_startup);
        this.c = getApplicationContext();
        a();
        b();
    }
}
