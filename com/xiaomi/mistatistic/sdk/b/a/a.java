package com.xiaomi.mistatistic.sdk.b.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.d.a.a.h;
import com.xiaomi.market.sdk.o;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.C1125b;
import com.xiaomi.mistatistic.sdk.b.E;
import com.xiaomi.mistatistic.sdk.b.F;
import com.xiaomi.mistatistic.sdk.b.p;
import com.xiaomi.mistatistic.sdk.b.r;
import com.xiaomi.mistatistic.sdk.b.y;
import com.xiaomi.mistatistic.sdk.c.d;
import com.xiaomi.mistatistic.sdk.c.f;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class a implements p {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(b(str));
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$032X", new Object[]{bigInteger});
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    private static byte[] b(String str) {
        try {
            return str.getBytes(h.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public void a() {
        Context a = C1125b.a();
        if (!E.a(a, "basic_info_reported")) {
            a(a);
            E.b(a, "basic_info_reported", 1);
            new F().a();
        }
        String e = C1125b.e();
        Object a2 = E.a(a, "basic_info_version", com.xiaomi.e.a.f);
        if (!(TextUtils.isEmpty(a2) || a2.equals(e))) {
            y.a(new d("mistat_basic", "upgrade"));
        }
        E.b(a, "basic_info_version", e);
    }

    public void a(Context context) {
        y.a(new d("mistat_basic", "new"));
        y.a(new f("mistat_basic", "model", Build.MODEL));
        y.a(new f("mistat_basic", "OS", MiPushMessageReceiver.ANDROID + VERSION.SDK_INT));
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!TextUtils.isEmpty(telephonyManager.getNetworkOperatorName())) {
            y.a(new f("mistat_basic", "operator", telephonyManager.getSimOperator()));
        }
        String b = r.b(context);
        if (!TextUtils.isEmpty(b)) {
            y.a(new f("mistat_basic", "imei_md5", a(b)));
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    b = connectionInfo.getMacAddress();
                    if (!TextUtils.isEmpty(b)) {
                        y.a(new f("mistat_basic", "mac_md5", a(b)));
                    }
                }
            }
        } catch (Throwable th) {
            new A().a(com.xiaomi.e.a.f, th);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            y.a(new f("mistat_basic", o.p, i < i2 ? i + "x" + i2 : i2 + "x" + i));
        }
        y.a(new f("mistat_basic", "locale", Locale.getDefault().toString()));
    }
}
