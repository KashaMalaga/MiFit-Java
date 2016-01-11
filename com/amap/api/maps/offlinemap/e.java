package com.amap.api.maps.offlinemap;

import android.content.Context;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.gps.services.ay;
import com.amap.api.mapcore.util.ae;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.w;
import com.amap.api.mapcore.util.y;
import com.f.a.b.d.a;
import com.tencent.connect.common.Constants;
import com.xiaomi.market.sdk.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class e extends ProtocalHandler<String, OfflineInitBean> {
    public e(Context context, String str) {
        super(context, str);
        getClass();
        setConnectionTimeout(a.a);
        getClass();
        setSoTimeout(50000);
    }

    protected OfflineInitBean a(String str) {
        OfflineInitBean offlineInitBean = new OfflineInitBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("offlinemap")) {
                jSONObject = jSONObject.getJSONObject("offlinemap");
                String optString = jSONObject.optString("update", com.xiaomi.e.a.f);
                if (optString.equals(Constants.VIA_RESULT_SUCCESS)) {
                    offlineInitBean.setNeedUpdate(false);
                } else if (optString.equals(Constants.VIA_TO_TYPE_QQ_GROUP)) {
                    offlineInitBean.setNeedUpdate(true);
                }
                offlineInitBean.setVersion(jSONObject.optString(o.x, com.xiaomi.e.a.f));
            }
        } catch (Throwable th) {
            az.a(th, "OfflineInitHandler", "loadData parseJson");
            th.printStackTrace();
        }
        return offlineInitBean;
    }

    public Map<String, String> getParams() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("mapver", this.task);
        hashMap.put("output", "json");
        hashMap.put(C0430g.b, w.f(this.mContext));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mapver=").append((String) this.task);
        stringBuffer.append("&output=json");
        stringBuffer.append("&key=").append(w.f(this.mContext));
        String a = ae.a(stringBuffer.toString());
        String a2 = y.a();
        hashMap.put(ay.H, a2);
        hashMap.put("scode", y.a(this.mContext, a2, a));
        return hashMap;
    }

    public String getURL() {
        return "http://apimanifest.amap.com/r/init";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
