package com.amap.api.services.core;

import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.xiaomi.mipush.sdk.f;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

public class u extends s<RegeocodeQuery, RegeocodeAddress> {
    public u(RegeocodeQuery regeocodeQuery, Proxy proxy) {
        super(regeocodeQuery, proxy);
    }

    protected RegeocodeAddress a(String str) {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("regeocode");
            regeocodeAddress.setFormatAddress(m.b(jSONObject, "formatted_address"));
            m.a(jSONObject.getJSONObject("addressComponent"), regeocodeAddress);
            m.c(jSONObject.getJSONArray("pois"), regeocodeAddress);
            m.b(jSONObject.getJSONArray("roads"), regeocodeAddress);
            m.a(jSONObject.getJSONArray("roadinters"), regeocodeAddress);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return regeocodeAddress;
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&extensions=all").append("&location=").append(((RegeocodeQuery) this.task).getPoint().getLongitude()).append(f.i).append(((RegeocodeQuery) this.task).getPoint().getLatitude());
        stringBuffer.append("&radius=").append(((RegeocodeQuery) this.task).getRadius());
        stringBuffer.append("&coordsys=").append(((RegeocodeQuery) this.task).getLatLonType());
        stringBuffer.append("&key=" + d.a(null).f());
        return e.f(stringBuffer.toString());
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/geocode/regeo?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
