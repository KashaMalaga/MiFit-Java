package com.amap.api.services.core;

import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineQuery.SearchType;
import com.amap.api.services.busline.BusStationQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.e.a;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class c<T> extends s<T, ArrayList<?>> {
    private int a = 0;
    private List<String> b = new ArrayList();
    private List<SuggestionCity> c = new ArrayList();

    public c(T t, Proxy proxy) {
        super(t, proxy);
    }

    public T a() {
        return this.task;
    }

    protected ArrayList<?> a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("suggestion")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("suggestion");
                this.c = m.a(jSONObject2);
                this.b = m.b(jSONObject2);
            }
            this.a = jSONObject.getInt(ParamKey.COUNT);
            return this.task instanceof BusLineQuery ? m.i(jSONObject) : m.e(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int b() {
        return this.a;
    }

    public List<String> c() {
        return this.b;
    }

    public List<SuggestionCity> d() {
        return this.c;
    }

    protected String getRequestString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("output=json");
        String city;
        if (this.task instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.task;
            stringBuilder.append("&extensions=all");
            if (busLineQuery.getCategory() == SearchType.BY_LINE_ID) {
                stringBuilder.append("&id=").append(strEncoder(((BusLineQuery) this.task).getQueryString(), z));
            } else {
                city = busLineQuery.getCity();
                if (!m.h(city)) {
                    stringBuilder.append("&city=").append(strEncoder(city, z));
                }
                stringBuilder.append("&keywords=" + strEncoder(busLineQuery.getQueryString(), z));
                stringBuilder.append("&offset=" + busLineQuery.getPageSize());
                stringBuilder.append("&page=" + (busLineQuery.getPageNumber() + 1));
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.task;
            city = busStationQuery.getCity();
            if (!m.h(city)) {
                stringBuilder.append("&city=").append(strEncoder(city, z));
            }
            stringBuilder.append("&keywords=" + strEncoder(busStationQuery.getQueryString(), z));
            stringBuilder.append("&offset=" + busStationQuery.getPageSize());
            stringBuilder.append("&page=" + (busStationQuery.getPageNumber() + 1));
        }
        stringBuilder.append("&key=" + d.a(null).f());
        return e.f(stringBuilder.toString());
    }

    protected String getUrl() {
        String str = this.task instanceof BusLineQuery ? ((BusLineQuery) this.task).getCategory() == SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.task).getCategory() == SearchType.BY_LINE_NAME ? "linename" : a.f : "stopname";
        return "http://restapi.amap.com/v3/bus/" + str + "?";
    }

    protected /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
