package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import cn.com.smartdevices.bracelet.gps.h.h;
import cn.com.smartdevices.bracelet.gps.model.f;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.xiaomi.e.a;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class aa implements Serializable {
    private static final int B = 3;
    private static final int H = 200;
    private static final String I = "SportSummary";
    public static final String a = "avspm";
    public static final String b = "date";
    public static final String c = "v";
    public static final String d = "dis";
    public static final String e = "ct";
    public static final String f = "avmps";
    public static final String g = "cal";
    public static final String h = "sll";
    public static final String i = "ell";
    public static final String j = "pt";
    public static final String k = "ld";
    public static final String l = "shoes";
    public static final String m = "device";
    private static final long serialVersionUID = 1;
    String A = a.f;
    private int C = B;
    private f D = null;
    private int E = 4;
    private int F = t.SYNC_STATE_DEFAULT.a();
    private String G = null;
    String n = a.f;
    float o = 0.0f;
    float p = 0.0f;
    float q = 0.0f;
    long r = 0;
    long s = 0;
    float t = 0.0f;
    long u = 0;
    double v = 0.0d;
    double w = 0.0d;
    double x = 0.0d;
    double y = 0.0d;
    String z = a.f;

    public aa(long j, int i, String str) {
        this.u = j;
        this.n = str;
        this.E = i;
    }

    public aa(JSONObject jSONObject, long j, int i, String str) {
        this.u = j;
        this.n = str;
        this.E = i;
        try {
            Object string;
            String[] split;
            if (!jSONObject.isNull(d)) {
                this.o = Float.valueOf(jSONObject.getString(d)).floatValue();
            }
            if (!jSONObject.isNull(e)) {
                this.s = jSONObject.getLong(e);
            }
            if (!jSONObject.isNull(j)) {
                this.r = jSONObject.getLong(j);
            }
            if (!jSONObject.isNull(f)) {
                this.p = Float.valueOf(jSONObject.getString(f)).floatValue();
            }
            if (!jSONObject.isNull(a)) {
                this.q = Float.valueOf(jSONObject.getString(a)).floatValue();
            }
            if (!jSONObject.isNull(g)) {
                this.t = Float.valueOf(jSONObject.getString(g)).floatValue();
            }
            if (jSONObject.isNull(c)) {
                this.C = 0;
            } else {
                this.C = jSONObject.getInt(c);
            }
            if (!jSONObject.isNull(k)) {
                this.G = jSONObject.getString(k);
            }
            if (!jSONObject.isNull(l)) {
                this.A = jSONObject.getString(l);
            } else if (!jSONObject.isNull(m)) {
                this.A = jSONObject.getString(m);
            }
            if (!jSONObject.isNull(h)) {
                string = jSONObject.getString(h);
                if (!TextUtils.isEmpty(string)) {
                    split = string.split(kankan.wheel.widget.a.ci);
                    if (split != null && split.length >= 2) {
                        this.v = Double.valueOf(split[0]).doubleValue();
                        this.w = Double.valueOf(split[1]).doubleValue();
                    }
                }
            }
            if (!jSONObject.isNull(i)) {
                string = jSONObject.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    split = string.split(kankan.wheel.widget.a.ci);
                    if (split != null && split.length >= 2) {
                        this.x = Double.valueOf(split[0]).doubleValue();
                        this.y = Double.valueOf(split[1]).doubleValue();
                    }
                }
            }
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
    }

    private double[] w() {
        double d = this.v != 0.0d ? this.v : this.x != 0.0d ? this.x : 0.0d;
        double d2 = this.w != 0.0d ? this.w : this.y != 0.0d ? this.y : 0.0d;
        if (d2 == 0.0d) {
            d2 = d;
        }
        if (d == 0.0d) {
            d = d2;
        }
        return new double[]{d, d2};
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b, this.n);
            jSONObject.put(d, h.b(this.o, 6));
            jSONObject.put(e, this.s);
            jSONObject.put(j, this.r);
            jSONObject.put(f, h.b(this.p, 6));
            jSONObject.put(a, h.b(this.q, 6));
            jSONObject.put(g, (double) this.t);
            jSONObject.put(h, this.v + kankan.wheel.widget.a.ci + this.w);
            jSONObject.put(i, this.x + kankan.wheel.widget.a.ci + this.y);
            jSONObject.put(c, this.C);
            jSONObject.put(k, this.G);
            jSONObject.put(m, TextUtils.isEmpty(this.A) ? a.f : this.A);
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
        return jSONObject;
    }

    public void a(int i) {
        this.F = i;
    }

    public void a(Context context, ac acVar, boolean z) {
        if (this.D == null || z) {
            double[] w = w();
            RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(w[0], w[1]), 200.0f, GeocodeSearch.GPS);
            GeocodeSearch geocodeSearch = new GeocodeSearch(context);
            geocodeSearch.setOnGeocodeSearchListener(new ab(this, acVar));
            geocodeSearch.getFromLocationAsyn(regeocodeQuery);
        } else if (this.D != null && acVar != null) {
            acVar.a(this.D);
        }
    }

    public void a(String str) {
        this.z = str;
    }

    public float b() {
        return this.p;
    }

    void b(String str) {
        this.A = str;
    }

    public float c() {
        return this.q;
    }

    public String d() {
        return this.z;
    }

    public float e() {
        return this.t;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof aa) && ((aa) obj).u == this.u;
    }

    public String f() {
        return this.n;
    }

    public String g() {
        return TextUtils.isEmpty(this.A) ? a.f : this.A;
    }

    public double[] h() {
        return new double[]{this.x, this.y};
    }

    public int i() {
        return this.E;
    }

    public double[] j() {
        return new double[]{this.v, this.w};
    }

    public int k() {
        return this.F;
    }

    public float l() {
        return this.o;
    }

    public long m() {
        return this.r;
    }

    public long n() {
        return this.s;
    }

    public long o() {
        return this.u;
    }

    public boolean p() {
        return this.C >= B;
    }

    public boolean q() {
        return t.STATE_SYNCED_FROM_SERVER.a() == this.F;
    }

    public boolean r() {
        return t.STATE_SYNCED_TO_SERVER.a() == this.F;
    }

    public boolean s() {
        return this.C < 2;
    }

    public boolean t() {
        return t.STATE_SYNCED_FROM_SERVER_SUMMERY_DONE.a() == this.F;
    }

    public boolean u() {
        return t.STATE_UNSYNCED.a() != this.F;
    }

    public boolean v() {
        return !TextUtils.isEmpty(this.A);
    }
}
