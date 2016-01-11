package com.xiaomi.network;

import cn.com.smartdevices.bracelet.gps.services.ay;
import org.json.JSONObject;

public class a {
    private int a;
    private long b;
    private long c;
    private String d;
    private long e;

    public a() {
        this(0, 0, 0, null);
    }

    public a(int i, long j, long j2, Exception exception) {
        this.a = i;
        this.b = j;
        this.e = j2;
        this.c = System.currentTimeMillis();
        if (exception != null) {
            this.d = exception.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public a a(JSONObject jSONObject) {
        this.b = jSONObject.getLong("cost");
        this.e = jSONObject.getLong("size");
        this.c = jSONObject.getLong(ay.H);
        this.a = jSONObject.getInt("wt");
        this.d = jSONObject.optString("expt");
        return this;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.e;
    }

    public String e() {
        return this.d;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.b);
        jSONObject.put("size", this.e);
        jSONObject.put(ay.H, this.c);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.d);
        return jSONObject;
    }
}
