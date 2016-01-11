package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;

public class C0701bc extends Fragment {
    private String a;
    private WebView b;
    private ProgressBar c;
    private WebViewClient d = new C0702bd(this);
    private WebChromeClient e = new C0703be(this);

    public static C0701bc a() {
        C0701bc c0701bc = new C0701bc();
        c0701bc.setArguments(new Bundle());
        return c0701bc;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.fragment_webview, null);
        this.a = "http://ota.app-xae.xiaomi.net/help.html";
        this.b = (WebView) inflate.findViewById(l.webview);
        this.c = (ProgressBar) inflate.findViewById(l.webview_progress);
        this.b.setWebViewClient(this.d);
        this.b.setWebChromeClient(this.e);
        this.b.loadUrl(this.a);
        setHasOptionsMenu(true);
        return inflate;
    }
}
