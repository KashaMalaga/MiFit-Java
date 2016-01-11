package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import com.tencent.connect.auth.AuthMap.Auth;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.c.c;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.open.web.security.b;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import kankan.wheel.widget.l;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthDialog extends Dialog {
    private String a;
    private OnTimeListener b;
    private IUiListener c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private c j;
    private Context k;
    private b l;
    private boolean m = false;
    private int n;
    private String o;
    private String p;
    private long q = 0;
    private long r = 30000;
    private HashMap<String, Runnable> s;

    class LoginWebViewClient extends WebViewClient {
        final /* synthetic */ AuthDialog a;

        private LoginWebViewClient(AuthDialog authDialog) {
            this.a = authDialog;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f.b("openSDK_LOG.authDlg", "-->onPageFinished, url: " + str);
            this.a.g.setVisibility(8);
            if (this.a.j != null) {
                this.a.j.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                this.a.d.removeCallbacks((Runnable) this.a.s.remove(str));
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.b("openSDK_LOG.authDlg", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            this.a.g.setVisibility(0);
            this.a.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(this.a.o)) {
                this.a.d.removeCallbacks((Runnable) this.a.s.remove(this.a.o));
            }
            this.a.o = str;
            Runnable timeOutRunable = new TimeOutRunable(this.a, this.a.o);
            this.a.s.put(str, timeOutRunable);
            this.a.d.postDelayed(timeOutRunable, 120000);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            f.c("openSDK_LOG.authDlg", "-->onReceivedError, errorCode: " + i + " | description: " + str);
            if (!Util.checkNetWork(this.a.k)) {
                this.a.b.onError(new UiError(9001, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", str2));
                this.a.dismiss();
            } else if (this.a.o.startsWith(ServerSetting.DOWNLOAD_QQ_URL)) {
                this.a.b.onError(new UiError(i, str, str2));
                this.a.dismiss();
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.q;
                if (this.a.n >= 1 || elapsedRealtime >= this.a.r) {
                    this.a.j.loadUrl(this.a.a());
                    return;
                }
                this.a.n = this.a.n + 1;
                this.a.d.postDelayed(new Runnable(this) {
                    final /* synthetic */ LoginWebViewClient a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.a.j.loadUrl(this.a.a.o);
                    }
                }, 500);
            }
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
            this.a.b.onError(new UiError(sslError.getPrimaryError(), "\u8bf7\u6c42\u4e0d\u5408\u6cd5\uff0c\u8bf7\u68c0\u67e5\u624b\u673a\u5b89\u5168\u8bbe\u7f6e\uff0c\u5982\u7cfb\u7edf\u65f6\u95f4\u3001\u4ee3\u7406\u7b49\u3002", "ssl error"));
            this.a.dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.b("openSDK_LOG.authDlg", "-->Redirect URL: " + str);
            if (str.startsWith(AuthConstants.REDIRECT_BROWSER_URI)) {
                JSONObject parseUrlToJson = Util.parseUrlToJson(str);
                this.a.m = this.a.e();
                if (!this.a.m) {
                    if (parseUrlToJson.optString("fail_cb", null) != null) {
                        this.a.callJs(parseUrlToJson.optString("fail_cb"), a.f);
                    } else if (parseUrlToJson.optInt("fall_to_wv") == 1) {
                        AuthDialog.a(this.a, this.a.a.indexOf("?") > -1 ? "&" : "?");
                        AuthDialog.a(this.a, (Object) "browser_error=1");
                        this.a.j.loadUrl(this.a.a);
                    } else {
                        String optString = parseUrlToJson.optString("redir", null);
                        if (optString != null) {
                            this.a.j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith(ServerSetting.DEFAULT_REDIRECT_URI)) {
                this.a.b.onComplete(Util.parseUrlToJson(str));
                this.a.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                this.a.b.onCancel();
                this.a.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                this.a.dismiss();
                return true;
            } else if (str.startsWith(Constants.DOWNLOAD_URI)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring(Constants.DOWNLOAD_URI.length()))));
                    intent.addFlags(268435456);
                    this.a.k.startActivity(intent);
                } catch (Exception e) {
                    f.b("openSDK_LOG.authDlg", "-->start download activity exception, e: " + e.getMessage());
                }
                return true;
            } else if (str.startsWith(AuthConstants.PROGRESS_URI)) {
                try {
                    r0 = Uri.parse(str).getPathSegments();
                    if (r0.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf((String) r0.get(0)).intValue();
                    if (intValue == 0) {
                        this.a.g.setVisibility(8);
                        this.a.j.setVisibility(0);
                    } else if (intValue == 1) {
                        this.a.g.setVisibility(0);
                    }
                    return true;
                } catch (Exception e2) {
                    return true;
                }
            } else if (str.startsWith(AuthConstants.ON_LOGIN_URI)) {
                try {
                    r0 = Uri.parse(str).getPathSegments();
                    if (!r0.isEmpty()) {
                        this.a.p = (String) r0.get(0);
                    }
                } catch (Exception e3) {
                }
                return true;
            } else if (this.a.l.a(this.a.j, str)) {
                return true;
            } else {
                f.c("openSDK_LOG.authDlg", "-->Redirect URL: return false");
                return false;
            }
        }
    }

    class OnTimeListener implements IUiListener {
        String a;
        String b;
        final /* synthetic */ AuthDialog c;
        private String d;
        private IUiListener e;

        public OnTimeListener(AuthDialog authDialog, String str, String str2, String str3, IUiListener iUiListener) {
            this.c = authDialog;
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        private void a(String str) {
            try {
                onComplete(Util.parseJson(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        public void onCancel() {
            if (this.e != null) {
                this.e.onCancel();
                this.e = null;
            }
        }

        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt(QQLogin.KEY_RESULT, -6), this.a, false);
            if (this.e != null) {
                this.e.onComplete(jSONObject);
                this.e = null;
            }
        }

        public void onError(UiError uiError) {
            String str = uiError.errorMessage != null ? uiError.errorMessage + this.a : this.a;
            g.a().a(this.d + "_H5", SystemClock.elapsedRealtime(), 0, 0, uiError.errorCode, str, false);
            this.c.a(str);
            if (this.e != null) {
                this.e.onError(uiError);
                this.e = null;
            }
        }
    }

    class THandler extends Handler {
        final /* synthetic */ AuthDialog a;
        private OnTimeListener b;

        public THandler(AuthDialog authDialog, OnTimeListener onTimeListener, Looper looper) {
            this.a = authDialog;
            super(looper);
            this.b = onTimeListener;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case l.a /*1*/:
                    this.b.a((String) message.obj);
                    return;
                case kankan.wheel.widget.a.k /*2*/:
                    this.b.onCancel();
                    return;
                case kankan.wheel.widget.a.l /*3*/:
                    AuthDialog.b(this.a.k, (String) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    class TimeOutRunable implements Runnable {
        String a = a.f;
        final /* synthetic */ AuthDialog b;

        public TimeOutRunable(AuthDialog authDialog, String str) {
            this.b = authDialog;
            this.a = str;
        }

        public void run() {
            f.b("openSDK_LOG.authDlg", "-->timeoutUrl: " + this.a + " | mRetryUrl: " + this.b.o);
            if (this.a.equals(this.b.o)) {
                this.b.b.onError(new UiError(9002, "\u8bf7\u6c42\u9875\u9762\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", this.b.o));
                this.b.dismiss();
            }
        }
    }

    static {
        try {
            Context context = Global.getContext();
            if (context == null) {
                f.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib fail, because context is null.");
            } else if (new File(context.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                System.load(context.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
                f.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib success.");
            } else {
                f.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib fail, because so is not exists.");
            }
        } catch (Throwable e) {
            f.b("openSDK_LOG.authDlg", "-->load wbsafeedit lib error.", e);
        }
    }

    public AuthDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.k = context;
        this.a = str2;
        this.b = new OnTimeListener(this, str, str2, qQToken.getAppId(), iUiListener);
        this.d = new THandler(this, this.b, context.getMainLooper());
        this.c = iUiListener;
        this.i = str;
        this.l = new b();
        getWindow().setSoftInputMode(32);
    }

    private String a() {
        String str = ServerSetting.DOWNLOAD_QQ_URL + this.a.substring(this.a.indexOf("?") + 1);
        f.c("openSDK_LOG.authDlg", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str;
    }

    static /* synthetic */ String a(AuthDialog authDialog, Object obj) {
        String str = authDialog.a + obj;
        authDialog.a = str;
        return str;
    }

    private String a(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            stringBuilder.append("_u_").append(this.p.substring(this.p.length() - 4));
        }
        return stringBuilder.toString();
    }

    private void b() {
        c();
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.j = new c(this.k);
        this.j.setLayoutParams(layoutParams);
        this.e = new FrameLayout(this.k);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.addView(this.j);
        this.e.addView(this.g);
        setContentView(this.e);
    }

    private static void b(Context context, String str) {
        try {
            JSONObject parseJson = Util.parseJson(str);
            int i = parseJson.getInt(SocialConstants.PARAM_TYPE);
            Toast.makeText(context.getApplicationContext(), parseJson.getString(SocialConstants.PARAM_SEND_MSG), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        LayoutParams layoutParams;
        this.h = new ProgressBar(this.k);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new LinearLayout(this.k);
        View view = null;
        if (this.i.equals(SystemUtils.ACTION_LOGIN)) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            view = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                view.setText("\u767b\u5f55\u4e2d...");
            } else {
                view.setText("Logging in...");
            }
            view.setTextColor(Color.rgb(HeartRateInfo.HR_EMPTY_VALUE, HeartRateInfo.HR_EMPTY_VALUE, HeartRateInfo.HR_EMPTY_VALUE));
            view.setTextSize(18.0f);
            view.setLayoutParams(layoutParams);
        }
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f.setLayoutParams(layoutParams);
        this.f.addView(this.h);
        if (view != null) {
            this.f.addView(view);
        }
        this.g = new FrameLayout(this.k);
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = 80;
        layoutParams2.rightMargin = 80;
        layoutParams2.topMargin = 40;
        layoutParams2.bottomMargin = 40;
        layoutParams2.gravity = 17;
        this.g.setLayoutParams(layoutParams2);
        this.g.setBackgroundResource(17301504);
        this.g.addView(this.f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new LoginWebViewClient());
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.clearFormData();
        this.j.clearSslPreferences();
        this.j.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ AuthDialog a;

            {
                this.a = r1;
            }

            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.j.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AuthDialog a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case kankan.wheel.widget.a.i /*0*/:
                    case l.a /*1*/:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        WebSettings settings = this.j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        f.b("openSDK_LOG.authDlg", "-->mUrl : " + this.a);
        this.o = this.a;
        this.j.loadUrl(this.a);
        this.j.setVisibility(4);
        this.j.getSettings().setSavePassword(false);
        this.l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ AuthDialog a;

            {
                this.a = r1;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    JniInterface.clearAllPWD();
                } catch (Exception e) {
                }
            }
        });
    }

    private boolean e() {
        AuthMap instance = AuthMap.getInstance();
        String makeKey = instance.makeKey();
        Auth auth = new Auth();
        auth.listener = this.c;
        auth.dialog = this;
        auth.key = makeKey;
        String str = instance.set(auth);
        String substring = this.a.substring(0, this.a.indexOf("?"));
        Bundle parseUrl = Util.parseUrl(this.a);
        parseUrl.putString("token_key", makeKey);
        parseUrl.putString("serial", str);
        parseUrl.putString("browser", Constants.VIA_TO_TYPE_QQ_GROUP);
        this.a = substring + "?" + Util.encodeUrl(parseUrl);
        return Util.openBrowser(this.k, this.a);
    }

    public void callJs(String str, String str2) {
        this.j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }

    public void dismiss() {
        this.s.clear();
        this.d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        if (this.j != null) {
            this.j.destroy();
            this.j = null;
        }
    }

    public void onBackPressed() {
        if (!this.m) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b();
        d();
        this.s = new HashMap();
    }

    protected void onStop() {
        super.onStop();
    }
}
