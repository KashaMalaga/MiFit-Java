package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import java.net.URLEncoder;
import java.util.ArrayList;

public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_APP = 6;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    private boolean a = true;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    public String mViaShareQzoneType = a.f;

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    private void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList stringArrayList = bundle.getStringArrayList(SHARE_TO_QQ_IMAGE_URL);
        Object string = bundle.getString(SHARE_TO_QQ_TITLE);
        Object string2 = bundle.getString(SHARE_TO_QQ_SUMMARY);
        Object string3 = bundle.getString(SHARE_TO_QQ_TARGET_URL);
        String string4 = bundle.getString(SHARE_TO_QQ_AUDIO_URL);
        int i = bundle.getInt(SHARE_TO_QZONE_KEY_TYPE, SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        Object string5 = bundle.getString(SHARE_TO_QQ_APP_NAME);
        int i2 = bundle.getInt(SHARE_TO_QQ_EXT_INT, 0);
        String string6 = bundle.getString(SHARE_TO_QQ_EXT_STR);
        CharSequence appId = this.mToken.getAppId();
        String openId = this.mToken.getOpenId();
        f.b("doshareToQzone", "openId:" + openId);
        if (stringArrayList != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int size = stringArrayList.size() > 9 ? 9 : stringArrayList.size();
            for (int i3 = 0; i3 < size; i3 += SHARE_TO_QZONE_TYPE_IMAGE_TEXT) {
                stringBuffer2.append(URLEncoder.encode((String) stringArrayList.get(i3)));
                if (i3 != size - 1) {
                    stringBuffer2.append(";");
                }
            }
            stringBuffer.append("&image_url=" + Base64.encodeToString(Util.getBytesUTF8(stringBuffer2.toString()), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + Base64.encodeToString(Util.getBytesUTF8(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(Util.getBytesUTF8(string2), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + Base64.encodeToString(Util.getBytesUTF8(string3), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(Util.getBytesUTF8(string5), 2));
        }
        if (!Util.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(Util.getBytesUTF8(openId), 2));
        }
        if (!Util.isEmpty(string4)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(Util.getBytesUTF8(string4), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i)), 2));
        if (!Util.isEmpty(string6)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(Util.getBytesUTF8(string6), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i2)), 2));
        f.b("doshareToQzone, url: ", stringBuffer.toString());
        String[] strArr = new String[SHARE_TO_QZONE_TYPE_IMAGE_TEXT];
        strArr[0] = "shareToNativeQQ";
        com.tencent.connect.a.a.a(Global.getContext(), this.mToken, "requireApi", strArr);
        this.mActivityIntent = new Intent("android.intent.action.VIEW");
        this.mActivityIntent.setData(Uri.parse(stringBuffer.toString()));
        this.mActivityIntent.putExtra("pkg_name", activity.getPackageName());
        if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_6_0) < 0) {
            if (hasActivityForIntent()) {
                startAssitActivity(activity, iUiListener);
            }
            f.c("openSDK_LOG", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            f.c("openSDK_LOG", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (TemporaryStorage.set(SystemUtils.QZONE_SHARE_CALLBACK_ACTION, iUiListener) != null) {
                f.c("openSDK_LOG", "doShareToQzone() -- do listener onCancel()");
            }
            if (hasActivityForIntent()) {
                startAssistActivity(activity, Constants.REQUEST_QZONE_SHARE);
            }
        }
        if (hasActivityForIntent()) {
            d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, Constants.VIA_RESULT_SUCCESS, this.mViaShareQzoneType, Constants.VIA_RESULT_SUCCESS, Constants.VIA_TO_TYPE_QQ_GROUP, Constants.VIA_RESULT_SUCCESS);
            d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, a.f);
        } else {
            d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, Constants.VIA_TO_TYPE_QQ_GROUP, this.mViaShareQzoneType, Constants.VIA_RESULT_SUCCESS, Constants.VIA_TO_TYPE_QQ_GROUP, Constants.VIA_RESULT_SUCCESS);
            d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "hasActivityForIntent fail");
        }
        f.c("openSDK_LOG", "doShareToQzone() --end");
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    public void releaseResource() {
        TemporaryStorage.remove(SystemUtils.QZONE_SHARE_CALLBACK_ACTION);
    }

    public void shareToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        f.c("openSDK_LOG", "shareToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        String string = bundle.getString(SHARE_TO_QQ_TITLE);
        String string2 = bundle.getString(SHARE_TO_QQ_SUMMARY);
        String string3 = bundle.getString(SHARE_TO_QQ_TARGET_URL);
        ArrayList stringArrayList = bundle.getStringArrayList(SHARE_TO_QQ_IMAGE_URL);
        Object applicationLable = Util.getApplicationLable(activity);
        if (applicationLable == null) {
            applicationLable = bundle.getString(SHARE_TO_QQ_APP_NAME);
        } else if (applicationLable.length() > 20) {
            applicationLable = applicationLable.substring(0, 20) + "...";
        }
        int i = bundle.getInt(SHARE_TO_QZONE_KEY_TYPE);
        switch (i) {
            case SHARE_TO_QZONE_TYPE_IMAGE_TEXT /*1*/:
                this.mViaShareQzoneType = Constants.VIA_TO_TYPE_QQ_GROUP;
                break;
            case SHARE_TO_QZONE_TYPE_IMAGE /*5*/:
                this.mViaShareQzoneType = Constants.VIA_SSO_LOGIN;
                break;
            case SHARE_TO_QZONE_TYPE_APP /*6*/:
                this.mViaShareQzoneType = Constants.VIA_TO_TYPE_QZONE;
                break;
            default:
                this.mViaShareQzoneType = Constants.VIA_TO_TYPE_QQ_GROUP;
                break;
        }
        String str;
        switch (i) {
            case SHARE_TO_QZONE_TYPE_IMAGE_TEXT /*1*/:
                this.a = true;
                this.b = false;
                this.c = true;
                this.d = false;
                str = string3;
                string3 = string;
                string = str;
                break;
            case SHARE_TO_QZONE_TYPE_IMAGE /*5*/:
                iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                f.e("openSDK_LOG", "shareToQzone() error--end\u6682\u4e0d\u652f\u6301\u7eaf\u56fe\u7247\u5206\u4eab\u5230\u7a7a\u95f4\uff0c\u5efa\u8bae\u4f7f\u7528\u56fe\u6587\u5206\u4eab");
                d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "shareToQzone() \u6682\u4e0d\u652f\u6301\u7eaf\u56fe\u7247\u5206\u4eab\u5230\u7a7a\u95f4\uff0c\u5efa\u8bae\u4f7f\u7528\u56fe\u6587\u5206\u4eab");
                return;
            case SHARE_TO_QZONE_TYPE_APP /*6*/:
                if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_5_0_0) >= 0) {
                    string3 = String.format(ServerSetting.APP_DETAIL_PAGE, new Object[]{this.mToken.getAppId(), "mqq"});
                    bundle.putString(SHARE_TO_QQ_TARGET_URL, string3);
                    str = string3;
                    string3 = string;
                    string = str;
                    break;
                }
                iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                f.b("openSDK_LOG", "-->shareToQzone, app share is not support below qq5.0.");
                d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "shareToQzone, app share is not support below qq5.0.");
                return;
            default:
                if (!Util.isEmpty(string) || !Util.isEmpty(string2)) {
                    this.a = true;
                } else if (stringArrayList == null || stringArrayList.size() == 0) {
                    string = "\u6765\u81ea" + applicationLable + "\u7684\u5206\u4eab";
                    this.a = true;
                } else {
                    this.a = false;
                }
                this.b = false;
                this.c = true;
                this.d = false;
                str = string3;
                string3 = string;
                Object obj = str;
                break;
        }
        if (Util.hasSDCard() || SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_5_0) >= 0) {
            String str2;
            if (this.a) {
                if (TextUtils.isEmpty(obj)) {
                    iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                    f.e("openSDK_LOG", "shareToQzone() targetUrl null error--end");
                    d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                    return;
                } else if (!Util.isValidUrl(obj)) {
                    iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                    f.e("openSDK_LOG", "shareToQzone() targetUrl error--end");
                    d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, Constants.MSG_PARAM_TARGETURL_ERROR);
                    return;
                }
            }
            if (this.b) {
                string = a.f;
                string3 = a.f;
                bundle.putString(SHARE_TO_QQ_TITLE, string);
                bundle.putString(SHARE_TO_QQ_SUMMARY, string3);
            } else if (this.c && Util.isEmpty(string3)) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                f.e("openSDK_LOG", "shareToQzone() title is null--end");
                d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "shareToQzone() title is null");
                return;
            } else {
                if (!Util.isEmpty(string3) && string3.length() > v.C) {
                    bundle.putString(SHARE_TO_QQ_TITLE, Util.subString(string3, v.C, null, null));
                }
                if (!Util.isEmpty(string2) && string2.length() > cn.com.smartdevices.bracelet.chart.util.a.b) {
                    bundle.putString(SHARE_TO_QQ_SUMMARY, Util.subString(string2, cn.com.smartdevices.bracelet.chart.util.a.b, null, null));
                }
            }
            if (!TextUtils.isEmpty(applicationLable)) {
                bundle.putString(SHARE_TO_QQ_APP_NAME, applicationLable);
            }
            if (stringArrayList != null && (stringArrayList == null || stringArrayList.size() != 0)) {
                for (int i2 = 0; i2 < stringArrayList.size(); i2 += SHARE_TO_QZONE_TYPE_IMAGE_TEXT) {
                    str2 = (String) stringArrayList.get(i2);
                    if (!(Util.isValidUrl(str2) || Util.isValidPath(str2))) {
                        stringArrayList.remove(i2);
                    }
                }
                if (stringArrayList.size() == 0) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    f.e("openSDK_LOG", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                    d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "shareToQzone() \u975e\u6cd5\u7684\u56fe\u7247\u5730\u5740!");
                    return;
                }
                bundle.putStringArrayList(SHARE_TO_QQ_IMAGE_URL, stringArrayList);
            } else if (this.d) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                f.e("openSDK_LOG", "shareToQzone() imageUrl is null -- end");
                d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "shareToQzone() imageUrl is null");
                return;
            }
            if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_6_0) >= 0) {
                a.a((Context) activity, stringArrayList, new AsynLoadImgBack(this) {
                    final /* synthetic */ QzoneShare d;

                    public void batchSaved(int i, ArrayList<String> arrayList) {
                        if (i == 0) {
                            bundle.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, arrayList);
                        }
                        this.d.a(activity, bundle, iUiListener);
                    }

                    public void saved(int i, String str) {
                    }
                });
            } else if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_2_0) < 0 || SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_6_0) >= 0) {
                new TDialog(activity, a.f, getCommonDownloadQQUrl(a.f), null, this.mToken).show();
            } else {
                QQShare qQShare = new QQShare(activity, this.mToken);
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    str2 = (String) stringArrayList.get(0);
                    if (i != SHARE_TO_QZONE_TYPE_IMAGE || Util.fileExists(str2)) {
                        bundle.putString(SHARE_TO_QQ_IMAGE_LOCAL_URL, str2);
                    } else {
                        iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                        f.e("openSDK_LOG", "shareToQzone()\u624bQ\u7248\u672c\u8fc7\u4f4e\uff0c\u7eaf\u56fe\u5206\u4eab\u4e0d\u652f\u6301\u7f51\u8def\u56fe\u7247");
                        d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "shareToQzone()\u624bQ\u7248\u672c\u8fc7\u4f4e\uff0c\u7eaf\u56fe\u5206\u4eab\u4e0d\u652f\u6301\u7f51\u8def\u56fe\u7247");
                        return;
                    }
                }
                if (SystemUtils.compareQQVersion(activity, SystemUtils.QQ_VERSION_NAME_4_5_0) >= 0) {
                    bundle.putInt(SHARE_TO_QQ_EXT_INT, SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
                }
                qQShare.shareToQQ(activity, bundle, iUiListener);
            }
            f.c("openSDK_LOG", "shareToQzone() --end");
            return;
        }
        iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
        f.e("openSDK_LOG", "shareToQzone() sdcard is null--end");
        d.a().a(SHARE_TO_QZONE_TYPE_IMAGE_TEXT, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, SHARE_TO_QZONE_TYPE_IMAGE_TEXT, Constants.MSG_SHARE_NOSD_ERROR);
    }
}
