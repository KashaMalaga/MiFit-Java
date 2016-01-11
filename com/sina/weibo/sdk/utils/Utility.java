package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xiaomi.e.a;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.UUID;

public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split2[0], DEFAULT_CHARSET), URLDecoder.decode(split2[1], DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", a.f);
    }

    public static String generateUA(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
        stringBuilder.append("_");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("_");
        stringBuilder.append("weibosdk");
        stringBuilder.append("_");
        stringBuilder.append(WBConstants.WEIBO_SDK_VERSION_CODE);
        stringBuilder.append("_android");
        return stringBuilder.toString();
    }

    public static String getAid(Context context, String str) {
        AidTask instance = AidTask.getInstance(context);
        Object loadAidFromCache = instance.loadAidFromCache();
        if (!TextUtils.isEmpty(loadAidFromCache)) {
            return loadAidFromCache;
        }
        instance.aidTaskInit(str);
        return a.f;
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    return MD5.hexdigest(toByteArray2);
                }
            }
            return null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean isChineseLocale(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            return Locale.CHINA.equals(locale) || Locale.CHINESE.equals(locale) || Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TAIWAN.equals(locale);
        } catch (Exception e) {
            return true;
        }
    }

    public static Bundle parseUri(String str) {
        try {
            return decodeUrl(new URI(str).getQuery());
        } catch (Exception e) {
            return new Bundle();
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static String safeString(String str) {
        return TextUtils.isEmpty(str) ? a.f : str;
    }
}
