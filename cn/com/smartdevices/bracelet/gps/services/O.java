package cn.com.smartdevices.bracelet.gps.services;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.h.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class O implements Serializable {
    public static final int a = 24;
    public static final String b = "mps";
    public static final String c = "spm";
    public static final String d = "mph";
    public static final String e = "hpm";
    public static final String f = "ct";
    public static final String g = "step";
    public static final String h = "al";
    public static final String i = "index";
    public static final String j = "hr";
    private static final long serialVersionUID = 1;
    float k = 0.0f;
    float l = 0.0f;
    float m = 0.0f;
    long n = 0;
    int o = 0;
    long p = 0;
    int q = 0;

    public O(long j) {
        this.p = j;
    }

    public O(JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull(i)) {
                this.o = jSONObject.getInt(i);
            }
            if (!jSONObject.isNull(f)) {
                this.n = jSONObject.getLong(f);
            }
            if (!jSONObject.isNull(h)) {
                this.m = Float.valueOf((float) jSONObject.getLong(h)).floatValue();
            }
            if (!jSONObject.isNull(c)) {
                this.l = Float.valueOf(jSONObject.getString(c)).floatValue();
            } else if (!jSONObject.isNull(e)) {
                this.l = Float.valueOf(jSONObject.getString(e)).floatValue();
            }
            if (!jSONObject.isNull(b)) {
                this.k = Float.valueOf(jSONObject.getString(b)).floatValue();
            } else if (!jSONObject.isNull(d)) {
                this.k = Float.valueOf(jSONObject.getString(d)).floatValue();
            }
            if (!jSONObject.isNull(j)) {
                this.q = jSONObject.getInt(j);
            }
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
    }

    public static List<O> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList(0);
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            List<O> arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new O(jSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
            return new ArrayList(0);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(i, this.o);
            jSONObject.put(f, this.n);
            jSONObject.put(h, h.b((double) this.m, 2));
            jSONObject.put(c, h.b(this.l, 6));
            jSONObject.put(b, h.b(this.k, 6));
            jSONObject.put(j, this.q);
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
        return jSONObject;
    }

    void a(float f) {
        this.l = f;
    }

    void a(int i) {
        this.o = i;
    }

    void a(long j) {
        this.p = j;
    }

    public float b() {
        return this.l;
    }

    void b(float f) {
        this.k = f;
    }

    public void b(int i) {
        this.q = i;
    }

    void b(long j) {
        this.n = j;
    }

    public float c() {
        return this.k;
    }

    public int d() {
        return this.o;
    }

    public long e() {
        return this.p;
    }

    public long f() {
        return this.n;
    }

    public int g() {
        return this.q;
    }
}
