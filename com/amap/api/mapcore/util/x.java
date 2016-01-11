package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.gps.services.ay;
import com.amap.api.location.LocationManagerProxy;
import com.d.a.a.C1012a;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class x {
    public static int a = -1;
    public static String b = a.f;
    private static ad c;
    private static String d = "http://apiinit.amap.com/v3/log/init";

    private static String a() {
        return d;
    }

    private static Map<String, String> a(Context context) {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("resType", "json");
            hashMap.put("encode", h.DEFAULT_CHARSET);
            hashMap.put("ec", Constants.VIA_TO_TYPE_QQ_GROUP);
            String a = y.a();
            hashMap.put(ay.H, a);
            hashMap.put("scode", y.a(context, a, ae.a("resType=json&encode=UTF-8&ec=1")));
        } catch (Throwable th) {
            az.a(th, "Auth", "gParams");
            th.printStackTrace();
        }
        return hashMap;
    }

    public static void a(String str) {
        w.a(str);
    }

    public static synchronized boolean a(Context context, ad adVar) {
        boolean z;
        synchronized (x.class) {
            c = adVar;
            z = true;
            try {
                String a = a();
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                hashMap.put(C1012a.f, C1012a.g);
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", c.b);
                hashMap.put("X-INFO", y.a(context, c, null));
                hashMap.put("ia", Constants.VIA_TO_TYPE_QQ_GROUP);
                hashMap.put(C0430g.b, w.f(context));
                bt a2 = bt.a();
                bu afVar = new af();
                afVar.setProxy(ac.a(context));
                afVar.a(hashMap);
                afVar.b(a(context));
                afVar.a(a);
                z = a(a2.a(afVar));
            } catch (Throwable th) {
                az.a(th, "Auth", "getAuth");
                th.printStackTrace();
            }
        }
        return z;
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has(LocationManagerProxy.KEY_STATUS_CHANGED)) {
                int i = jSONObject.getInt(LocationManagerProxy.KEY_STATUS_CHANGED);
                if (i == 1) {
                    a = 1;
                } else if (i == 0) {
                    a = 0;
                }
            }
            if (jSONObject.has(o.n)) {
                b = jSONObject.getString(o.n);
            }
            if (a == 0) {
                Log.i("AuthFailure", b);
            }
            return a == 1;
        } catch (Throwable e) {
            az.a(e, "Auth", "lData");
            e.printStackTrace();
            return false;
        } catch (Throwable e2) {
            az.a(e2, "Auth", "lData");
            e2.printStackTrace();
            return false;
        }
    }
}
