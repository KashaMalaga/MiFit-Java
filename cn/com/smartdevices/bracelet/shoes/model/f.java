package cn.com.smartdevices.bracelet.shoes.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

class f {
    private static final String A = "v";
    private static final String B = "param";
    public static final int a = -1;
    private static final String p = "bs";
    private static final String q = "bug";
    private static final String r = "ug";
    private static final String s = "bugdate";
    private static final String t = "cug";
    private static final String u = "ability";
    private static final String v = "dates";
    private static final String w = "battery";
    private static final String x = "deviceid";
    private static final String y = "memo";
    private static final String z = "time";
    private int C = 1;
    public String b = a.f;
    public int c = a;
    public int d = 0;
    public int e = 0;
    public String f = a.f;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public JSONObject k = null;
    public String l = a.f;
    public String m = a.f;
    public String n = a.f;
    public long o = (System.currentTimeMillis() / 1000);

    public f(String str, int i) {
        this.b = str;
        this.c = i;
    }

    private JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(this.m, 1);
            return jSONObject;
        } catch (JSONException e) {
            C0596r.a("SHOES", e.getMessage());
            return null;
        }
    }

    private boolean e() {
        if (TextUtils.isEmpty(this.m)) {
            return false;
        }
        if (this.k == null) {
            this.k = d();
            return true;
        }
        try {
            if (this.k.isNull(this.m)) {
                this.k.put(this.m, 1);
            } else {
                this.k.put(this.m, this.k.getInt(this.m) + 1);
            }
            return true;
        } catch (JSONException e) {
            C0596r.a("SHOES", e.getMessage());
            return false;
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A, this.C);
            jSONObject.put(p, this.m);
            jSONObject.put(x, this.l);
            jSONObject.put(q, this.g);
            jSONObject.put(s, this.f);
            jSONObject.put(t, this.h);
            jSONObject.put(u, this.i);
            jSONObject.put(v, this.e);
            jSONObject.put(w, this.j);
            jSONObject.put(B, this.n);
            jSONObject.put(z, this.o);
            if (this.k != null) {
                jSONObject.put(y, this.k);
            }
        } catch (JSONException e) {
            C0596r.e("SHOES", e.getMessage());
        }
        return jSONObject;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.C = jSONObject.optInt(A);
            this.m = jSONObject.optString(p);
            this.l = jSONObject.optString(x);
            this.e = jSONObject.optInt(v);
            this.i = jSONObject.optInt(u);
            this.j = jSONObject.optInt(w);
            this.n = jSONObject.optString(B);
            this.o = jSONObject.optLong(z);
            this.f = jSONObject.optString(s);
            this.h = jSONObject.optInt(t);
            if (this.C == 0) {
                this.g = jSONObject.optInt(r);
            } else {
                this.g = jSONObject.optInt(q);
            }
            this.k = jSONObject.optJSONObject(y);
            return true;
        } catch (JSONException e) {
            C0596r.e("SHOES", e.getMessage());
            return false;
        }
    }

    boolean b() {
        return TextUtils.isEmpty(this.b) || this.c <= a;
    }

    void c() {
        if (b()) {
            this.m = a.f;
        } else {
            this.m = this.b + kankan.wheel.widget.a.ci + this.c;
        }
        e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Summary mBrand:").append(this.b).append(",mSubModel:").append(this.c).append(",mState:").append(this.d).append(",mUsage:").append(this.g).append(",mUsageDate:").append(this.f).append(",mCachedUsage:").append(this.h).append(",mUsedDates:").append(this.e).append(",mBattery:").append(this.j).append(",mMemo:").append(this.k == null ? a.f : this.k.toString()).append(",mDeviceId:").append(this.l).append(",mBoundInfo:").append(this.m).append(",mRevisedParam:").append(this.n).append(",updateTime:").append(this.o);
        return stringBuilder.toString();
    }
}
