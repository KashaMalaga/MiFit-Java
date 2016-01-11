package com.amap.api.services.core;

import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import java.net.Proxy;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends s<DistrictSearchQuery, DistrictResult> {
    public f(DistrictSearchQuery districtSearchQuery, Proxy proxy) {
        super(districtSearchQuery, proxy);
    }

    protected DistrictResult a(String str) {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.task, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.getInt(ParamKey.COUNT));
            m.a(jSONObject.optJSONArray("districts"), arrayList, null);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return districtResult;
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=").append(((DistrictSearchQuery) this.task).getPageNum() + 1);
        stringBuffer.append("&offset=").append(((DistrictSearchQuery) this.task).getPageSize());
        stringBuffer.append("&showChild=").append(((DistrictSearchQuery) this.task).isShowChild());
        if (((DistrictSearchQuery) this.task).checkKeyWords()) {
            stringBuffer.append("&keywords=").append(strEncoder(((DistrictSearchQuery) this.task).getKeywords(), z));
        }
        if (((DistrictSearchQuery) this.task).checkLevels()) {
            stringBuffer.append("&level=").append(((DistrictSearchQuery) this.task).getKeywordsLevel());
        }
        stringBuffer.append("&key=" + d.a(null).f());
        return e.f(stringBuffer.toString());
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/config/district?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
