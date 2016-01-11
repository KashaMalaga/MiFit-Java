package cn.com.smartdevices.bracelet.shoes.c;

import android.content.Context;
import android.telephony.TelephonyManager;

public class g {
    public static String a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? null : telephonyManager.getDeviceId();
    }
}
