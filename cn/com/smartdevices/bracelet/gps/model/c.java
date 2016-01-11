package cn.com.smartdevices.bracelet.gps.model;

import android.location.Location;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements Serializable, Comparable<c> {
    public static final String a = "p";
    public static final String b = "a";
    public static final String c = "s";
    public static final String d = "b";
    public static final String e = "t";
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 4;
    public static final int j = 0;
    public static final int k = -4;
    public static final int l = -3;
    public static final int m = 64;
    private static final long serialVersionUID = 1;
    public int n = f;
    public double o = 0.0d;
    public double p;
    public double q;
    public long r = 0;
    public float s = 0.0f;
    public int t = j;
    public float u = 0.0f;
    public float v = 0.0f;
    private int w = j;
    private int x = j;

    public c(double d, double d2, double d3) {
        this.p = d;
        this.q = d2;
        this.o = d3;
    }

    public c(Location location) {
        a(location);
    }

    public c(Location location, int i) {
        this.n = i;
        a(location);
    }

    public static Location a(c cVar) {
        Location location = new Location(GeocodeSearch.GPS);
        location.setAltitude(cVar.o);
        location.setLatitude(cVar.p);
        location.setLongitude(cVar.q);
        return location;
    }

    private void a(Location location) {
        this.p = location.getLatitude();
        this.q = location.getLongitude();
        this.o = location.getAltitude();
        this.v = location.getAccuracy();
        this.u = location.getBearing();
        this.r = System.currentTimeMillis() / 1000;
        this.s = location.getSpeed();
    }

    public static boolean a(int i) {
        return i == f;
    }

    public c a() {
        c cVar = new c();
        cVar.o = this.o;
        cVar.p = this.p;
        cVar.q = this.q;
        cVar.r = this.r;
        cVar.w = this.w;
        cVar.v = this.v;
        cVar.x = this.x;
        cVar.s = this.s;
        cVar.t = this.t;
        cVar.u = this.u;
        return cVar;
    }

    public void a(float f) {
    }

    public void a(long j) {
        this.r = j;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Object string;
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(a)) {
                this.t = jSONObject.getInt(a);
            }
            if (!jSONObject.isNull(b)) {
                string = jSONObject.getString(b);
                if (!TextUtils.isEmpty(string)) {
                    this.v = Float.valueOf(string).floatValue();
                }
            }
            if (!jSONObject.isNull(c)) {
                string = jSONObject.getString(c);
                if (!TextUtils.isEmpty(string)) {
                    this.s = Float.valueOf(string).floatValue();
                }
            }
            if (!jSONObject.isNull(d)) {
                string = jSONObject.getString(d);
                if (!TextUtils.isEmpty(string)) {
                    this.u = Float.valueOf(string).floatValue();
                }
            }
            if (!jSONObject.isNull(e)) {
                this.x = jSONObject.getInt(e);
            }
            return true;
        } catch (JSONException e) {
            C0596r.a("DB", e.getMessage());
            return false;
        }
    }

    public int b() {
        return this.x;
    }

    public int b(c cVar) {
        return this.w > cVar.d() ? f : this.w < cVar.d() ? -1 : j;
    }

    public void b(int i) {
        this.x = i;
    }

    public void b(long j) {
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, this.t);
            jSONObject.put(b, (double) this.v);
            jSONObject.put(c, (double) this.s);
            jSONObject.put(d, (double) this.u);
            jSONObject.put(e, this.x);
        } catch (JSONException e) {
            C0596r.e("DB", e.getMessage());
        }
        return jSONObject;
    }

    public void c(int i) {
        this.w = i;
    }

    public void c(c cVar) {
        this.o = cVar.o;
        this.p = cVar.p;
        this.q = cVar.q;
        this.r = cVar.r;
        this.w = cVar.w;
        this.v = cVar.v;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((c) obj);
    }

    public float d(c cVar) {
        float[] fArr = new float[f];
        Location.distanceBetween(this.p, this.q, cVar.p, cVar.q, fArr);
        return fArr[j];
    }

    public int d() {
        return this.w;
    }

    public long e() {
        return this.r;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof c) && ((c) obj).r == this.r;
    }

    public float f() {
        return 0.0f;
    }

    public long g() {
        return 0;
    }

    public String toString() {
        return "GPSPoint [mMapType=" + this.n + ", mAltitude=" + this.o + ", mLatitude=" + this.p + ", mLongitude=" + this.q + ", mTime=" + this.r + ", mSpeed=" + this.s + ", mProviderType=" + this.t + ", mBearing=" + this.u + ", mAccuracy=" + this.v + "]";
    }
}
