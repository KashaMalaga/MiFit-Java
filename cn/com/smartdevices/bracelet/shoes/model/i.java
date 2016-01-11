package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.b.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
    private static final String j = "rn";
    private static final String k = "wk";
    private static final String l = "cal";
    private static final String m = "rdis";
    private static final String n = "rcal";
    private static final String o = "dis";
    private static final String p = "ttl";
    private static final String q = "rttl";
    private static final String r = "v";
    private static final String s = "rfttl";
    private static final String t = "goal";
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int u;
    private int v;
    private String w;

    public i() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 1;
        this.u = 0;
        this.v = 0;
        this.w = a.f;
        this.w = c.h();
        this.v = c.e();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(t, this.v);
            jSONObject.put(r, this.i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(j, this.g);
            jSONObject2.put(k, this.h);
            jSONObject2.put(l, this.a);
            jSONObject2.put(n, this.b);
            jSONObject2.put(m, this.e);
            jSONObject2.put(o, this.f);
            jSONObject2.put(p, this.d);
            jSONObject2.put(q, this.c);
            jSONObject2.put(s, this.u);
            jSONObject.put(StepsInfo.KEY_STEP_INFO, jSONObject2);
        } catch (JSONException e) {
            C0596r.e("SDM", e.getMessage());
        }
        return jSONObject;
    }

    public void a(int i) {
        this.a = i;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.i = jSONObject.optInt(r);
            this.v = jSONObject.optInt(t);
            jSONObject = jSONObject.optJSONObject(StepsInfo.KEY_STEP_INFO);
            if (jSONObject == null) {
                return false;
            }
            this.g = jSONObject.optInt(j);
            this.h = jSONObject.optInt(k);
            this.a = jSONObject.optInt(l);
            this.b = jSONObject.optInt(n);
            this.f = jSONObject.optInt(o);
            this.d = jSONObject.optInt(p);
            this.c = jSONObject.optInt(q);
            this.u = jSONObject.optInt(s);
            this.e = jSONObject.optInt(m);
            return true;
        } catch (JSONException e) {
            C0596r.a("SDM", e.getMessage());
            return false;
        }
    }

    public int b() {
        return this.a;
    }

    public void b(int i) {
        this.f = i;
    }

    public int c() {
        return this.f;
    }

    public void c(int i) {
        this.u = i;
    }

    public int d() {
        return this.u;
    }

    public void d(int i) {
        this.v = i;
    }

    public int e() {
        return this.v;
    }

    public void e(int i) {
        this.b = i;
    }

    public int f() {
        return this.b;
    }

    public void f(int i) {
        this.e = i;
    }

    public int g() {
        return this.e;
    }

    public void g(int i) {
        this.c = i;
    }

    public int h() {
        return this.c;
    }

    public void h(int i) {
        this.g = i;
    }

    public int i() {
        return this.g;
    }

    public void i(int i) {
        this.d = i;
    }

    public int j() {
        return this.a - this.b;
    }

    public void j(int i) {
        this.h = i;
    }

    public int k() {
        return this.f - this.e;
    }

    public int l() {
        return this.d;
    }

    public String m() {
        return a().toString();
    }

    public int n() {
        return this.h + this.g;
    }

    public String o() {
        return this.w;
    }

    public int p() {
        return this.a - this.b;
    }

    public int q() {
        return this.f - this.e;
    }

    public int r() {
        return this.h;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShoesDateSummary: mRunTime = ").append(this.g).append(",mWalkTime = ").append(this.h).append(",mRunCal = ").append(this.b).append(",mCal = ").append(this.a).append(",mRunDis = ").append(this.e).append(",mDis = ").append(this.f).append(",mSteps = ").append(this.d).append(",mForefootRunSteps = ").append(this.u).append(",mVersion = ").append(this.i).append(",mGoal = ").append(this.v);
        return stringBuilder.toString();
    }
}
