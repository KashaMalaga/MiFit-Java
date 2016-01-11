package cn.com.smartdevices.bracelet.weibo;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import org.json.JSONException;
import org.json.JSONObject;

public class p {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static p a(String str) {
        p pVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                pVar = a(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return pVar;
    }

    public static p a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        p pVar = new p();
        pVar.a = jSONObject.optString(ParamKey.LONGITUDE);
        pVar.b = jSONObject.optString(ParamKey.LATITUDE);
        pVar.c = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
        pVar.d = jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE);
        pVar.e = jSONObject.optString("city_name");
        pVar.f = jSONObject.optString("province_name");
        pVar.g = jSONObject.optString("address");
        pVar.h = jSONObject.optString("pinyin");
        pVar.i = jSONObject.optString("more");
        return pVar;
    }
}
