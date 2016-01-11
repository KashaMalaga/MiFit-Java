package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.xiaomi.account.openauth.h;
import com.xiaomi.market.sdk.o;

public class WidgetRequestParam extends BrowserRequestParamBase {
    public static final String EXTRA_KEY_WIDGET_CALLBACK = "key_widget_callback";
    public static final String REQ_PARAM_ATTENTION_FUID = "fuid";
    public static final String REQ_PARAM_COMMENT_CATEGORY = "category";
    public static final String REQ_PARAM_COMMENT_CONTENT = "content";
    public static final String REQ_PARAM_COMMENT_TOPIC = "q";
    private String mAppKey;
    private String mAppPackage;
    private String mAttentionFuid;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private String mCommentCategory;
    private String mCommentContent;
    private String mCommentTopic;
    private String mHashKey;
    private String mToken;
    private WidgetRequestCallback mWidgetRequestCallback;
    private String mWidgetRequestCallbackKey;

    public interface WidgetRequestCallback {
        void onWebViewResult(String str);
    }

    public WidgetRequestParam(Context context) {
        super(context);
        this.mLaucher = BrowserLauncher.WIDGET;
    }

    private String buildUrl(String str) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(o.x, WBConstants.WEIBO_SDK_VERSION_CODE);
        if (!TextUtils.isEmpty(this.mAppKey)) {
            buildUpon.appendQueryParameter(o.L, this.mAppKey);
        }
        if (!TextUtils.isEmpty(this.mToken)) {
            buildUpon.appendQueryParameter(h.I, this.mToken);
        }
        Object aid = Utility.getAid(this.mContext, this.mAppKey);
        if (!TextUtils.isEmpty(aid)) {
            buildUpon.appendQueryParameter(WBConstants.AUTH_PARAMS_AID, aid);
        }
        if (!TextUtils.isEmpty(this.mAppPackage)) {
            buildUpon.appendQueryParameter(ParamKey.PACKAGENAME, this.mAppPackage);
        }
        if (!TextUtils.isEmpty(this.mHashKey)) {
            buildUpon.appendQueryParameter(WBConstants.SSO_KEY_HASH, this.mHashKey);
        }
        if (!TextUtils.isEmpty(this.mAttentionFuid)) {
            buildUpon.appendQueryParameter(REQ_PARAM_ATTENTION_FUID, this.mAttentionFuid);
        }
        if (!TextUtils.isEmpty(this.mCommentTopic)) {
            buildUpon.appendQueryParameter(REQ_PARAM_COMMENT_TOPIC, this.mCommentTopic);
        }
        if (!TextUtils.isEmpty(this.mCommentContent)) {
            buildUpon.appendQueryParameter(REQ_PARAM_COMMENT_CONTENT, this.mCommentContent);
        }
        if (!TextUtils.isEmpty(this.mCommentCategory)) {
            buildUpon.appendQueryParameter(REQ_PARAM_COMMENT_CATEGORY, this.mCommentCategory);
        }
        return buildUpon.build().toString();
    }

    public void execRequest(Activity activity, int i) {
        if (i == 3) {
            WeiboSdkBrowser.closeBrowser(activity, this.mAuthListenerKey, this.mWidgetRequestCallbackKey);
        }
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAttentionFuid() {
        return this.mAttentionFuid;
    }

    public WeiboAuthListener getAuthListener() {
        return this.mAuthListener;
    }

    public String getAuthListenerKey() {
        return this.mAuthListenerKey;
    }

    public String getCommentCategory() {
        return this.mCommentCategory;
    }

    public String getCommentContent() {
        return this.mCommentContent;
    }

    public String getCommentTopic() {
        return this.mCommentTopic;
    }

    public String getToken() {
        return this.mToken;
    }

    public WidgetRequestCallback getWidgetRequestCallback() {
        return this.mWidgetRequestCallback;
    }

    public String getWidgetRequestCallbackKey() {
        return this.mWidgetRequestCallbackKey;
    }

    public void onCreateRequestParamBundle(Bundle bundle) {
        this.mAppPackage = this.mContext.getPackageName();
        if (!TextUtils.isEmpty(this.mAppPackage)) {
            this.mHashKey = MD5.hexdigest(Utility.getSign(this.mContext, this.mAppPackage));
        }
        bundle.putString(h.I, this.mToken);
        bundle.putString(o.L, this.mAppKey);
        bundle.putString(ParamKey.PACKAGENAME, this.mAppPackage);
        bundle.putString(WBConstants.SSO_KEY_HASH, this.mHashKey);
        bundle.putString(REQ_PARAM_ATTENTION_FUID, this.mAttentionFuid);
        bundle.putString(REQ_PARAM_COMMENT_TOPIC, this.mCommentTopic);
        bundle.putString(REQ_PARAM_COMMENT_CONTENT, this.mCommentContent);
        bundle.putString(REQ_PARAM_COMMENT_CATEGORY, this.mCommentCategory);
        WeiboCallbackManager instance = WeiboCallbackManager.getInstance(this.mContext);
        if (this.mAuthListener != null) {
            this.mAuthListenerKey = instance.genCallbackKey();
            instance.setWeiboAuthListener(this.mAuthListenerKey, this.mAuthListener);
            bundle.putString(AuthRequestParam.EXTRA_KEY_LISTENER, this.mAuthListenerKey);
        }
        if (this.mWidgetRequestCallback != null) {
            this.mWidgetRequestCallbackKey = instance.genCallbackKey();
            instance.setWidgetRequestCallback(this.mWidgetRequestCallbackKey, this.mWidgetRequestCallback);
            bundle.putString(EXTRA_KEY_WIDGET_CALLBACK, this.mWidgetRequestCallbackKey);
        }
    }

    protected void onSetupRequestParam(Bundle bundle) {
        this.mAppKey = bundle.getString(o.L);
        this.mAppPackage = bundle.getString(ParamKey.PACKAGENAME);
        this.mHashKey = bundle.getString(WBConstants.SSO_KEY_HASH);
        this.mToken = bundle.getString(h.I);
        this.mAttentionFuid = bundle.getString(REQ_PARAM_ATTENTION_FUID);
        this.mCommentTopic = bundle.getString(REQ_PARAM_COMMENT_TOPIC);
        this.mCommentContent = bundle.getString(REQ_PARAM_COMMENT_CONTENT);
        this.mCommentCategory = bundle.getString(REQ_PARAM_COMMENT_CATEGORY);
        this.mAuthListenerKey = bundle.getString(AuthRequestParam.EXTRA_KEY_LISTENER);
        if (!TextUtils.isEmpty(this.mAuthListenerKey)) {
            this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey);
        }
        this.mWidgetRequestCallbackKey = bundle.getString(EXTRA_KEY_WIDGET_CALLBACK);
        if (!TextUtils.isEmpty(this.mWidgetRequestCallbackKey)) {
            this.mWidgetRequestCallback = WeiboCallbackManager.getInstance(this.mContext).getWidgetRequestCallback(this.mWidgetRequestCallbackKey);
        }
        this.mUrl = buildUrl(this.mUrl);
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAttentionFuid(String str) {
        this.mAttentionFuid = str;
    }

    public void setAuthListener(WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
    }

    public void setCommentCategory(String str) {
        this.mCommentCategory = str;
    }

    public void setCommentContent(String str) {
        this.mCommentContent = str;
    }

    public void setCommentTopic(String str) {
        this.mCommentTopic = str;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setWidgetRequestCallback(WidgetRequestCallback widgetRequestCallback) {
        this.mWidgetRequestCallback = widgetRequestCallback;
    }
}
