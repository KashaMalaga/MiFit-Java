package cn.com.smartdevices.bracelet.partner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.a.a;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.eventbus.EventServiceStateChanged;
import cn.com.smartdevices.bracelet.j.g;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import cn.com.smartdevices.bracelet.relation.db.f;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.ui.eH;
import com.huami.android.view.c;
import com.huami.android.widget.share.h;
import com.huami.android.widget.share.l;
import com.huami.android.widget.share.q;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import de.greenrobot.event.EventBus;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.Map;

public class WebActivity extends SystemBarTintActivity implements OnClickListener, NativeInterface {
    private static final String BASE64_FLAG_OF_IMG = "base64,";
    private static final int IMAGEHEIGHT = 800;
    private static final int IMAGEWIDTH = 480;
    private static final String PARTNER_LOG = "PartnerLog";
    static final int REQ_CAMERA = 18;
    static final int REQ_GALLERY = 17;
    private static final String TAG = "ServiceActivity";
    private b config;
    private PartnerDataManager mDataManager;
    private View mErrorLabel;
    private View mErrorView;
    private JavaScriptInvoker mInvoker;
    private ProgressBar mLoadProgress;
    private WebChromeClient mOpenChromeClient = new WebChromeClient() {
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new Builder(WebActivity.this).setTitle(webView.getTitle()).setMessage(str2).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setCancelable(false).create().show();
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        public void onProgressChanged(WebView webView, int i) {
            WebActivity.this.mLoadProgress.setProgress(i + 5);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            WebActivity.this.selectImage(valueCallback);
        }

        public void openFileChooser(ValueCallback valueCallback, String str) {
            WebActivity.this.selectImage(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            WebActivity.this.selectImage(valueCallback);
        }
    };
    private Partner mPartner = null;
    private PartnerSelectImageFragment mPartnerSelectImageFragment;
    private View mProgressBar;
    private String mShareContent;
    private String mShareIcon;
    private String mShareTitle;
    private String mShareTopic;
    private int mShareType;
    private String mShareUrl;
    private boolean mTaskIsRunning = false;
    private View mTitleBar;
    private ImageButton mUnBindButton;
    private ValueCallback<Uri> mUploadMessage;
    private WebView mWebContainer;
    private WebViewClient mWebViewClient = new WebViewClient() {
        private int mErrorCode = 0;

        public void onLoadResource(WebView webView, String str) {
            C0596r.a(WebActivity.TAG, str);
            super.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            WebActivity.this.mLoadProgress.setVisibility(8);
            if (this.mErrorCode < 0) {
                WebActivity.this.mErrorLabel.setVisibility(0);
                WebActivity.this.mWebContainer.setVisibility(8);
                WebActivity.this.mErrorView.setVisibility(0);
                WebActivity.this.mProgressBar.setVisibility(8);
                WebActivity.this.mErrorView.setOnClickListener(WebActivity.this);
                return;
            }
            WebActivity.this.mWebContainer.setVisibility(0);
            WebActivity.this.mUnBindButton.setEnabled(true);
            WebActivity.this.mErrorView.setVisibility(8);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebActivity.this.mLoadProgress.setVisibility(0);
            WebActivity.this.mErrorLabel.setVisibility(4);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.mErrorCode = i;
            WebActivity.this.toast(WebActivity.this.getString(r.no_network_connection));
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i = 0;
            this.mErrorCode = 0;
            Uri parse = Uri.parse(str);
            Object path = parse.getPath();
            Object scheme = parse.getScheme();
            if (scheme != null) {
                scheme = scheme.toLowerCase();
            }
            Intent parseUri;
            if (NativeInterface.APP_SCHEME.equals(scheme) || MiPushMessageReceiver.PUSH_TYPE_INTENT.equals(scheme) || NativeInterface.MARKET_SCHEME.equals(scheme) || NativeInterface.ALIPAYS_SCHEME.equals(scheme)) {
                try {
                    parseUri = Intent.parseUri(str, 0);
                } catch (URISyntaxException e) {
                    parseUri = new Intent("android.intent.action.VIEW", Uri.parse(str));
                }
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.addCategory("android.intent.category.DEFAULT");
                try {
                    WebActivity.this.startActivity(parseUri);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    C0596r.c(e2.getMessage());
                    return true;
                }
            } else if (NativeInterface.BRACELET_SCHEME.equals(scheme)) {
                if (TextUtils.isEmpty(path)) {
                    return true;
                }
                String[] split = path.split("/");
                if (split.length != 2) {
                    return true;
                }
                CharSequence queryParameter = parse.getQueryParameter("finish");
                boolean z = !TextUtils.isEmpty(queryParameter) ? Constants.VIA_RESULT_SUCCESS.equals(queryParameter) : true;
                path = split[1];
                if (NativeInterface.SET_RIGHT_BUTTON.equals(path)) {
                    z = parse.getBooleanQueryParameter(NativeInterface.PARAM_VISIBLE, false);
                    ImageButton access$600 = WebActivity.this.mUnBindButton;
                    if (!z) {
                        i = 4;
                    }
                    access$600.setVisibility(i);
                    return true;
                } else if (NativeInterface.BIND.equals(path)) {
                    if (WebActivity.this.mTaskIsRunning) {
                        return true;
                    }
                    Utils.a(WebActivity.this, (int) r.state_authorization_doing);
                    WebActivity.this.mTaskIsRunning = true;
                    WebActivity.this.mDataManager.bind(WebActivity.this.mPartner.id);
                    C0401a.a(WebActivity.this, C0401a.bg, WebActivity.this.mPartner.id);
                    return true;
                } else if (NativeInterface.CHECK_APP_INSTALLED.equals(path)) {
                    String queryParameter2 = parse.getQueryParameter(com.g.a.b.b.b);
                    WebActivity.this.mInvoker.setCheckAppInstallResult(queryParameter2, Utils.a(queryParameter2));
                    return true;
                } else if (NativeInterface.SHARE.equals(path)) {
                    C0401a.a(WebActivity.this, C0401a.bC);
                    WebActivity.this.mShareTitle = parse.getQueryParameter(SocialConstants.PARAM_TITLE);
                    WebActivity.this.mShareIcon = parse.getQueryParameter(f.h);
                    WebActivity.this.mShareUrl = parse.getQueryParameter(SocialConstants.PARAM_URL);
                    WebActivity.this.mShareContent = parse.getQueryParameter(ParamKey.CONTENT);
                    WebActivity.this.mShareTopic = parse.getQueryParameter(NativeInterface.PARAM_SHARE_TOPIC);
                    if (!parse.getBooleanQueryParameter(NativeInterface.PARAM_SHOW, false)) {
                        return true;
                    }
                    WebActivity.this.share();
                    return true;
                } else if (NativeInterface.SET_TITLE_VISIBLE.equals(path)) {
                    z = parse.getBooleanQueryParameter(NativeInterface.PARAM_VISIBLE, false);
                    View access$1700 = WebActivity.this.mTitleBar;
                    if (!z) {
                        i = 8;
                    }
                    access$1700.setVisibility(i);
                    return true;
                } else if (NativeInterface.EXIT.equals(path)) {
                    WebActivity.this.finish();
                    return true;
                } else if (NativeInterface.RUN.equals(path)) {
                    WebActivity.this.pageLauncher("com.xiaomi.hm.health.action.RUNNING", z);
                    return true;
                } else if (NativeInterface.RELATION.equals(path)) {
                    WebActivity.this.pageLauncher("com.xiaomi.hm.health.action.RELATION", z);
                    return true;
                } else if (!NativeInterface.WEIBO_AUTH.equals(path)) {
                    return true;
                } else {
                    WebActivity.this.pageLauncher("com.xiaomi.hm.health.action.WEIBO_AUTH", z);
                    return true;
                }
            } else if (TextUtils.isEmpty(path) || !path.endsWith(".apk")) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                try {
                    parseUri = new Intent();
                    parseUri.setAction("android.intent.action.VIEW");
                    parseUri.setData(parse);
                    WebActivity.this.startActivity(parseUri);
                    return true;
                } catch (ActivityNotFoundException e22) {
                    C0596r.c(e22.getMessage());
                    return true;
                }
            }
        }
    };

    public static Intent buildIntent(Context context, Partner partner) {
        return PartnerDataManager.buildIntent(context, partner);
    }

    private void buildShareData(Partner partner) {
        this.mShareTitle = partner.title;
        if (TextUtils.isEmpty(partner.shareContent)) {
            this.mShareContent = partner.subTitle;
        } else {
            this.mShareContent = partner.shareContent;
        }
        this.mShareType = 13;
        this.mShareUrl = partner.url;
        this.mShareIcon = null;
        this.mShareTopic = partner.title;
    }

    private static Bitmap captureWebView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap createBitmap(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            C0596r.a(TAG, e.getMessage());
            return null;
        }
    }

    private Uri cropImageInSampleSize(String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Uri uri = null;
        Bitmap a = Utils.a(str, (int) IMAGEWIDTH, (int) IMAGEHEIGHT);
        if (a != null) {
            try {
                File a2 = a.a("lining.jpg");
                fileOutputStream = new FileOutputStream(a2);
                try {
                    a.compress(CompressFormat.JPEG, 30, fileOutputStream);
                    uri = Uri.fromFile(a2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            C0596r.a(PARTNER_LOG, "Taking Photo of Partner appear IO error");
                        }
                    }
                    a.recycle();
                } catch (Exception e2) {
                    try {
                        C0596r.a(PARTNER_LOG, "Taking Photo of Partner error");
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                C0596r.a(PARTNER_LOG, "Taking Photo of Partner appear IO error");
                            }
                        }
                        a.recycle();
                        return uri;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                C0596r.a(PARTNER_LOG, "Taking Photo of Partner appear IO error");
                            }
                        }
                        a.recycle();
                        throw th;
                    }
                }
            } catch (Exception e5) {
                fileOutputStream = uri;
                C0596r.a(PARTNER_LOG, "Taking Photo of Partner error");
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                a.recycle();
                return uri;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileOutputStream = uri;
                th = th4;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                a.recycle();
                throw th;
            }
        }
        return uri;
    }

    private void pageLauncher(String str, boolean z) {
        try {
            Intent intent = new Intent(str);
            intent.setPackage(getPackageName());
            startActivity(intent);
            if (z) {
                finish();
            }
        } catch (ActivityNotFoundException e) {
            C0596r.c(e.getMessage());
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void setupWebView(Uri uri) {
        this.mWebContainer.setWebChromeClient(this.mOpenChromeClient);
        this.mWebContainer.setWebViewClient(this.mWebViewClient);
        this.mWebContainer.getSettings().setJavaScriptEnabled(true);
        CookieSyncManager.createInstance(getApplicationContext());
        CookieSyncManager.getInstance().startSync();
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        Map a = g.a(getApplicationContext());
        for (String str : a.keySet()) {
            instance.setCookie(b.e(), str + "=" + ((String) a.get(str)));
            instance.setCookie(uri.getHost(), str + "=" + ((String) a.get(str)));
        }
    }

    private void share() {
        new AsyncTask<String, Integer, eH>() {
            protected eH doInBackground(String... strArr) {
                Bitmap access$1900;
                String str = strArr.length > 0 ? strArr[0] : com.xiaomi.e.a.f;
                if (TextUtils.isEmpty(str)) {
                    access$1900 = WebActivity.captureWebView(WebActivity.this.mWebContainer);
                } else if (URLUtil.isDataUrl(str)) {
                    int indexOf = str.indexOf(WebActivity.BASE64_FLAG_OF_IMG);
                    if (indexOf >= 0) {
                        str = str.substring(indexOf + WebActivity.BASE64_FLAG_OF_IMG.length());
                    }
                    access$1900 = WebActivity.createBitmap(str);
                } else {
                    access$1900 = null;
                }
                String e = a.e(System.currentTimeMillis() + ".jpg");
                return Utils.a(e, access$1900, 100) ? new eH(e) : null;
            }

            protected void onPostExecute(eH eHVar) {
                Serializable lVar = new l();
                lVar.a = WebActivity.this.mShareTitle;
                lVar.d = WebActivity.this.mShareUrl;
                lVar.c = WebActivity.this.mShareContent;
                lVar.e = eHVar.a();
                lVar.b = WebActivity.this.mShareTopic;
                Bundle bundle = new Bundle();
                bundle.putSerializable(h.a, lVar);
                bundle.putBoolean(q.b, false);
                h hVar = new h();
                hVar.setArguments(bundle);
                hVar.show(WebActivity.this.getFragmentManager(), C0401a.aY);
            }
        }.execute(new String[]{this.mShareIcon});
        C0401a.a((Context) this, C0401a.bC, this.mPartner.id);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == REQ_GALLERY) {
            if (this.mUploadMessage != null) {
                Object data = (intent == null || i2 != -1) ? null : intent.getData();
                if (data != null) {
                    String[] strArr = new String[]{"_data"};
                    Cursor loadInBackground = new CursorLoader(this, data, strArr, null, null, null).loadInBackground();
                    loadInBackground.moveToFirst();
                    Object string = loadInBackground.getString(loadInBackground.getColumnIndex(strArr[0]));
                    if (!TextUtils.isEmpty(string)) {
                        data = cropImageInSampleSize(string);
                    }
                }
                this.mUploadMessage.onReceiveValue(data);
                this.mPartnerSelectImageFragment.dismiss();
                this.mUploadMessage = null;
            }
        } else if (i == REQ_CAMERA) {
            this.mUploadMessage.onReceiveValue(i2 != 0 ? cropImageInSampleSize(a.a("lining_tmp.jpg").getPath()) : null);
            this.mPartnerSelectImageFragment.dismiss();
            this.mUploadMessage = null;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case com.xiaomi.hm.health.l.back_btn /*2131296542*/:
                finish();
                return;
            case com.xiaomi.hm.health.l.share_button /*2131296602*/:
                share();
                return;
            case com.xiaomi.hm.health.l.unbind_partner /*2131296603*/:
                if (!this.mTaskIsRunning) {
                    this.mTaskIsRunning = true;
                    Utils.a((Activity) this, (int) r.state_deauthorization_doing);
                    this.mDataManager.unbind(this.mPartner.id);
                    C0401a.a((Context) this, C0401a.bh, this.mPartner.id);
                    return;
                }
                return;
            case com.xiaomi.hm.health.l.error_page /*2131296605*/:
                if (this.mErrorView.findViewById(com.xiaomi.hm.health.l.label).getVisibility() == 0) {
                    this.mErrorView.findViewById(com.xiaomi.hm.health.l.progress).setVisibility(0);
                    this.mErrorView.setOnClickListener(null);
                    this.mWebContainer.reload();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_open);
        this.mLoadProgress = (ProgressBar) findViewById(com.xiaomi.hm.health.l.load_progress);
        this.mWebContainer = (WebView) findViewById(com.xiaomi.hm.health.l.open_web_container);
        this.mErrorView = findViewById(com.xiaomi.hm.health.l.error_page);
        this.mUnBindButton = (ImageButton) findViewById(com.xiaomi.hm.health.l.unbind_partner);
        ImageButton imageButton = (ImageButton) findViewById(com.xiaomi.hm.health.l.share_button);
        this.mTitleBar = findViewById(com.xiaomi.hm.health.l.title_bar);
        this.mProgressBar = findViewById(com.xiaomi.hm.health.l.progress);
        this.mErrorLabel = findViewById(com.xiaomi.hm.health.l.label);
        TextView textView = (TextView) findViewById(com.xiaomi.hm.health.l.back_btn);
        this.mInvoker = new JavaScriptInvoker(this.mWebContainer);
        this.mPartner = PartnerDataManager.buildService(getIntent());
        buildShareData(this.mPartner);
        C0401a.a((Context) this, C0401a.bf, this.mPartner.id);
        textView.setText(this.mPartner.title);
        try {
            setupWebView(Uri.parse(this.mShareUrl));
            EventBus.getDefault().registerSticky(this);
            textView.setOnClickListener(this);
            this.mUnBindButton.setOnClickListener(this);
            imageButton.setOnClickListener(this);
            this.mErrorView.setOnClickListener(this);
            this.mWebContainer.loadUrl(this.mPartner.url);
            this.mDataManager = new PartnerDataManager(this);
            if (this.mPartner.authorizeStatus == 1) {
                this.mUnBindButton.setVisibility(0);
            } else {
                this.mUnBindButton.setVisibility(4);
            }
            this.config = b.h();
        } catch (Exception e) {
            com.huami.android.view.b.a((Context) this, (int) r.toast_url_parse_error, 0).show();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventServiceStateChanged eventServiceStateChanged) {
        this.mTaskIsRunning = false;
        Utils.a((Activity) this);
        this.mWebContainer.clearHistory();
        if (eventServiceStateChanged.action == 1) {
            this.mUnBindButton.setVisibility(4);
            this.mPartner.authorizeStatus = 0;
            this.mPartner.url = eventServiceStateChanged.url;
            this.mWebContainer.loadUrl(eventServiceStateChanged.url);
            if (eventServiceStateChanged.success) {
                toast(getString(r.state_deauthorization_success));
            } else {
                toast(getString(r.state_deauthorization_error));
            }
        } else if (eventServiceStateChanged.action == 0) {
            this.mPartner.authorizeStatus = 1;
            this.mUnBindButton.setVisibility(0);
            this.mWebContainer.loadUrl(eventServiceStateChanged.url);
            this.mPartner.url = eventServiceStateChanged.url;
            if (eventServiceStateChanged.success) {
                toast(getString(r.state_authorization_success));
            } else {
                toast(getString(r.state_authorization_error));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent == null || i != 4 || !this.mWebContainer.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebContainer.goBack();
        return true;
    }

    protected void onPause() {
        super.onPause();
        this.mWebContainer.onPause();
        CookieSyncManager.getInstance().sync();
        C0401a.b(C0401a.ax);
        C0401a.b((Activity) this);
    }

    protected void onResume() {
        super.onResume();
        this.mWebContainer.onResume();
        CookieSyncManager.getInstance().stopSync();
        C0401a.a(C0401a.ax);
        C0401a.a((Activity) this);
    }

    protected final void selectImage(ValueCallback<Uri> valueCallback) {
        C0401a.a((Context) this, C0401a.bA);
        this.mUploadMessage = valueCallback;
        this.mPartnerSelectImageFragment = new PartnerSelectImageFragment() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (WebActivity.this.mUploadMessage != null) {
                    C0401a.a(WebActivity.this, C0401a.bB);
                    WebActivity.this.mUploadMessage.onReceiveValue(null);
                }
            }
        };
        c.showPanel((Activity) this, this.mPartnerSelectImageFragment);
    }

    public void toast(String str) {
        com.huami.android.view.b.a((Context) this, str, 0).show();
    }
}
