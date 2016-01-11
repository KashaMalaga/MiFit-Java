package com.xiaomi.mistatistic.sdk.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.amap.api.location.LocationManagerProxy;
import com.d.a.a.C1012a;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.v;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.mistatistic.sdk.c.a;
import com.xiaomi.mistatistic.sdk.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class u {
    private static u a = new u();
    private C1124a b = new v(this);
    private List c = new LinkedList();
    private Handler d = new w(this, Looper.getMainLooper());

    private u() {
    }

    public static u a() {
        return a;
    }

    private boolean a(List list) {
        Map hashMap = new HashMap();
        for (a aVar : list) {
            CharSequence a = aVar.a();
            if (!TextUtils.isEmpty(a)) {
                if (hashMap.containsKey(a)) {
                    ((List) hashMap.get(a)).add(aVar);
                } else {
                    hashMap.put(a, new ArrayList());
                    ((List) hashMap.get(a)).add(aVar);
                }
            }
        }
        if (hashMap.isEmpty()) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : hashMap.keySet()) {
            JSONArray jSONArray2 = new JSONArray();
            for (a e : (List) hashMap.get(str)) {
                jSONArray2.put(e.e());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SocialConstants.PARAM_URL, str);
            jSONObject.put(b.b, jSONArray2);
            jSONArray.put(jSONObject);
        }
        return a(jSONArray.toString());
    }

    private String f() {
        return com.xiaomi.mistatistic.sdk.a.a() ? "http://10.99.168.145:8097/realtime_network" : "https://data.mistat.xiaomi.com/realtime_network";
    }

    public void a(C1124a c1124a) {
        this.b = c1124a;
    }

    public void a(a aVar) {
        Context a = C1125b.a();
        if (a == null) {
            new A().a("add http event without initialization.");
        } else if (com.xiaomi.mistatistic.sdk.a.a(a)) {
            new A().a("disabled the http event upload");
        } else if (!aVar.a().equals(f()) || com.xiaomi.mistatistic.sdk.a.c()) {
            if (!(this.b == null || aVar.a().equals(f()))) {
                aVar = this.b.a(aVar);
            }
            if (aVar != null && !TextUtils.isEmpty(aVar.a())) {
                synchronized (this.c) {
                    this.c.add(aVar);
                    if (this.c.size() > 100) {
                        this.c.remove(0);
                    }
                }
                if (!this.d.hasMessages(1023) && !aVar.a().equals(f())) {
                    this.d.sendEmptyMessageDelayed(1023, e());
                }
            }
        }
    }

    void a(JSONObject jSONObject) {
        if (jSONObject.has(b.b)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(b.b);
            int optInt = jSONObject2.optInt("sample_rate", C1012a.b);
            int optInt2 = jSONObject2.optInt("delay", 300000);
            long optLong = jSONObject2.optLong("ban_time", 0);
            E.b(C1125b.a(), "rt_upload_rate", optInt);
            E.b(C1125b.a(), "rt_upload_delay", (long) optInt2);
            E.b(C1125b.a(), "rt_ban_time", optLong);
            E.b(C1125b.a(), "rt_update_time", System.currentTimeMillis());
        }
    }

    public boolean a(String str) {
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(v.u, C1125b.b()));
        arrayList.add(new BasicNameValuePair("app_package", C1125b.a().getPackageName()));
        arrayList.add(new BasicNameValuePair("device_uuid", r.a(C1125b.a())));
        arrayList.add(new BasicNameValuePair("device_os", MiPushMessageReceiver.ANDROID + VERSION.SDK_INT));
        arrayList.add(new BasicNameValuePair("device_model", Build.MODEL));
        arrayList.add(new BasicNameValuePair("app_version", C1125b.e()));
        arrayList.add(new BasicNameValuePair("app_channel", C1125b.d()));
        arrayList.add(new BasicNameValuePair(g.f, String.valueOf(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair("net_value", str));
        Object a = C.a(C1125b.a(), f(), arrayList);
        new A().a("http data complete, result=" + a);
        if (!TextUtils.isEmpty(a)) {
            JSONObject jSONObject = new JSONObject(a);
            if ("ok".equals(jSONObject.getString(LocationManagerProxy.KEY_STATUS_CHANGED))) {
                a(jSONObject);
                return true;
            }
        }
        return false;
    }

    public List b() {
        List linkedList;
        synchronized (this.c) {
            linkedList = new LinkedList(this.c);
        }
        return linkedList;
    }

    boolean c() {
        return System.currentTimeMillis() > E.a(C1125b.a(), "rt_ban_time", 0) && Math.random() * 10000.0d <= ((double) E.a(C1125b.a(), "rt_upload_rate", (int) C1012a.b));
    }

    boolean d() {
        return System.currentTimeMillis() - E.a(C1125b.a(), "rt_update_time", 0) > d.h;
    }

    public long e() {
        return E.a(C1125b.a(), "rt_upload_delay", (long) F.a);
    }
}
