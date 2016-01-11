package com.g.a.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.support.v4.view.a.C0113o;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.d.a.a.h;
import com.g.a.b.b;
import com.g.a.p;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public abstract class v {
    private static Map<String, String> a;

    protected static String a(Context context) {
        Object obj = u.d;
        if (TextUtils.isEmpty(obj)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h);
                if (applicationInfo != null) {
                    String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                    if (string != null) {
                        return string.trim();
                    }
                    r.b(p.e, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
                }
            } catch (Exception e) {
                r.b(p.e, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", e);
            }
            return null;
        }
        r.b(p.e, "use usefully appkey from constant field.");
        return obj;
    }

    private static String a(List<NameValuePair> list) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new UrlEncodedFormEntity(list, h.DEFAULT_CHARSET).writeTo(byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<NameValuePair> a(a... aVarArr) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        for (a aVar : aVarArr) {
            stringBuilder.append(aVar.b().toString());
            stringBuilder.append(',');
            stringBuilder2.append(aVar.c());
            stringBuilder2.append(',');
            stringBuilder3.append(aVar.a());
            stringBuilder3.append(',');
        }
        if (aVarArr.length > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            stringBuilder3.deleteCharAt(stringBuilder3.length() - 1);
        }
        List<NameValuePair> arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(Constants.PARAM_PLATFORM, stringBuilder.toString()));
        arrayList.add(new BasicNameValuePair("usid", stringBuilder2.toString()));
        if (stringBuilder3.length() > 0) {
            arrayList.add(new BasicNameValuePair("weiboid", stringBuilder3.toString()));
        }
        return arrayList;
    }

    private static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    protected static String[] a(Context context, String str, a... aVarArr) {
        if (aVarArr == null || aVarArr.length == 0) {
            throw new q("platform data is null");
        }
        Object a = a(context);
        if (TextUtils.isEmpty(a)) {
            throw new q("can`t get appkey.");
        }
        List arrayList = new ArrayList();
        String str2 = "http://log.umsns.com/share/api/" + a + "/";
        if (a == null || a.isEmpty()) {
            a = c(context);
        }
        if (!(a == null || a.isEmpty())) {
            for (Entry entry : a.entrySet()) {
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        arrayList.add(new BasicNameValuePair(g.a, String.valueOf(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair(b.c, u.e));
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new BasicNameValuePair(NativeInterface.PARAM_SHARE_TOPIC, str));
        }
        arrayList.addAll(a(aVarArr));
        String b = b(aVarArr);
        if (b == null) {
            b = "null";
        }
        r.c(p.e, "URL:" + new StringBuilder(String.valueOf(str2)).append("?").append(a(arrayList)).toString());
        r.c(p.e, "BODY:" + b);
        return new String[]{r1, b};
    }

    private static String b(a... aVarArr) {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : aVarArr) {
            b e = aVar.e();
            CharSequence d = aVar.d();
            if (e == null) {
                try {
                    if (TextUtils.isEmpty(d)) {
                    }
                } catch (Throwable e2) {
                    throw new q("build body exception", e2);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(f.B, e == null ? a.f : String.valueOf(e.c));
            jSONObject2.put("name", d == null ? a.f : String.valueOf(d));
            jSONObject.put(aVar.b().toString(), jSONObject2);
        }
        return jSONObject.length() == 0 ? null : jSONObject.toString();
    }

    public static Map<String, String> b(Context context) {
        CharSequence deviceId;
        CharSequence d;
        CharSequence string;
        Map<String, String> hashMap = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            r.e(p.e, "No IMEI.");
        }
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                deviceId = telephonyManager.getDeviceId();
                d = d(context);
                string = Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(d)) {
                    hashMap.put(g.q, d);
                }
                if (!TextUtils.isEmpty(deviceId)) {
                    hashMap.put(o.z, deviceId);
                }
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put("android_id", string);
                }
                return hashMap;
            }
        } catch (Exception e) {
            r.e(p.e, "No IMEI.", e);
        }
        deviceId = null;
        d = d(context);
        string = Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(d)) {
            hashMap.put(g.q, d);
        }
        if (TextUtils.isEmpty(deviceId)) {
            hashMap.put(o.z, deviceId);
        }
        if (TextUtils.isEmpty(string)) {
            hashMap.put("android_id", string);
        }
        return hashMap;
    }

    private static Map<String, String> c(Context context) {
        Map<String, String> hashMap = new HashMap();
        Map b = b(context);
        if (b == null || b.isEmpty()) {
            throw new q("can`t get device id.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry entry : b.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getValue())) {
                stringBuilder2.append((String) entry.getKey()).append(com.xiaomi.mipush.sdk.f.i);
                stringBuilder.append((String) entry.getValue()).append(com.xiaomi.mipush.sdk.f.i);
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            hashMap.put(g.t, stringBuilder.toString());
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            hashMap.put("idtype", stringBuilder2.toString());
        }
        return hashMap;
    }

    private static String d(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            r.e(p.e, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return a.f;
        } catch (Exception e) {
            r.e(p.e, "Could not get mac address." + e.toString());
        }
    }
}
