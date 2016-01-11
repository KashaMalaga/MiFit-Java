package com.amap.api.services.core;

import com.amap.api.services.poisearch.PoiHandler;
import com.amap.api.services.poisearch.PoiItemDetail;
import java.net.Proxy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends PoiHandler<String, PoiItemDetail> {
    public q(String str, Proxy proxy) {
        super(str, proxy);
    }

    private PoiItemDetail a(JSONObject jSONObject) {
        PoiItemDetail poiItemDetail = null;
        if (jSONObject != null && jSONObject.has("pois")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray.length() > 0) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                poiItemDetail = m.d(jSONObject2);
                if (jSONObject2.has("rich_content")) {
                    m.a(poiItemDetail, jSONObject2.optJSONObject("rich_content"));
                }
                if (jSONObject2.has("deep_info")) {
                    m.e(poiItemDetail, jSONObject2.optJSONObject("deep_info"), jSONObject2);
                }
            }
        }
        return poiItemDetail;
    }

    private String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append((String) this.task);
        stringBuilder.append("&output=json");
        stringBuilder.append("&extensions=all");
        stringBuilder.append("&key=" + d.a(null).f());
        return e.f(stringBuilder.toString());
    }

    public PoiItemDetail a(String str) {
        PoiItemDetail poiItemDetail = null;
        try {
            poiItemDetail = a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return poiItemDetail;
    }

    protected String getRequestString(boolean z) {
        return a();
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/place/detail?";
    }

    public /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
