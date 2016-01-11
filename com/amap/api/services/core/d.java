package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.a.C0113o;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.e.a;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;

public class d {
    private static d a = null;
    private static Context b = null;
    private static TelephonyManager c;
    private static ConnectivityManager d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i = a.f;
    private static String j = a.f;

    private d() {
    }

    public static d a(Context context) {
        if (a == null) {
            a = new d();
            b = context;
            c = (TelephonyManager) b.getSystemService("phone");
            d = (ConnectivityManager) b.getSystemService("connectivity");
            e = b.getApplicationContext().getPackageName();
            f = j();
            g = g();
            h = i();
            i = b(b);
            j = e.b(b);
        }
        return a;
    }

    public static String b(Context context) {
        if (i == null || i.equals(a.f)) {
            try {
                i = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h).metaData.getString("com.amap.api.v2.apikey");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static String g() {
        String str = a.f;
        try {
            PackageManager packageManager = b.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(b.getPackageName(), 0));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String i() {
        PackageManager packageManager = b.getPackageManager();
        String str = a.f;
        try {
            return packageManager.getPackageInfo(b.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String j() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        f = i2 > i ? i + "*" + i2 : i2 + "*" + i;
        return f;
    }

    public String a() {
        KeyGenerator instance;
        Exception e;
        try {
            instance = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            instance = null;
        }
        instance.init(PersonInfo.INCOMING_CALL_DISABLE_BIT);
        byte[] encoded = instance.generateKey().getEncoded();
        try {
            Object a = h.a(encoded, h.a(b));
            Object a2 = h.a(encoded, b().getBytes(kankan.wheel.widget.a.bO));
            encoded = new byte[(a.length + a2.length)];
            try {
                System.arraycopy(a, 0, encoded, 0, a.length);
                System.arraycopy(a2, 0, encoded, a.length, a2.length);
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return h.b(h.a(encoded));
            }
        } catch (Exception e4) {
            Exception exception = e4;
            encoded = null;
            e = exception;
            e.printStackTrace();
            return h.b(h.a(encoded));
        }
        return h.b(h.a(encoded));
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ia=1&");
        if (i != null && i.length() > 0) {
            stringBuilder.append("key=");
            stringBuilder.append(i);
            stringBuilder.append("&");
        }
        stringBuilder.append("ct=android");
        String deviceId = c.getDeviceId();
        String subscriberId = c.getSubscriberId();
        stringBuilder.append("&ime=" + deviceId);
        stringBuilder.append("&sim=" + subscriberId);
        stringBuilder.append("&pkg=" + e);
        stringBuilder.append("&mod=");
        stringBuilder.append(d());
        stringBuilder.append("&sv=");
        stringBuilder.append(c());
        stringBuilder.append("&nt=");
        stringBuilder.append(e());
        deviceId = c.getNetworkOperatorName();
        stringBuilder.append("&np=");
        stringBuilder.append(deviceId);
        stringBuilder.append("&ctm=" + System.currentTimeMillis());
        stringBuilder.append("&re=" + f);
        stringBuilder.append("&av=V2.3.0");
        stringBuilder.append("&apn=" + g);
        stringBuilder.append("&apv=" + h);
        stringBuilder.append("&pro=sea");
        return stringBuilder.toString();
    }

    public String c() {
        return VERSION.RELEASE;
    }

    public String d() {
        return Build.MODEL;
    }

    public String e() {
        if (b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return a.f;
        }
        if (d == null) {
            return a.f;
        }
        NetworkInfo activeNetworkInfo = d.getActiveNetworkInfo();
        return activeNetworkInfo == null ? a.f : activeNetworkInfo.getTypeName();
    }

    public String f() {
        return i;
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(j).append(e);
        return stringBuffer.toString();
    }
}
