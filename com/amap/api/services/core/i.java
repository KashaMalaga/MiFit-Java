package com.amap.api.services.core;

import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import java.net.Proxy;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends s<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public i(GeocodeQuery geocodeQuery, Proxy proxy) {
        super(geocodeQuery, proxy);
    }

    protected ArrayList<GeocodeAddress> a(String str) {
        ArrayList<GeocodeAddress> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(ParamKey.COUNT) && jSONObject.getInt(ParamKey.COUNT) > 0) {
                arrayList = m.n(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&address=").append(strEncoder(((GeocodeQuery) this.task).getLocationName(), z));
        String city = ((GeocodeQuery) this.task).getCity();
        if (!m.h(city)) {
            stringBuffer.append("&city=").append(strEncoder(city, z));
        }
        stringBuffer.append("&key=" + d.a(null).f());
        return e.f(stringBuffer.toString());
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/geocode/geo?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
