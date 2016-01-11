package cn.com.smartdevices.bracelet.gps.services;

import org.json.JSONException;
import org.json.JSONObject;

public class C0465y {
    private static final String a = "base_distance";
    private static final String b = "base_timestamp";
    private static final String c = "base_times";
    private static final String d = "base_calories";
    private static final String e = "current_distance";
    private static final String f = "current_times";
    private static final String g = "current_calories";
    private double h = 0.0d;
    private long i = 0;
    private int j = 0;
    private double k = 0.0d;
    private double l = 0.0d;
    private int m = 0;
    private double n = 0.0d;

    public static C0465y a(String str) {
        C0465y c0465y = new C0465y();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c0465y.h = jSONObject.getDouble(a);
            c0465y.i = jSONObject.getLong(b);
            c0465y.j = jSONObject.getInt(c);
            c0465y.k = jSONObject.getDouble(d);
            c0465y.l = jSONObject.getDouble(e);
            c0465y.m = jSONObject.getInt(f);
            c0465y.n = jSONObject.getDouble(g);
            return c0465y;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double a() {
        return this.k;
    }

    public void a(double d) {
        this.k = d;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(long j) {
        this.i = j;
    }

    public double b() {
        return this.h;
    }

    public void b(double d) {
        this.h = d;
    }

    public void b(int i) {
        this.m = i;
    }

    public int c() {
        return this.j;
    }

    public void c(double d) {
        this.n = d;
    }

    public long d() {
        return this.i;
    }

    public void d(double d) {
        this.l = d;
    }

    public double e() {
        return this.n;
    }

    public double f() {
        return this.l;
    }

    public int g() {
        return this.m;
    }

    public String h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, this.h);
            jSONObject.put(b, this.i);
            jSONObject.put(c, this.j);
            jSONObject.put(d, this.k);
            jSONObject.put(e, this.l);
            jSONObject.put(f, this.m);
            jSONObject.put(g, this.n);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
