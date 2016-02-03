package com.tencent.open.utils;

import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import com.amap.api.location.LocationManagerProxy;
import com.d.a.a.C1012a;
import com.d.a.a.h;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils.HttpStatusException;
import com.tencent.open.utils.HttpUtils.NetworkUnavailableException;
import com.xiaomi.channel.b.v;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class Util {
    private static final String a = ("openSDK_LOG." + Util.class.getName());
    private static String b = a.f;
    private static String c = a.f;
    private static String d = a.f;
    private static String e = a.f;
    private static int f = -1;
    private static String g;
    private static boolean h = true;
    private static String i = "0123456789ABCDEF";

    final class AnonymousClass1 extends Thread {
        final /* synthetic */ Context a;
        final /* synthetic */ Bundle b;

        AnonymousClass1(Context context, Bundle bundle) {
            this.a = context;
            this.b = bundle;
        }

        public void run() {
            try {
                HttpUtils.openUrl2(this.a, "http://cgi.qplus.com/report/report", Constants.HTTP_GET, this.b);
            } catch (Exception e) {
                f.e(Util.a, "reportBernoulli has exception: " + e.getMessage());
            }
        }
    }

    public class Statistic {
        public long reqSize;
        public String response;
        public long rspSize;

        public Statistic(String str, int i) {
            this.response = str;
            this.reqSize = (long) i;
            if (this.response != null) {
                this.rspSize = (long) this.response.length();
            }
        }
    }

    class TBufferedOutputStream extends BufferedOutputStream {
        private int a = 0;

        public TBufferedOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public int getLength() {
            return this.a;
        }

        public void write(byte[] bArr) {
            super.write(bArr);
            this.a += bArr.length;
        }
    }

    private static char a(int i) {
        int i2 = i & 15;
        return i2 < 10 ? (char) (i2 + 48) : (char) ((i2 - 10) + 97);
    }

    private static String a(HttpResponse httpResponse) {
        String str = a.f;
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf(C1012a.g) <= -1) ? content : new GZIPInputStream(content);
        byte[] bArr = new byte[C0113o.j];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read == -1) {
                return new String(byteArrayOutputStream.toByteArray(), h.DEFAULT_CHARSET);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    private static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (SystemUtils.compareVersion(str, "4.3") < 0 || str.startsWith("4.4")) {
                return false;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return false;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(signatureArr[0].toByteArray());
                String toHexString = toHexString(instance.digest());
                instance.reset();
                str = "d8391a394d4a179e6fe7bdb8a301258b";
                return toHexString.equals("d8391a394d4a179e6fe7bdb8a301258b");
            } catch (NoSuchAlgorithmException e) {
                f.e(a, "isQQBrowerAvailable has exception: " + e.getMessage());
                return false;
            }
        } catch (NameNotFoundException e2) {
            return false;
        }
    }

    public static boolean checkNetWork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo isConnectedOrConnecting : allNetworkInfo) {
            if (isConnectedOrConnecting.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }

    public static Bundle composeHaboCgiReportParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PARAM_PLATFORM, Constants.VIA_TO_TYPE_QQ_GROUP);
        bundle.putString(C0483q.g, str);
        bundle.putString(b.a, str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString(SocialConstants.PARAM_APP_ID, str7);
        bundle.putString(v.e, str8);
        bundle.putString(cn.com.smartdevices.bracelet.j.f.au, str9);
        bundle.putString("os_ver", VERSION.RELEASE);
        bundle.putString(LocationManagerProxy.NETWORK_PROVIDER, com.tencent.open.b.a.a(Global.getContext()));
        bundle.putString("apn", com.tencent.open.b.a.b(Global.getContext()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", Constants.SDK_VERSION);
        bundle.putString(ParamKey.PACKAGENAME, Global.getPackageName());
        bundle.putString("app_ver", getAppVersionName(Global.getContext(), Global.getPackageName()));
        return bundle;
    }

    public static Bundle composeViaReportParams(String str, String str2, String str3, String str4, String str5, String str6) {
        return composeViaReportParams(str, str3, str4, str2, str5, str6, a.f, a.f, a.f, a.f, a.f, a.f);
    }

    public static Bundle composeViaReportParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString(SocialConstants.PARAM_OPEN_ID, str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString(v.u, str5);
        bundle.putString(C0483q.g, str6);
        bundle.putString(com.xiaomi.channel.relationservice.data.a.h, str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        return bundle;
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            return bundle;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject decodeUrlToJson(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    try {
                        jSONObject.put(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                    } catch (JSONException e) {
                        f.e(a, "decodeUrlToJson has exception: " + e.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String str2 : bundle.keySet()) {
            int i2 = i + 1;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"" + "\r\n" + "\r\n" + ((String) obj));
                if (i2 < size - 1) {
                    stringBuilder.append("\r\n--" + str + "\r\n");
                }
                i = i2;
            } else {
                i = i2;
            }
        }
        return stringBuilder.toString();
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return a.f;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            Object obj2 = bundle.get(str);
            if ((obj2 instanceof String) || (obj2 instanceof String[])) {
                Object obj3;
                if (obj2 instanceof String[]) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                stringBuilder.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                stringBuilder.append(URLEncoder.encode(com.xiaomi.mipush.sdk.f.i + stringArray[i]));
                            }
                        }
                    }
                    obj3 = obj;
                } else {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                    obj3 = obj;
                }
                obj = obj3;
            }
        }
        return stringBuilder.toString();
    }

    public static String encrypt(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(getBytesUTF8(str));
            byte[] digest = instance.digest();
            if (digest != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i : digest) {
                    stringBuilder.append(a(i >>> 4));
                    stringBuilder.append(a(i));
                }
                str = stringBuilder.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            f.e(a, "encrypt has exception: " + e.getMessage());
        }
        return str;
    }

    public static boolean fileExists(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file != null && file.exists();
    }

    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            f.e(a, "getAppVersion error" + e.getMessage());
            return a.f;
        }
    }

    public static String getAppVersionName(Context context, String str) {
        if (context == null) {
            return a.f;
        }
        getPackageInfo(context, str);
        return b;
    }

    public static final String getApplicationLable(Context context) {
        if (context != null) {
            CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            if (applicationLabel != null) {
                return applicationLabel.toString();
            }
        }
        return null;
    }

    public static byte[] getBytesUTF8(String str) {
        try {
            return str.getBytes(h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String getLocation(Context context) {
        if (context == null) {
            return a.f;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(com.xiaomi.channel.relationservice.data.a.l);
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation == null) {
                    return a.f;
                }
                double latitude = lastKnownLocation.getLatitude();
                g = latitude + "*" + lastKnownLocation.getLongitude();
                return g;
            }
        } catch (Throwable e) {
            f.b("getLocation", "getLocation>>>", e);
        }
        return a.f;
    }

    public static void getPackageInfo(Context context, String str) {
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                c = packageInfo.versionName;
                b = c.substring(0, c.lastIndexOf(46));
                e = c.substring(c.lastIndexOf(46) + 1, c.length());
                f = packageInfo.versionCode;
            } catch (NameNotFoundException e) {
                f.e(a, "getPackageInfo has exception: " + e.getMessage());
            } catch (Exception e2) {
                f.e(a, "getPackageInfo has exception: " + e2.getMessage());
            }
        }
    }

    public static String getQUA3(Context context, String str) {
        if (context == null) {
            return a.f;
        }
        d = getAppVersionName(context, str);
        return d;
    }

    public static String getUserIp() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            logd("Tencent-Util", e.toString());
        }
        return a.f;
    }

    public static String getVersionName(Context context, String str) {
        if (context == null) {
            return a.f;
        }
        getPackageInfo(context, str);
        return c;
    }

    public static boolean hasSDCard() {
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = Environment.getExternalStorageDirectory();
        }
        return file != null;
    }

    public static String hexToString(String str) {
        int i = 0;
        if ("0x".equals(str.substring(0, 2))) {
            str = str.substring(2);
        }
        byte[] bArr = new byte[(str.length() / 2)];
        while (i < bArr.length) {
            try {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) & HeartRateInfo.HR_EMPTY_VALUE);
            } catch (Exception e) {
                f.e(a, "hexToString has exception: " + e.getMessage());
            }
            i++;
        }
        try {
            return new String(bArr, kankan.wheel.widget.a.bO);
        } catch (Exception e2) {
            f.e(a, "hexToString has exception: " + e2.getMessage());
            return str;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isMobileQQSupportShare(Context context) {
        try {
            return SystemUtils.compareVersion(context.getPackageManager().getPackageInfo(Constants.PACKAGE_QQ, 0).versionName, "4.1") >= 0;
        } catch (NameNotFoundException e) {
            f.b("checkMobileQQ", com.xiaomi.account.openauth.h.P);
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static final boolean isValidPath(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file != null && file.exists();
    }

    public static final boolean isValidUrl(String str) {
        return str == null ? false : str.startsWith("http://") || str.startsWith("https://");
    }

    public static void logd(String str, String str2) {
        if (h) {
            f.b(str, str2);
        }
    }

    public static boolean openBrowser(Context context, String str) {
        boolean a;
        try {
            a = a(context);
            if (a) {
                try {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } catch (Exception e) {
                    if (a) {
                        try {
                            a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                        } catch (Exception e2) {
                            try {
                                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                            } catch (Exception e3) {
                                try {
                                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                                } catch (Exception e4) {
                                    return false;
                                }
                            }
                        }
                    }
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    } catch (Exception e5) {
                        try {
                            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        } catch (Exception e6) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
        } catch (Exception e7) {
            a = false;
            if (a) {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
            } else {
                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
            }
            return true;
        }
        return true;
    }

    public static int parseIntValue(String str) {
        return parseIntValue(str, 0);
    }

    public static int parseIntValue(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return i;
    }

    public static JSONObject parseJson(String str) {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static JSONObject parseUrlToJson(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject decodeUrlToJson = decodeUrlToJson(null, url.getQuery());
            decodeUrlToJson(decodeUrlToJson, url.getRef());
            return decodeUrlToJson;
        } catch (MalformedURLException e) {
            return new JSONObject();
        }
    }

    public static void reportBernoulli(Context context, String str, long j, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", Constants.SDK_VERSION);
        if (j != 0) {
            bundle.putLong("elt", j);
        }
        new AnonymousClass1(context, bundle).start();
    }

    public static void showAlert(Context context, String str, String str2) {
        Builder builder = new Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }

    public static final String subString(String str, int i, String str2, String str3) {
        Exception exception;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return a.f;
        }
        String str4 = h.DEFAULT_CHARSET;
        if (TextUtils.isEmpty(str2)) {
            str2 = str4;
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i3 = 0;
            while (i2 < str.length()) {
                int length = str.substring(i2, i2 + 1).getBytes(str2).length;
                if (i3 + length > i) {
                    String substring = str.substring(0, i2);
                    try {
                        if (!TextUtils.isEmpty(str3)) {
                            substring = substring + str3;
                        }
                        return substring;
                    } catch (Exception e) {
                        str = substring;
                        exception = e;
                        System.out.println("StructMsg sSubString error : " + exception.getMessage());
                        return str;
                    }
                }
                i3 += length;
                i2++;
            }
            return str;
        } catch (Exception e2) {
            exception = e2;
            System.out.println("StructMsg sSubString error : " + exception.getMessage());
            return str;
        }
    }

    public static String toHexString(String str) {
        byte[] bytesUTF8 = getBytesUTF8(str);
        StringBuilder stringBuilder = new StringBuilder(bytesUTF8.length * 2);
        for (int i = 0; i < bytesUTF8.length; i++) {
            stringBuilder.append(i.charAt((bytesUTF8[i] & RunningReminderInfo.b) >> 4));
            stringBuilder.append(i.charAt((bytesUTF8[i] & 15) >> 0));
        }
        return stringBuilder.toString();
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & HeartRateInfo.HR_EMPTY_VALUE, 16);
            if (num.length() == 1) {
                num = Constants.VIA_RESULT_SUCCESS + num;
            }
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static Statistic upload(Context context, String str, Bundle bundle) {
        int size;
        int i;
        byte[] byteArray;
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
                }
            }
        }
        Bundle bundle2 = new Bundle(bundle);
        String str2 = a.f;
        str2 = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        HttpClient httpClient = HttpUtils.getHttpClient(context, str2, str);
        HttpUriRequest httpPost = new HttpPost(str);
        Bundle bundle3 = new Bundle();
        for (String str22 : bundle2.keySet()) {
            Object obj = bundle2.get(str22);
            if (obj instanceof byte[]) {
                bundle3.putByteArray(str22, (byte[]) obj);
            }
        }
        httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        httpPost.setHeader("Connection", "Keep-Alive");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(getBytesUTF8("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
        byteArrayOutputStream.write(getBytesUTF8(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
        if (!bundle3.isEmpty()) {
            size = bundle3.size();
            byteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            i = -1;
            for (String str222 : bundle3.keySet()) {
                i++;
                byteArrayOutputStream.write(getBytesUTF8("Content-Disposition: form-data; name=\"" + str222 + "\"; filename=\"" + "value.file" + "\"" + "\r\n"));
                byteArrayOutputStream.write(getBytesUTF8("Content-Type: application/octet-stream\r\n\r\n"));
                byteArray = bundle3.getByteArray(str222);
                if (byteArray != null) {
                    byteArrayOutputStream.write(byteArray);
                }
                if (i < size - 1) {
                    byteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                }
            }
        }
        byteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
        byteArray = byteArrayOutputStream.toByteArray();
        i = byteArray.length + 0;
        byteArrayOutputStream.close();
        httpPost.setEntity(new ByteArrayEntity(byteArray));
        HttpResponse execute = httpClient.execute(httpPost);
        size = execute.getStatusLine().getStatusCode();
        if (size == v.C) {
            return new Statistic(a(execute), i);
        }
        throw new HttpStatusException(HttpStatusException.ERROR_INFO + size);
    }
}
