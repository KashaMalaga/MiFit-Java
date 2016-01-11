package com.xiaomi.account.openauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.connect.common.Constants;
import com.xiaomi.account.XiaomiOAuthResponse;
import com.xiaomi.account.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizeActivity extends Activity {
    public static int a = -1;
    public static int b = 1;
    public static int c = 0;
    private static final String d = "_locale";
    private static final String e = "extra_my_intent";
    private static final String f = "extra_my_bundle";
    private static final String g = "extra_response";
    private static final String h = "extra_result_code";
    private static final String i = "extra_keep_cookies ";
    private static final String j = (c.b + "/oauth2/authorize");
    private static final String k = "UTF-8";
    private static final int q = 1001;
    private WebView l;
    private WebSettings m;
    private String n;
    private boolean o = false;
    private XiaomiOAuthResponse p;

    public static Intent a(Activity activity, int i, Bundle bundle) {
        Intent intent = new Intent(activity, AuthorizeActivity.class);
        intent.putExtra(f, bundle);
        intent.putExtra(h, i);
        return intent;
    }

    public static Intent a(Activity activity, Intent intent, a aVar) {
        Intent intent2 = new Intent(activity, AuthorizeActivity.class);
        intent2.putExtra(e, intent);
        intent2.putExtra(g, new XiaomiOAuthResponse(aVar));
        return intent2;
    }

    public static Intent a(Activity activity, String str, String str2, String str3, String str4, String str5, Boolean bool, boolean z, a aVar) {
        Intent intent = new Intent(activity, AuthorizeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PARAM_CLIENT_ID, String.valueOf(str));
        bundle.putString(WBConstants.AUTH_PARAMS_REDIRECT_URL, str2);
        bundle.putString(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, str3);
        bundle.putString(h.M, str4);
        bundle.putString(h.N, str5);
        if (bool != null) {
            bundle.putString("skip_confirm", String.valueOf(bool));
        }
        intent.putExtra("url_param", bundle);
        intent.putExtra(i, z);
        intent.putExtra(g, new XiaomiOAuthResponse(aVar));
        return intent;
    }

    private Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), k)) {
                    if (!(TextUtils.isEmpty(nameValuePair.getName()) || TextUtils.isEmpty(nameValuePair.getValue()))) {
                        bundle.putString(nameValuePair.getName(), nameValuePair.getValue());
                    }
                }
            } catch (URISyntaxException e) {
                Log.e("openauth", e.getMessage());
            }
        }
        return bundle;
    }

    private View a() {
        View linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        this.l = new WebView(this);
        linearLayout.addView(this.l, new LayoutParams(-1, -1));
        return linearLayout;
    }

    private String a(Bundle bundle) {
        if (bundle == null) {
            return com.xiaomi.e.a.f;
        }
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object string = bundle.getString(str);
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(string))) {
                arrayList.add(new BasicNameValuePair(str, string));
            }
        }
        return URLEncodedUtils.format(arrayList, k);
    }

    private static String a(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(locale.getCountry())) {
            return language;
        }
        return String.format("%s_%s", new Object[]{language, locale.getCountry()});
    }

    private Bundle b(Bundle bundle) {
        if (!(bundle == null || bundle.containsKey(d))) {
            Object a = a(Locale.getDefault());
            if (!TextUtils.isEmpty(a)) {
                bundle.putString(d, a);
            }
        }
        return bundle;
    }

    private void b() {
        if (!this.o) {
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    void a(int i, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        setResult(i, intent);
        if (this.p != null) {
            if (i == 0) {
                this.p.a();
            } else {
                this.p.a(bundle);
            }
        }
        b();
        finish();
    }

    void a(int i, String str) {
        a(i, a(str));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == q) {
            a(i2, intent != null ? intent.getExtras() : null);
        }
    }

    public void onBackPressed() {
        if (this.l.canGoBack()) {
            this.l.goBack();
        } else {
            a(c, (Bundle) null);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Bundle bundleExtra = intent.getBundleExtra(f);
        if (bundleExtra != null) {
            a(intent.getIntExtra(h, -1), bundleExtra);
            return;
        }
        this.p = (XiaomiOAuthResponse) intent.getParcelableExtra(g);
        Intent intent2 = (Intent) intent.getParcelableExtra(e);
        if (intent2 != null) {
            startActivityForResult(intent2, q);
            return;
        }
        this.o = intent.getBooleanExtra(i, false);
        setContentView(a());
        this.m = this.l.getSettings();
        this.m.setJavaScriptEnabled(true);
        this.m.setSavePassword(false);
        this.m.setSaveFormData(false);
        this.n = j + "?" + a(b(intent.getBundleExtra("url_param")));
        b();
        this.l.loadUrl(this.n);
        this.l.setWebViewClient(new C1067a(this));
    }
}
