package cn.com.smartdevices.bracelet.gps.model;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import cn.com.smartdevices.bracelet.gps.services.aa;
import org.json.JSONObject;

public class l {
    private static final String h = "distance";
    private static final String i = "count";
    private static final String j = "calorie";
    private static final String k = "pace";
    private static final String l = "track_id";
    public float a;
    public int b;
    public int c;
    public float d;
    public int e;
    private long f;
    private int g;

    public l() {
        this.a = 0.0f;
        this.b = 0;
        this.c = 0;
        this.d = 0.0f;
        this.f = -1;
        this.g = 4;
        this.e = t.STATE_UNSYNCED.a();
        this.g = 4;
    }

    public l(int i) {
        this.a = 0.0f;
        this.b = 0;
        this.c = 0;
        this.d = 0.0f;
        this.f = -1;
        this.g = 4;
        this.e = t.STATE_UNSYNCED.a();
        this.g = i;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(h, (double) this.a);
            jSONObject.put(j, this.c);
            jSONObject.put(i, this.b);
            jSONObject.put(k, (double) this.d);
        } catch (Exception e) {
            C0596r.a("Sync", e.getMessage());
        }
        return jSONObject.toString();
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(aa aaVar) {
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!(jSONObject.isNull(h) || TextUtils.isEmpty(jSONObject.getString(h)))) {
                this.a = Float.valueOf(jSONObject.getString(h)).floatValue();
            }
            if (!jSONObject.isNull(j)) {
                this.c = jSONObject.getInt(j);
            }
            if (!jSONObject.isNull(i)) {
                this.b = jSONObject.getInt(i);
            }
            if (!jSONObject.isNull(l)) {
                this.f = jSONObject.getLong(l);
            }
            if (!(jSONObject.isNull(k) || TextUtils.isEmpty(jSONObject.getString(k)))) {
                this.d = Float.valueOf(jSONObject.getString(k)).floatValue();
            }
            return true;
        } catch (Exception e) {
            C0596r.a("Sync", e.getMessage());
            return false;
        }
    }

    public long b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public String toString() {
        return "SportStatInfo [mDistance=" + this.a + ", mSportCount=" + this.b + ", mCalorie=" + this.c + ", mAvgPace=" + this.d + ", mTrackId=" + this.f + ", mType=" + this.g + ", mState=" + this.e + "]";
    }
}
