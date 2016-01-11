package com.xiaomi.mistatistic.sdk.b.a;

import android.text.TextUtils;
import com.amap.api.location.LocationManagerProxy;
import com.g.a.b.b;
import com.xiaomi.channel.b.v;
import com.xiaomi.market.sdk.o;
import com.xiaomi.mistatistic.sdk.b.A;
import com.xiaomi.mistatistic.sdk.b.C;
import com.xiaomi.mistatistic.sdk.b.C1125b;
import com.xiaomi.mistatistic.sdk.b.p;
import com.xiaomi.mistatistic.sdk.b.r;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class d implements p {
    private e a;
    private String b;

    public d(String str, e eVar) {
        this.a = eVar;
        this.b = str;
    }

    public void a() {
        boolean z = false;
        A a = new A();
        try {
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(v.u, C1125b.b()));
            arrayList.add(new BasicNameValuePair("app_key", C1125b.c()));
            arrayList.add(new BasicNameValuePair(a.ak, new r().a()));
            arrayList.add(new BasicNameValuePair(b.c, C1125b.d()));
            Object e = C1125b.e();
            if (!TextUtils.isEmpty(e)) {
                arrayList.add(new BasicNameValuePair(o.x, e));
            }
            arrayList.add(new BasicNameValuePair("stat_value", this.b));
            e = C.a(C1125b.a(), com.xiaomi.mistatistic.sdk.a.a() ? "http://10.99.168.145:8097/mistats" : "https://data.mistat.xiaomi.com/mistats", arrayList);
            a.a("Upload MiStat data complete, result=" + e);
            if (!TextUtils.isEmpty(e)) {
                if ("ok".equals(new JSONObject(e).getString(LocationManagerProxy.KEY_STATUS_CHANGED))) {
                    z = true;
                }
            }
        } catch (Throwable e2) {
            a.a("Upload MiStat data failed", e2);
        } catch (Throwable e22) {
            a.a("Result parse failed", e22);
        }
        this.a.a(z);
    }
}
