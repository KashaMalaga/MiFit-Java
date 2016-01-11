package com.xiaomi.hm.health.bt.profile.Weight;

import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.C0596r;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.e.a;
import java.math.BigDecimal;
import java.util.Date;
import org.json.JSONObject;

public class e {
    public static final String a = e.class.getSimpleName();
    public static float b = BitmapDescriptorFactory.HUE_MAGENTA;
    public static float c = 65520.0f;
    public static final String d = "WEIGHTADVDATA_KEY";
    public static final String e = "WEIGHTADVDATA_KEY_MAX";
    public static final String f = "WEIGHTADVDATA_KEY_VALUE";
    public static final String g = "WEIGHTADVDATA_KEY_UNIT";
    public static final String h = "WEIGHTADVDATA_KEY_BMI";
    public static final String i = "WEIGHTADVDATA_KEY_TIMESTAMP";
    public static final int j = 0;
    public static final int k = 16;
    public static final int l = 1;
    public static int m = 17;
    public static int n = 32;
    public static int o = 64;
    public static int p = C0113o.h;
    private boolean A = false;
    private int q = -1;
    private float r = GroundOverlayOptions.NO_DIMENSION;
    private float s = GroundOverlayOptions.NO_DIMENSION;
    private long t = -1;
    private float u = GroundOverlayOptions.NO_DIMENSION;
    private float v = GroundOverlayOptions.NO_DIMENSION;
    private String w = a.f;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;

    public e(int i, float f, long j, boolean z, boolean z2, boolean z3, boolean z4) {
        this.q = i;
        this.r = f;
        this.t = j;
        this.x = z;
        this.z = z2;
        this.y = z3;
        this.A = z4;
        o();
    }

    public static float a(float f, int i) {
        return new BigDecimal((double) f).setScale(i, 4).floatValue();
    }

    public static float a(float f, int i, int i2) {
        switch (i) {
            case j /*0*/:
                switch (i2) {
                    case j /*0*/:
                        return f;
                    case l /*1*/:
                        return a(2.20462f * f, 2);
                    case k /*16*/:
                        return f * 2.0f;
                    default:
                        return f;
                }
            case l /*1*/:
                switch (i2) {
                    case j /*0*/:
                        return a(0.45359f * f, 2);
                    case l /*1*/:
                        return f;
                    case k /*16*/:
                        return a(0.90718f * f, 2);
                    default:
                        return 0.0f;
                }
            case k /*16*/:
                switch (i2) {
                    case j /*0*/:
                        return f / 2.0f;
                    case l /*1*/:
                        return a(1.10231f * f, 2);
                    case k /*16*/:
                        return f;
                    default:
                        return 0.0f;
                }
            default:
                return f;
        }
    }

    public static float b(float f, int i) {
        return a(f, i, j);
    }

    public static float b(int i) {
        return i == 0 ? 150.0f : i == k ? BitmapDescriptorFactory.HUE_MAGENTA : i == l ? 331.1f : 150.0f;
    }

    public static e b(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.v = (float) jSONObject.optDouble(e);
            eVar.r = (float) jSONObject.optDouble(f);
            eVar.q = jSONObject.optInt(g);
            eVar.s = (float) jSONObject.optDouble(h);
            eVar.t = jSONObject.optLong(i);
        } catch (Exception e) {
        }
        return eVar;
    }

    private void o() {
        this.u = b(this.r, this.q);
        this.v = b(this.q);
    }

    public String a() {
        return this.w;
    }

    public void a(float f) {
        this.s = f;
    }

    public void a(int i) {
        this.q = i;
        o();
    }

    public void a(long j) {
        this.t = j;
    }

    public void a(String str) {
        this.w = str;
    }

    public void a(boolean z) {
        this.x = z;
    }

    public float b() {
        return this.v;
    }

    public void b(float f) {
        this.r = f;
        o();
    }

    public void b(boolean z) {
        this.A = z;
    }

    public void c(float f) {
        this.u = f;
    }

    public void c(boolean z) {
        this.y = z;
    }

    public boolean c() {
        return this.z;
    }

    public boolean d() {
        return this.A;
    }

    public long e() {
        return this.t;
    }

    public boolean f() {
        return this.x;
    }

    public boolean g() {
        return this.y;
    }

    public int h() {
        return this.q;
    }

    public float i() {
        return this.s;
    }

    public float j() {
        return this.r;
    }

    public float k() {
        return this.u;
    }

    public boolean l() {
        return (this.q == 0 || this.q == k || this.q == l) && this.r > 0.0f && this.r <= this.v;
    }

    public boolean m() {
        return this.r == c;
    }

    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e, (double) this.v);
            jSONObject.put(f, (double) this.r);
            jSONObject.put(g, this.q);
            jSONObject.put(h, (double) this.s);
            jSONObject.put(i, this.t);
        } catch (Exception e) {
        }
        C0596r.e(a, "WeightAdvData toString " + jSONObject.toString());
        return jSONObject.toString();
    }

    public String toString() {
        return "<type:" + this.q + ",value:" + this.r + ",valueKg:" + this.u + ",date:" + new Date(this.t).toString() + ",isMeasurement:" + this.z + ",stable:" + this.x + ",isHistory:" + this.y + ",isFinish:" + this.A + ">";
    }
}
