package com.sina.weibo.sdk.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.ShareRequestParam.UploadPicResult;
import com.sina.weibo.sdk.component.view.LoadingBar;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;

public class WeiboSdkBrowser extends Activity implements BrowserRequestCallBack {
    public static final String BROWSER_CLOSE_SCHEME = "sinaweibo://browser/close";
    public static final String BROWSER_WIDGET_SCHEME = "sinaweibo://browser/datatransfer";
    private static final String CANCEL_EN = "Close";
    private static final String CANCEL_ZH_CN = "\u5173\u95ed";
    private static final String CANCEL_ZH_TW = "\u5173\u95ed";
    private static final String CHANNEL_DATA_ERROR_EN = "channel_data_error";
    private static final String CHANNEL_DATA_ERROR_ZH_CN = "\u91cd\u65b0\u52a0\u8f7d";
    private static final String CHANNEL_DATA_ERROR_ZH_TW = "\u91cd\u65b0\u8f09\u5165";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_EN = "A network error occurs, please tap the button to reload";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN = "\u7f51\u7edc\u51fa\u9519\u5566\uff0c\u8bf7\u70b9\u51fb\u6309\u94ae\u91cd\u65b0\u52a0\u8f7d";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW = "\u7db2\u8def\u51fa\u932f\u5566\uff0c\u8acb\u9ede\u64ca\u6309\u9215\u91cd\u65b0\u8f09\u5165";
    private static final String LOADINFO_EN = "Loading....";
    private static final String LOADINFO_ZH_CN = "\u52a0\u8f7d\u4e2d....";
    private static final String LOADINFO_ZH_TW = "\u8f09\u5165\u4e2d....";
    private static final String TAG = WeiboSdkBrowser.class.getName();
    private static final String WEIBOBROWSER_NO_TITLE_EN = "No Title";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_CN = "\u65e0\u6807\u9898";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_TW = "\u7121\u6a19\u984c";
    private boolean isErrorPage;
    private boolean isLoading;
    private String mHtmlTitle;
    private TextView mLeftBtn;
    private Button mLoadErrorRetryBtn;
    private LinearLayout mLoadErrorView;
    private LoadingBar mLoadingBar;
    private BrowserRequestParamBase mRequestParam;
    private String mSpecifyTitle;
    private TextView mTitleText;
    private String mUrl;
    private WebView mWebView;
    private WeiboWebViewClient mWeiboWebViewClient;

    class WeiboChromeClient extends WebChromeClient {
        private WeiboChromeClient() {
        }

        public void onProgressChanged(WebView webView, int i) {
            WeiboSdkBrowser.this.mLoadingBar.drawProgress(i);
            if (i == 100) {
                WeiboSdkBrowser.this.isLoading = false;
                WeiboSdkBrowser.this.refreshAllViews();
            } else if (!WeiboSdkBrowser.this.isLoading) {
                WeiboSdkBrowser.this.isLoading = true;
                WeiboSdkBrowser.this.refreshAllViews();
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (!WeiboSdkBrowser.this.isWeiboCustomScheme(WeiboSdkBrowser.this.mUrl)) {
                WeiboSdkBrowser.this.mHtmlTitle = str;
                WeiboSdkBrowser.this.updateTitleName();
            }
        }
    }

    public static void closeBrowser(Activity activity, String str, String str2) {
        WeiboCallbackManager instance = WeiboCallbackManager.getInstance(activity.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            instance.removeWeiboAuthListener(str);
            activity.finish();
        }
        if (!TextUtils.isEmpty(str2)) {
            instance.removeWidgetRequestCallback(str2);
            activity.finish();
        }
    }

    private BrowserRequestParamBase createBrowserRequestParam(Bundle bundle) {
        BrowserLauncher browserLauncher = (BrowserLauncher) bundle.getSerializable(BrowserRequestParamBase.EXTRA_KEY_LAUNCHER);
        BrowserRequestParamBase authRequestParam;
        if (browserLauncher == BrowserLauncher.AUTH) {
            authRequestParam = new AuthRequestParam(this);
            authRequestParam.setupRequestParam(bundle);
            installAuthWeiboWebViewClient(authRequestParam);
            return authRequestParam;
        } else if (browserLauncher == BrowserLauncher.SHARE) {
            authRequestParam = new ShareRequestParam(this);
            authRequestParam.setupRequestParam(bundle);
            installShareWeiboWebViewClient(authRequestParam);
            return authRequestParam;
        } else if (browserLauncher != BrowserLauncher.WIDGET) {
            return null;
        } else {
            authRequestParam = new WidgetRequestParam(this);
            authRequestParam.setupRequestParam(bundle);
            installWidgetWeiboWebViewClient(authRequestParam);
            return authRequestParam;
        }
    }

    private void handleReceivedError(WebView webView, int i, String str, String str2) {
        if (!str2.startsWith("sinaweibo")) {
            this.isErrorPage = true;
            promptError();
        }
    }

    private void hiddenErrorPrompt() {
        this.mLoadErrorView.setVisibility(8);
        this.mWebView.setVisibility(0);
    }

    private boolean initDataFromIntent(Intent intent) {
        this.mRequestParam = createBrowserRequestParam(intent.getExtras());
        if (this.mRequestParam == null) {
            return false;
        }
        this.mUrl = this.mRequestParam.getUrl();
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        LogUtil.d(TAG, "LOAD URL : " + this.mUrl);
        this.mSpecifyTitle = this.mRequestParam.getSpecifyTitle();
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebView() {
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        if (isWeiboShareRequestParam(this.mRequestParam)) {
            this.mWebView.getSettings().setUserAgentString(Utility.generateUA(this));
        }
        this.mWebView.getSettings().setSavePassword(false);
        this.mWebView.setWebViewClient(this.mWeiboWebViewClient);
        this.mWebView.setWebChromeClient(new WeiboChromeClient());
        this.mWebView.requestFocus();
        this.mWebView.setScrollBarStyle(0);
    }

    private void installAuthWeiboWebViewClient(AuthRequestParam authRequestParam) {
        this.mWeiboWebViewClient = new AuthWeiboWebViewClient(this, authRequestParam);
        this.mWeiboWebViewClient.setBrowserRequestCallBack(this);
    }

    private void installShareWeiboWebViewClient(ShareRequestParam shareRequestParam) {
        WeiboWebViewClient shareWeiboWebViewClient = new ShareWeiboWebViewClient(this, shareRequestParam);
        shareWeiboWebViewClient.setBrowserRequestCallBack(this);
        this.mWeiboWebViewClient = shareWeiboWebViewClient;
    }

    private void installWidgetWeiboWebViewClient(WidgetRequestParam widgetRequestParam) {
        WeiboWebViewClient widgetWeiboWebViewClient = new WidgetWeiboWebViewClient(this, widgetRequestParam);
        widgetWeiboWebViewClient.setBrowserRequestCallBack(this);
        this.mWeiboWebViewClient = widgetWeiboWebViewClient;
    }

    private boolean isWeiboCustomScheme(String str) {
        return !TextUtils.isEmpty(str) && "sinaweibo".equalsIgnoreCase(Uri.parse(str).getAuthority());
    }

    private boolean isWeiboShareRequestParam(BrowserRequestParamBase browserRequestParamBase) {
        return browserRequestParamBase.getLauncher() == BrowserLauncher.SHARE;
    }

    private void openUrl(String str) {
        this.mWebView.loadUrl(str);
    }

    private void promptError() {
        this.mLoadErrorView.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    private void setContentView() {
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-1);
        View linearLayout = new LinearLayout(this);
        linearLayout.setId(1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        View relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(new LayoutParams(-1, ResourceManager.dp2px(this, 45)));
        relativeLayout2.setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "weibosdk_navigationbar_background.9.png"));
        this.mLeftBtn = new TextView(this);
        this.mLeftBtn.setClickable(true);
        this.mLeftBtn.setTextSize(2, 17.0f);
        this.mLeftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 1728020992));
        this.mLeftBtn.setText(ResourceManager.getString(this, CANCEL_EN, CANCEL_ZH_TW, CANCEL_ZH_TW));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        layoutParams.leftMargin = ResourceManager.dp2px(this, 10);
        layoutParams.rightMargin = ResourceManager.dp2px(this, 10);
        this.mLeftBtn.setLayoutParams(layoutParams);
        relativeLayout2.addView(this.mLeftBtn);
        this.mTitleText = new TextView(this);
        this.mTitleText.setTextSize(2, 18.0f);
        this.mTitleText.setTextColor(-11382190);
        this.mTitleText.setEllipsize(TruncateAt.END);
        this.mTitleText.setSingleLine(true);
        this.mTitleText.setGravity(17);
        this.mTitleText.setMaxWidth(ResourceManager.dp2px(this, 160));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mTitleText.setLayoutParams(layoutParams);
        relativeLayout2.addView(this.mTitleText);
        View textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 2)));
        textView.setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "weibosdk_common_shadow_top.9.png"));
        this.mLoadingBar = new LoadingBar(this);
        this.mLoadingBar.setBackgroundColor(0);
        this.mLoadingBar.drawProgress(0);
        this.mLoadingBar.setLayoutParams(new LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 3)));
        linearLayout.addView(relativeLayout2);
        linearLayout.addView(textView);
        linearLayout.addView(this.mLoadingBar);
        this.mWebView = new WebView(this);
        this.mWebView.setBackgroundColor(-1);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, 1);
        this.mWebView.setLayoutParams(layoutParams2);
        this.mLoadErrorView = new LinearLayout(this);
        this.mLoadErrorView.setVisibility(8);
        this.mLoadErrorView.setOrientation(1);
        this.mLoadErrorView.setGravity(17);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, 1);
        this.mLoadErrorView.setLayoutParams(layoutParams2);
        relativeLayout2 = new ImageView(this);
        relativeLayout2.setImageDrawable(ResourceManager.getDrawable(this, "weibosdk_empty_failed.png"));
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dp2px = ResourceManager.dp2px(this, 8);
        layoutParams.bottomMargin = dp2px;
        layoutParams.rightMargin = dp2px;
        layoutParams.topMargin = dp2px;
        layoutParams.leftMargin = dp2px;
        relativeLayout2.setLayoutParams(layoutParams);
        this.mLoadErrorView.addView(relativeLayout2);
        relativeLayout2 = new TextView(this);
        relativeLayout2.setGravity(1);
        relativeLayout2.setTextColor(-4342339);
        relativeLayout2.setTextSize(2, 14.0f);
        relativeLayout2.setText(ResourceManager.getString(this, EMPTY_PROMPT_BAD_NETWORK_UI_EN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW));
        relativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mLoadErrorView.addView(relativeLayout2);
        this.mLoadErrorRetryBtn = new Button(this);
        this.mLoadErrorRetryBtn.setGravity(17);
        this.mLoadErrorRetryBtn.setTextColor(-8882056);
        this.mLoadErrorRetryBtn.setTextSize(2, 16.0f);
        this.mLoadErrorRetryBtn.setText(ResourceManager.getString(this, CHANNEL_DATA_ERROR_EN, CHANNEL_DATA_ERROR_ZH_CN, CHANNEL_DATA_ERROR_ZH_TW));
        this.mLoadErrorRetryBtn.setBackgroundDrawable(ResourceManager.createStateListDrawable(this, "weibosdk_common_button_alpha.9.png", "weibosdk_common_button_alpha_highlighted.9.png"));
        layoutParams2 = new LinearLayout.LayoutParams(ResourceManager.dp2px(this, 142), ResourceManager.dp2px(this, 46));
        layoutParams2.topMargin = ResourceManager.dp2px(this, 10);
        this.mLoadErrorRetryBtn.setLayoutParams(layoutParams2);
        this.mLoadErrorRetryBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WeiboSdkBrowser.this.openUrl(WeiboSdkBrowser.this.mUrl);
                WeiboSdkBrowser.this.isErrorPage = false;
            }
        });
        this.mLoadErrorView.addView(this.mLoadErrorRetryBtn);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.mWebView);
        relativeLayout.addView(this.mLoadErrorView);
        setContentView(relativeLayout);
        setTopNavTitle();
    }

    private void setTopNavTitle() {
        this.mTitleText.setText(this.mSpecifyTitle);
        this.mLeftBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WeiboSdkBrowser.this.mRequestParam.execRequest(WeiboSdkBrowser.this, 3);
                WeiboSdkBrowser.this.finish();
            }
        });
    }

    private void setViewLoading() {
        this.mTitleText.setText(ResourceManager.getString(this, LOADINFO_EN, LOADINFO_ZH_CN, LOADINFO_ZH_TW));
        this.mLoadingBar.setVisibility(0);
    }

    private void setViewNormal() {
        updateTitleName();
        this.mLoadingBar.setVisibility(8);
    }

    public static void startAuth(Context context, String str, AuthInfo authInfo, WeiboAuthListener weiboAuthListener) {
        AuthRequestParam authRequestParam = new AuthRequestParam(context);
        authRequestParam.setLauncher(BrowserLauncher.AUTH);
        authRequestParam.setUrl(str);
        authRequestParam.setAuthInfo(authInfo);
        authRequestParam.setAuthListener(weiboAuthListener);
        Intent intent = new Intent(context, WeiboSdkBrowser.class);
        intent.putExtras(authRequestParam.createRequestParamBundle());
        context.startActivity(intent);
    }

    private void startShare() {
        LogUtil.d(TAG, "Enter startShare()............");
        final ShareRequestParam shareRequestParam = (ShareRequestParam) this.mRequestParam;
        if (shareRequestParam.hasImage()) {
            LogUtil.d(TAG, "loadUrl hasImage............");
            new AsyncWeiboRunner(this).requestAsync(ShareRequestParam.UPLOAD_PIC_URL, shareRequestParam.buildUploadPicParam(new WeiboParameters(shareRequestParam.getAppKey())), Constants.HTTP_POST, new RequestListener() {
                public void onComplete(String str) {
                    LogUtil.d(WeiboSdkBrowser.TAG, "post onComplete : " + str);
                    UploadPicResult parse = UploadPicResult.parse(str);
                    if (parse == null || parse.getCode() != 1 || TextUtils.isEmpty(parse.getPicId())) {
                        shareRequestParam.sendSdkErrorResponse(WeiboSdkBrowser.this, "upload pic faild");
                        WeiboSdkBrowser.this.finish();
                        return;
                    }
                    WeiboSdkBrowser.this.openUrl(shareRequestParam.buildUrl(parse.getPicId()));
                }

                public void onWeiboException(WeiboException weiboException) {
                    LogUtil.d(WeiboSdkBrowser.TAG, "post onWeiboException " + weiboException.getMessage());
                    shareRequestParam.sendSdkErrorResponse(WeiboSdkBrowser.this, weiboException.getMessage());
                    WeiboSdkBrowser.this.finish();
                }
            });
            return;
        }
        openUrl(this.mUrl);
    }

    public static void startShared(Context context, String str, AuthInfo authInfo, WeiboAuthListener weiboAuthListener) {
    }

    private void updateTitleName() {
        CharSequence charSequence = a.f;
        if (!TextUtils.isEmpty(this.mHtmlTitle)) {
            charSequence = this.mHtmlTitle;
        } else if (!TextUtils.isEmpty(this.mSpecifyTitle)) {
            charSequence = this.mSpecifyTitle;
        }
        this.mTitleText.setText(charSequence);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (initDataFromIntent(getIntent())) {
            setContentView();
            initWebView();
            if (isWeiboShareRequestParam(this.mRequestParam)) {
                startShare();
                return;
            } else {
                openUrl(this.mUrl);
                return;
            }
        }
        finish();
    }

    protected void onDestroy() {
        NetworkHelper.clearCookies(this);
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        this.mRequestParam.execRequest(this, 3);
        finish();
        return true;
    }

    public void onPageFinishedCallBack(WebView webView, String str) {
        LogUtil.d(TAG, "onPageFinished URL: " + str);
        if (this.isErrorPage) {
            promptError();
            return;
        }
        this.isErrorPage = false;
        hiddenErrorPrompt();
    }

    public void onPageStartedCallBack(WebView webView, String str, Bitmap bitmap) {
        LogUtil.d(TAG, "onPageStarted URL: " + str);
        this.mUrl = str;
        if (!isWeiboCustomScheme(str)) {
            this.mHtmlTitle = a.f;
        }
    }

    public void onReceivedErrorCallBack(WebView webView, int i, String str, String str2) {
        LogUtil.d(TAG, "onReceivedError: errorCode = " + i + ", description = " + str + ", failingUrl = " + str2);
        handleReceivedError(webView, i, str, str2);
    }

    public void onReceivedSslErrorCallBack(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        LogUtil.d(TAG, "onReceivedSslErrorCallBack.........");
    }

    protected void onResume() {
        super.onResume();
    }

    protected void refreshAllViews() {
        if (this.isLoading) {
            setViewLoading();
        } else {
            setViewNormal();
        }
    }

    public boolean shouldOverrideUrlLoadingCallBack(WebView webView, String str) {
        LogUtil.i(TAG, "shouldOverrideUrlLoading URL: " + str);
        return false;
    }
}
