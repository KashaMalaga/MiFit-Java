package com.amap.api.mapcore.util;

import android.content.Context;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.mapcore.n;
import com.tencent.connect.common.Constants;
import com.xiaomi.market.sdk.o;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

public class q extends bu {
    private Context d;
    private String e;

    public q(Context context) {
        this.d = context;
        this.e = w.f(context);
    }

    private r a(byte[] bArr) {
        String str = "loadData";
        if (bArr == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            str = jSONObject.optString(LocationManagerProxy.KEY_STATUS_CHANGED);
            if (Constants.VIA_RESULT_SUCCESS.equals(str) || !Constants.VIA_TO_TYPE_QQ_GROUP.equals(str)) {
                return null;
            }
            JSONObject a = a(jSONObject, C0483q.g);
            return new r(a(b(a(a(a, "common"), "commoninfo"), "com_isupload")), a(b(a(a(a, "exception"), "exceptinfo"), "ex_isupload")));
        } catch (Throwable e) {
            az.a(e, "ManifestManager", "loadData");
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject, String str) {
        return jSONObject == null ? null : jSONObject.optJSONObject(str);
    }

    private boolean a(String str) {
        return str != null && str.equals(Constants.VIA_TO_TYPE_QQ_GROUP);
    }

    private String b(JSONObject jSONObject, String str) {
        return jSONObject == null ? null : jSONObject.optString(str);
    }

    public r a() {
        String str = "feachManifest";
        try {
            bt a = bt.a(false);
            setProxy(ac.a(this.d));
            return a(a.a((bu) this));
        } catch (Throwable e) {
            az.a(e, "ManifestManager", str);
            return null;
        }
    }

    public HttpEntity getEntity() {
        return null;
    }

    public Map<String, String> getParams() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(C0430g.b, this.e);
        hashMap.put("opertype", "common;exception");
        hashMap.put("plattype", MiPushMessageReceiver.ANDROID);
        hashMap.put("product", n.b);
        hashMap.put(o.x, "V2.4.1");
        hashMap.put("ext", "standard");
        hashMap.put("output", "json");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(this.e);
        stringBuffer.append("&opertype=common;exception");
        stringBuffer.append("&plattype=android");
        stringBuffer.append("&product=").append(n.b);
        stringBuffer.append("&version=").append("V2.4.1");
        stringBuffer.append("&ext=standard");
        stringBuffer.append("&output=json");
        String a = ae.a(stringBuffer.toString());
        String a2 = y.a();
        hashMap.put(ay.H, a2);
        hashMap.put("scode", y.a(this.d, a2, a));
        return hashMap;
    }

    public Map<String, String> getRequestHead() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("User-Agent", n.c);
        return hashMap;
    }

    public String getURL() {
        return "http://restapi.amap.com/v3/config/resource";
    }
}
