package com.amap.api.services.core;

import cn.com.smartdevices.bracelet.relation.db.Friend;
import cn.com.smartdevices.bracelet.relation.db.a;
import com.amap.api.services.poisearch.PoiHandler;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.xiaomi.mipush.sdk.f;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class r extends PoiHandler<t, ArrayList<PoiItem>> {
    private int a = 1;
    private int b = 20;
    private int c = 0;
    private List<String> d = new ArrayList();
    private List<SuggestionCity> e = new ArrayList();

    public r(t tVar, Proxy proxy) {
        super(tVar, proxy);
    }

    private String g() {
        return ((t) this.task).b.isDistanceSort() ? a.g : Friend.d;
    }

    private String h() {
        StringBuffer stringBuffer = new StringBuffer();
        if (((t) this.task).a.hasGroupBuyLimit() && ((t) this.task).a.hasDiscountLimit()) {
            stringBuffer.append("&filter=groupbuy:1|discount:1");
            return stringBuffer.toString();
        }
        if (((t) this.task).a.hasGroupBuyLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("groupbuy:1");
        }
        if (((t) this.task).a.hasDiscountLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("discount:1");
        }
        return stringBuffer.toString();
    }

    public int a() {
        return this.b;
    }

    public ArrayList<PoiItem> a(String str) {
        ArrayList<PoiItem> c;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c = jSONObject.optInt(ParamKey.COUNT);
            c = m.c(jSONObject);
            try {
                if (jSONObject.has("suggestion")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("suggestion");
                    this.e = m.a(jSONObject2);
                    this.d = m.b(jSONObject2);
                }
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                return c;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return c;
            }
        } catch (JSONException e3) {
            JSONException e4;
            JSONException jSONException = e3;
            c = null;
            e4 = jSONException;
            e4.printStackTrace();
            return c;
        } catch (Exception e5) {
            Exception e6;
            Exception exception = e5;
            c = null;
            e6 = exception;
            e6.printStackTrace();
            return c;
        }
        return c;
    }

    public void a(int i) {
        this.a = i + 1;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        int i2 = 30;
        int i3 = i > 30 ? 30 : i;
        if (i3 > 0) {
            i2 = i3;
        }
        this.b = i2;
    }

    public Query c() {
        return ((t) this.task).a;
    }

    public SearchBound d() {
        return ((t) this.task).b;
    }

    public List<String> e() {
        return this.d;
    }

    public List<SuggestionCity> f() {
        return this.e;
    }

    protected String getRequestString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("output=json");
        if (((t) this.task).b != null) {
            double a;
            if (((t) this.task).b.getShape().equals(SearchBound.BOUND_SHAPE)) {
                a = e.a(((t) this.task).b.getCenter().getLongitude());
                stringBuilder.append("&location=").append(a + f.i + e.a(((t) this.task).b.getCenter().getLatitude()));
                stringBuilder.append("&radius=").append(((t) this.task).b.getRange());
                stringBuilder.append("&sortrule=").append(g());
            } else if (((t) this.task).b.getShape().equals(SearchBound.RECTANGLE_SHAPE)) {
                LatLonPoint lowerLeft = ((t) this.task).b.getLowerLeft();
                LatLonPoint upperRight = ((t) this.task).b.getUpperRight();
                double a2 = e.a(lowerLeft.getLatitude());
                a = e.a(lowerLeft.getLongitude());
                stringBuilder.append("&polygon=" + a + f.i + a2 + ";" + e.a(upperRight.getLongitude()) + f.i + e.a(upperRight.getLatitude()));
            } else if (((t) this.task).b.getShape().equals(SearchBound.POLYGON_SHAPE)) {
                List polyGonList = ((t) this.task).b.getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    stringBuilder.append("&polygon=" + e.a(polyGonList));
                }
            }
        }
        String city = ((t) this.task).a.getCity();
        if (!isNullString(city)) {
            stringBuilder.append("&city=").append(strEncoder(city, z));
        }
        if (!e.a(h())) {
            stringBuilder.append(h());
        }
        stringBuilder.append("&keywords=" + strEncoder(((t) this.task).a.getQueryString(), z));
        stringBuilder.append("&offset=" + this.b);
        stringBuilder.append("&page=" + this.a);
        stringBuilder.append("&types=" + strEncoder(((t) this.task).a.getCategory(), z));
        stringBuilder.append("&extensions=all");
        stringBuilder.append("&key=" + d.a(null).f());
        return e.f(stringBuilder.toString());
    }

    protected String getUrl() {
        String str = "http://restapi.amap.com/v3/place";
        return ((t) this.task).b == null ? str + "/text?" : ((t) this.task).b.getShape().equals(SearchBound.BOUND_SHAPE) ? str + "/around?" : (((t) this.task).b.getShape().equals(SearchBound.RECTANGLE_SHAPE) || ((t) this.task).b.getShape().equals(SearchBound.POLYGON_SHAPE)) ? str + "/polygon?" : str;
    }

    public /* synthetic */ Object paseJSON(String str) {
        return a(str);
    }
}
