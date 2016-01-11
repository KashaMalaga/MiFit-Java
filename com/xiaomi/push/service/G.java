package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.e.d;

public class G {
    private static String a = null;
    private static String b = null;
    private static String c = null;

    public static String a(Context context) {
        String str = null;
        if (b == null) {
            String string;
            String b = b(context);
            try {
                string = Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                c.a(th);
                string = null;
            }
            if (VERSION.SDK_INT > 8) {
                str = Build.SERIAL;
            }
            b = "a-" + d.a(b + string + str);
        }
        return b;
    }

    public static String b(Context context) {
        if (a != null) {
            return a;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String deviceId = telephonyManager.getDeviceId();
            int i = 10;
            while (deviceId == null) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                deviceId = telephonyManager.getDeviceId();
                i = i2;
            }
            if (deviceId != null) {
                a = deviceId;
            }
            return deviceId;
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (G.class) {
            if (c != null) {
                str = c;
            } else {
                String string;
                try {
                    string = Secure.getString(context.getContentResolver(), "android_id");
                } catch (Throwable th) {
                    c.a(th);
                    string = null;
                }
                c = d.a(string + (VERSION.SDK_INT > 8 ? Build.SERIAL : null));
                str = c;
            }
        }
        return str;
    }

    public static String d(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }
}
