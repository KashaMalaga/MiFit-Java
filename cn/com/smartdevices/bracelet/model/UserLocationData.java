package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class UserLocationData {
    private static final String TAG = "UserLocationData";
    public String city = a.f;
    public String latitude = a.f;
    public String longitude = a.f;

    public static UserLocationData fromJsonStr(String str) {
        UserLocationData userLocationData = new UserLocationData();
        try {
            JSONObject jSONObject = new JSONObject(Utils.f(str));
            userLocationData.city = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
            userLocationData.longitude = jSONObject.optString(ParamKey.LONGITUDE);
            userLocationData.latitude = jSONObject.optString(ParamKey.LATITUDE);
        } catch (JSONException e) {
            e.toString();
        }
        return userLocationData;
    }

    public boolean isValid() {
        return this.city != null && this.longitude.length() > 0 && this.latitude.length() > 0;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setLocation(String str, String str2, String str3) {
        this.city = str;
        this.longitude = str2;
        this.latitude = str3;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.city);
            jSONObject.put(ParamKey.LONGITUDE, this.longitude);
            jSONObject.put(ParamKey.LATITUDE, this.latitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
