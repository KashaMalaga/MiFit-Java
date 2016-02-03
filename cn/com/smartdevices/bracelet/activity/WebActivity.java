package cn.com.smartdevices.bracelet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.C0151az;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.d.a.a.O;
import com.xiaomi.hm.health.R;
import java.io.IOException;
import java.util.Locale;
import kankan.wheel.widget.a;

public class WebActivity extends SystemBarTintActivity implements OnClickListener {
    private static final boolean CAPTURE_FULL_SCREEN = true;
    private static final long LOAD_PAGE_TIME_OUT = 10000;
    private static final String TAG = "WebActivity";
    private String SHARE_PATH;
    private View mActionBar;
    private WebChromeClient mChromeClient = new F(this);
    private b mConfig = b.h();
    private Context mContext = null;
    private String mLabel;
    private boolean mPageLoaded;
    private View mShare;
    private TextView mWebErrorTip;
    private int mWebType = 1;
    private WebView mWebView = null;
    private ProgressBar mWebViewCenterProgress;
    private View mWebViewContainer;
    private ProgressBar mWebViewProgress;

    public class GameJsObject {
        final /* synthetic */ WebActivity a;

        public GameJsObject(WebActivity webActivity) {
            this.a = webActivity;
        }

        @JavascriptInterface
        public void webCallback(String str, String str2, String str3, String str4) {
            C0596r.e(WebActivity.TAG, "uid:" + str + ",security:" + str2 + ", type = " + str3 + ", data=" + str4);
            if (a.cd.equals(str3)) {
                C0401a.a(this.a, C0401a.eS);
                this.a.finish();
            }
        }
    }

    private Bitmap captureWebView(WebView webView) {
        return captureWebView(webView, 0);
    }

    private Bitmap captureWebView(WebView webView, int i) {
        if (i == 0) {
            i = (int) (webView.getScale() * ((float) webView.getContentHeight()));
        }
        Bitmap createBitmap = Bitmap.createBitmap(webView.getWidth(), i, Config.RGB_565);
        webView.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void loadPages() {
        int intExtra;
        Intent intent = getIntent();
        this.mWebType = intent.getIntExtra(a.d, 1);
        String stringExtra = intent.getStringExtra(a.e);
        String str = a.bU;
        str = Locale.getDefault().toString().startsWith(Locale.SIMPLIFIED_CHINESE.toString()) ? a.bV : Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString()) ? "&_locale=en" : Locale.TRADITIONAL_CHINESE.equals(Locale.getDefault()) ? "&_locale=zh_TW" : a.bU;
        if (this.mWebType == 0) {
            WebView webView = this.mWebView;
            StringBuilder stringBuilder = new StringBuilder();
            this.mConfig.b.getClass();
            webView.loadUrl(stringBuilder.append("https://account.xiaomi.com/pass/wap/register?qs=callback%3Dhttps%253A%252F%252Faccount.xiaomi.com%252Fsts%253Fsign%253D8VUxGitrfXxS7XlgXfr7V0uceQc%25253D%2526followup%253Dhttps%25253A%25252F%25252Faccount.xiaomi.com%25252Foauth2%25252Fauthorize%25253Fskip_confirm%25253Dfalse%252526client_id%25253D2882303761517154077%252526redirect_uri%25253Dhttps%2525253A%2525252F%2525252Fhm.xiaomi.com%2525252Fhuami.health.loginview.do%252526response_type%25253Dcode%2526sid%253Doauth2.0%26sid%3Doauth2.0%26_customDisplay%3D0%26mini%3Dtrue%26lsrp_appName%3D%25E4%25BD%25BF%25E7%2594%25A8%25E4%25BD%25A0%25E7%259A%2584%25E5%25B0%258F%25E7%25B1%25B3%25E5%25B8%2590%25E5%258F%25B7%25E8%25AE%25BF%25E9%2597%25AE%2524%257B%25E5%25B0%258F%25E7%25B1%25B3%25E6%2589%258B%25E7%258E%25AF%257D%2524%26_ssign%3DrBm1F4Qu%252F%252FE074tgruygkG18tX0%253D").append(str).toString());
            stringExtra = TAG;
            stringBuilder = new StringBuilder().append("url = ");
            this.mConfig.b.getClass();
            C0596r.e(stringExtra, stringBuilder.append("https://account.xiaomi.com/pass/wap/register?qs=callback%3Dhttps%253A%252F%252Faccount.xiaomi.com%252Fsts%253Fsign%253D8VUxGitrfXxS7XlgXfr7V0uceQc%25253D%2526followup%253Dhttps%25253A%25252F%25252Faccount.xiaomi.com%25252Foauth2%25252Fauthorize%25253Fskip_confirm%25253Dfalse%252526client_id%25253D2882303761517154077%252526redirect_uri%25253Dhttps%2525253A%2525252F%2525252Fhm.xiaomi.com%2525252Fhuami.health.loginview.do%252526response_type%25253Dcode%2526sid%253Doauth2.0%26sid%3Doauth2.0%26_customDisplay%3D0%26mini%3Dtrue%26lsrp_appName%3D%25E4%25BD%25BF%25E7%2594%25A8%25E4%25BD%25A0%25E7%259A%2584%25E5%25B0%258F%25E7%25B1%25B3%25E5%25B8%2590%25E5%258F%25B7%25E8%25AE%25BF%25E9%2597%25AE%2524%257B%25E5%25B0%258F%25E7%25B1%25B3%25E6%2589%258B%25E7%258E%25AF%257D%2524%26_ssign%3DrBm1F4Qu%252F%252FE074tgruygkG18tX0%253D").append(str).toString());
            this.mWebView.addJavascriptInterface(new G(this), C0401a.cc);
        } else if (this.mWebType == 1) {
            WebView webView2 = this.mWebView;
            this.mConfig.b.getClass();
            webView2.loadUrl("https://hm.xiaomi.com/huami.health.login.json");
            this.mWebView.addJavascriptInterface(new G(this), C0401a.cc);
        } else if (this.mWebType == 2) {
            if (stringExtra.startsWith("file://")) {
                WebSettings settings = this.mWebView.getSettings();
                settings.setUseWideViewPort(CAPTURE_FULL_SCREEN);
                settings.setLoadWithOverviewMode(CAPTURE_FULL_SCREEN);
            }
            intExtra = intent.getIntExtra(a.f, getResources().getColor(R.color.bg_color_blue));
            C0596r.e(TAG, "actionBarColor = " + intExtra);
            intExtra |= C0151az.s;
            this.mActionBar.setBackgroundColor(intExtra);
            findViewById(R.id.webview_padding).setBackgroundColor(intExtra);
            if (intent.getIntExtra(a.g, 0) > 0) {
                this.mShare.setVisibility(0);
            }
            if (intent.getIntExtra(a.h, 0) == 1) {
                C0401a.a((Context) this, C0401a.eR);
            }
            this.mWebView.addJavascriptInterface(new GameJsObject(this), "game");
            C0596r.e(TAG, " url = " + stringExtra);
            this.mWebView.loadUrl(stringExtra);
        } else if (this.mWebType == 3) {
            str = stringExtra + "?" + str;
            C0596r.e(TAG, "url ====" + str);
            this.mWebView.loadUrl(str);
        } else if (this.mWebType == 4) {
            new Thread(new D(this, stringExtra)).start();
        }
        intExtra = intent.getIntExtra(Constant.aS, 0);
        if (intExtra != 0) {
            this.mLabel = getString(intExtra);
        }
        if (!TextUtils.isEmpty(this.mLabel)) {
            this.mHomeBack.setText(this.mLabel);
        }
    }

    private String processExtras(String str) {
        LoginData f = cn.com.smartdevices.bracelet.e.a.f(this.mContext);
        O o = new O();
        o.a(g.f, com.xiaomi.e.a.f + f.uid);
        o.a(a.o, f.security);
        String str2 = str + ("?" + o.toString());
        C0596r.e(TAG, "url = " + str2);
        return str2;
    }

    private void setupViews() {
        this.mShare = findViewById(R.id.share);
        this.mActionBar = findViewById(R.id.action_bar);
        this.mWebView = (WebView) findViewById(R.id.webview);
        this.mWebErrorTip = (TextView) findViewById(R.id.web_error_tip);
        this.mWebViewContainer = findViewById(R.id.webview_container);
        this.mWebViewCenterProgress = (ProgressBar) findViewById(R.id.progress_bar);
        this.mShare.setOnClickListener(this);
        this.mWebView.getSettings().setJavaScriptEnabled(CAPTURE_FULL_SCREEN);
        this.mWebViewProgress = (ProgressBar) findViewById(R.id.webview_progress);
        this.mWebView.setLayerType(1, null);
        this.mWebView.setWebViewClient(new B(this));
        this.mWebView.setWebChromeClient(this.mChromeClient);
        this.mWebErrorTip.setOnClickListener(new C(this));
    }

    private void share() {
        Bitmap decodeStream;
        Exception e;
        Bitmap bitmap = null;
        C0596r.e(TAG, "Start Share!!");
        if (getIntent() != null) {
            String str;
            int intExtra = getIntent().getIntExtra(a.h, 0);
            if (intExtra == 1) {
                try {
                    decodeStream = BitmapFactory.decodeStream(getAssets().open("event_national_day_signup_share.jpg"));
                } catch (IOException e2) {
                    e2.printStackTrace();
                    decodeStream = bitmap;
                }
            } else {
                try {
                    decodeStream = captureWebView(this.mWebView);
                    try {
                        bitmap = captureWebView(this.mWebView, this.mWebView.getHeight());
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + a.cc;
                        if (decodeStream != null) {
                            return;
                        }
                        return;
                    }
                } catch (Exception e4) {
                    e = e4;
                    decodeStream = bitmap;
                    e.printStackTrace();
                    str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + a.cc;
                    if (decodeStream != null) {
                        return;
                    }
                    return;
                }
            }
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + a.cc;
            if (decodeStream != null && Utils.a(this.SHARE_PATH, decodeStream, 85) && r0 != null && Utils.a(str, r0, 75)) {
                Intent intent = getIntent();
                intent.setClass(this, ShareActivity.class);
                intent.putExtra(a.ca, this.SHARE_PATH);
                intent.putExtra("SharePreviewPath", str);
                intent.putExtra(a.h, intExtra);
                Parcelable shareData = new ShareData();
                shareData.setType(11);
                intent.putExtra("share_data", shareData);
                startActivity(intent);
            }
        }
    }

    protected boolean isExceptForMiNote() {
        return CAPTURE_FULL_SCREEN;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.share:
                share();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.fragment_webview);
        this.mContext = getApplicationContext();
        setupViews();
        loadPages();
        this.SHARE_PATH = Utils.a((Context) this);
        new Handler().postDelayed(new A(this), LOAD_PAGE_TIME_OUT);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        C0596r.e(TAG, "can go back:" + this.mWebView.canGoBack() + ", " + this.mWebView.copyBackForwardList());
        if (i != 4 || !this.mWebView.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebView.goBack();
        return CAPTURE_FULL_SCREEN;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return CAPTURE_FULL_SCREEN;
    }

    protected void onPause() {
        super.onPause();
        String str = "PageWeb";
        switch (this.mWebType) {
            case a.i /*0*/:
                str = C0401a.o;
                break;
            case a.k /*2*/:
                if (getString(R.string.user_agreement).equals(this.mLabel)) {
                    str = C0401a.p;
                    break;
                }
                break;
        }
        C0401a.b(str);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        String str = "PageWeb";
        switch (this.mWebType) {
            case a.i /*0*/:
                str = C0401a.o;
                break;
            case a.k /*2*/:
                if (getString(R.string.user_agreement).equals(this.mLabel)) {
                    str = C0401a.p;
                    break;
                }
                break;
        }
        C0401a.a(str);
        C0401a.a((Activity) this);
    }
}
