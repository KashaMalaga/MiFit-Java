package com.b;

import cn.com.smartdevices.bracelet.gps.c.a.g;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import org.json.JSONObject;

public class M {
    private String a = a.f;
    private double b = 0.0d;
    private double c = 0.0d;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private long g = 0;
    private AMapLocException h = new AMapLocException();
    private String i = "new";
    private String j = a.f;
    private String k = a.f;
    private String l = a.f;
    private String m = a.f;
    private String n = a.f;
    private String o = a.f;
    private String p = a.f;
    private String q = a.f;
    private String r = a.f;
    private String s = a.f;
    private String t = a.f;
    private String u = a.f;
    private String v = a.f;
    private String w = a.f;
    private String x = a.f;
    private JSONObject y = null;

    public M(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.getString("provider");
                this.b = jSONObject.getDouble("lon");
                this.c = jSONObject.getDouble("lat");
                this.d = (float) jSONObject.getLong("accuracy");
                this.e = (float) jSONObject.getLong("speed");
                this.f = (float) jSONObject.getLong("bearing");
                this.g = jSONObject.getLong(g.f);
                this.i = jSONObject.getString(com.xiaomi.channel.relationservice.data.a.h);
                this.j = jSONObject.getString("retype");
                this.k = jSONObject.getString("citycode");
                this.l = jSONObject.getString(SocialConstants.PARAM_APP_DESC);
                this.m = jSONObject.getString("adcode");
                this.n = jSONObject.getString(DistrictSearchQuery.KEYWORDS_COUNTRY);
                this.o = jSONObject.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                this.p = jSONObject.getString(DistrictSearchQuery.KEYWORDS_CITY);
                this.q = jSONObject.getString("road");
                this.r = jSONObject.getString("street");
                this.s = jSONObject.getString(ParamKey.POINAME);
                this.u = jSONObject.getString("floor");
                this.t = jSONObject.getString(ParamKey.POIID);
                this.v = jSONObject.getString("coord");
                this.w = jSONObject.getString("mcell");
                this.x = jSONObject.getString(DistrictSearchQuery.KEYWORDS_DISTRICT);
            } catch (Throwable th) {
                th.printStackTrace();
                ao.a(th);
            }
        }
    }

    public AMapLocException a() {
        return this.h;
    }

    public void a(double d) {
        this.b = d;
    }

    public void a(float f) {
        this.d = f;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(AMapLocException aMapLocException) {
        this.h = aMapLocException;
    }

    public void a(String str) {
        this.t = str;
    }

    public void a(JSONObject jSONObject) {
        this.y = jSONObject;
    }

    public String b() {
        return this.t;
    }

    public void b(double d) {
        this.c = d;
    }

    public void b(String str) {
        this.u = str;
    }

    public String c() {
        return this.u;
    }

    public void c(String str) {
        this.x = str;
    }

    public String d() {
        return this.x;
    }

    public void d(String str) {
        this.v = str;
    }

    public double e() {
        return this.b;
    }

    public void e(String str) {
        this.w = str;
    }

    public double f() {
        return this.c;
    }

    public void f(String str) {
        this.a = str;
    }

    public float g() {
        return this.d;
    }

    public void g(String str) {
        this.i = str;
    }

    public long h() {
        return this.g;
    }

    public void h(String str) {
        this.j = str;
    }

    public String i() {
        return this.i;
    }

    public void i(String str) {
        this.k = str;
    }

    public String j() {
        return this.j;
    }

    public void j(String str) {
        this.l = str;
    }

    public String k() {
        return this.k;
    }

    public void k(String str) {
        this.m = str;
    }

    public String l() {
        return this.l;
    }

    public void l(String str) {
        this.n = str;
    }

    public String m() {
        return this.m;
    }

    public void m(String str) {
        this.o = str;
    }

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.p = str;
    }

    public String o() {
        return this.o;
    }

    public void o(String str) {
        this.q = str;
    }

    public String p() {
        return this.p;
    }

    public void p(String str) {
        this.r = str;
    }

    public String q() {
        return this.q;
    }

    public void q(String str) {
        this.s = str;
    }

    public String r() {
        return this.r;
    }

    public String s() {
        return this.s;
    }

    public JSONObject t() {
        return this.y;
    }

    public String u() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("provider", this.a);
            jSONObject.put("lon", this.b);
            jSONObject.put("lat", this.c);
            jSONObject.put("accuracy", (double) this.d);
            jSONObject.put("speed", (double) this.e);
            jSONObject.put("bearing", (double) this.f);
            jSONObject.put(g.f, this.g);
            jSONObject.put(com.xiaomi.channel.relationservice.data.a.h, this.i);
            jSONObject.put("retype", this.j);
            jSONObject.put("citycode", this.k);
            jSONObject.put(SocialConstants.PARAM_APP_DESC, this.l);
            jSONObject.put("adcode", this.m);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_COUNTRY, this.n);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.o);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.p);
            jSONObject.put("road", this.q);
            jSONObject.put("street", this.r);
            jSONObject.put(ParamKey.POINAME, this.s);
            jSONObject.put(ParamKey.POIID, this.t);
            jSONObject.put("floor", this.u);
            jSONObject.put("coord", this.v);
            jSONObject.put("mcell", this.w);
            jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.x);
        } catch (Throwable e) {
            ao.a(e);
            jSONObject = null;
        }
        return jSONObject == null ? null : jSONObject.toString();
    }
}
