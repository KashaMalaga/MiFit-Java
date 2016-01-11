package com.amap.api.location.core;

import android.content.Context;
import android.util.Log;
import com.amap.api.location.LocationManagerProxy;
import com.b.aa;
import com.d.a.a.h;
import com.xiaomi.market.sdk.o;
import java.util.Arrays;
import org.json.JSONObject;

public class a {
    static String a = com.xiaomi.e.a.f;
    private static int b = -1;

    public static int a() {
        return b;
    }

    public static String a(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : split) {
            stringBuffer.append(append);
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    public static synchronized boolean a(Context context) {
        boolean c;
        synchronized (a.class) {
            try {
                byte[] c2 = c();
                String a = aa.a().a(context, b(), c2, "loc");
                if (a != null) {
                    c = c(a);
                } else {
                    b = 0;
                    c = true;
                }
                if (b != 1) {
                    b = 0;
                }
            } catch (Throwable th) {
                if (b != 1) {
                    b = 0;
                }
            }
        }
        return c;
    }

    private static String b() {
        return "http://apiinit.amap.com/v3/log/init";
    }

    public static String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a = d.a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + d.a(a, str));
        return stringBuffer.toString();
    }

    private static boolean c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(LocationManagerProxy.KEY_STATUS_CHANGED)) {
                int i = jSONObject.getInt(LocationManagerProxy.KEY_STATUS_CHANGED);
                if (i == 1) {
                    b = 1;
                } else if (i == 0) {
                    b = 0;
                }
            }
            if (jSONObject.has(o.n)) {
                a = jSONObject.getString(o.n);
            }
            if (b == 0) {
                Log.i("AuthFailure", a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            b = 0;
        }
        return b == 1;
    }

    private static byte[] c() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("resType=json&encode=UTF-8&ec=1");
            return b(a(stringBuffer.toString())).toString().getBytes(h.DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
