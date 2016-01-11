package cn.com.smartdevices.bracelet.gps.c;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements Cloneable {
    public static final String a = "broadcase_config_change";
    public static final float b = 0.2f;
    public static final String c = "goal";
    public static final String d = "dis";
    public static final String e = "mps";
    public static final String f = "lspm";
    public static final String g = "hspm";
    public static final String h = "lmt";
    public static final String i = "pacestate";
    public static final String j = "hrstate";
    public static final String k = "speedstate";
    public static final String l = "disstate";
    public static final String m = "srstate";
    public static final String n = "hrremind_state";
    public static final String o = "hrmax";
    public static final int p = -1;
    public static final int q = 1;
    public static final int r = 0;
    private static final String s = "RunConfig";
    private static final int t = 20000;
    private int A = p;
    private int B = p;
    private int C = p;
    private int D = p;
    private int E = p;
    private int F = p;
    private int G = q;
    private int H = p;
    private int I = p;
    private int u = r;
    private int v = r;
    private int w = r;
    private int x = r;
    private int y = r;
    private long z = 0;

    public d(int i) {
        if (h(i)) {
            this.B = i;
            return;
        }
        throw new IllegalArgumentException("Invalide type");
    }

    public d(int i, String str) {
        if (h(i)) {
            this.B = i;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(c)) {
                    this.u = jSONObject.getInt(c);
                }
                if (!jSONObject.isNull(d)) {
                    this.v = jSONObject.getInt(d);
                }
                if (!jSONObject.isNull(e)) {
                    this.w = jSONObject.getInt(e);
                }
                if (!jSONObject.isNull(f)) {
                    this.x = jSONObject.getInt(f);
                }
                if (!jSONObject.isNull(g)) {
                    this.y = jSONObject.getInt(g);
                }
                if (!jSONObject.isNull(h)) {
                    this.z = jSONObject.getLong(h);
                }
                if (!jSONObject.isNull(i)) {
                    this.C = jSONObject.getInt(i);
                }
                if (jSONObject.isNull(j)) {
                    this.G = q;
                } else {
                    this.G = jSONObject.getInt(j);
                }
                if (!jSONObject.isNull(o)) {
                    this.I = jSONObject.getInt(o);
                }
                if (!jSONObject.isNull(n)) {
                    this.H = jSONObject.getInt(n);
                }
                if (!jSONObject.isNull(k)) {
                    this.D = jSONObject.getInt(k);
                }
                if (!jSONObject.isNull(l)) {
                    this.E = jSONObject.getInt(l);
                }
                if (!jSONObject.isNull(m)) {
                    this.F = jSONObject.getInt(m);
                    return;
                }
                return;
            } catch (JSONException e) {
                C0596r.a(p.a, e.getMessage());
                return;
            }
        }
        throw new IllegalArgumentException("Invalide type");
    }

    private boolean h(int i) {
        return c.a(i);
    }

    public d a() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            C0596r.a(s, e.getMessage());
            return null;
        }
    }

    public void a(int i) {
        this.w = i;
    }

    public void a(long j) {
        this.z = j;
    }

    public void a(boolean z) {
        this.F = z ? q : r;
    }

    public boolean a(long j, float f) {
        return j <= 20000 || f <= b || f <= ((float) this.x);
    }

    public int b() {
        return this.w;
    }

    public void b(int i) {
        this.u = i;
    }

    public void b(boolean z) {
        this.E = z ? q : r;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.x > 0) {
                jSONObject.put(f, this.x);
            }
            if (this.y > 0) {
                jSONObject.put(g, this.y);
            }
            if (this.w > 0) {
                jSONObject.put(e, this.w);
            }
            if (this.v > 0) {
                jSONObject.put(d, this.v);
            }
            if (this.u > 0) {
                jSONObject.put(c, this.u);
            }
            if (this.z > 0) {
                jSONObject.put(h, this.z);
            }
            if (this.C > p) {
                jSONObject.put(i, this.C);
            }
            if (this.G > p) {
                jSONObject.put(j, this.G);
            }
            if (this.H > p) {
                jSONObject.put(n, this.H);
            }
            if (HeartRateInfo.isHRValueValid(this.I)) {
                jSONObject.put(o, this.I);
            }
            if (this.D > p) {
                jSONObject.put(k, this.D);
            }
            if (this.E > p) {
                jSONObject.put(l, this.E);
            }
            if (this.F > p) {
                jSONObject.put(m, this.F);
            }
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
        return jSONObject;
    }

    public void c(int i) {
        this.y = i;
    }

    public void c(boolean z) {
        this.C = z ? q : r;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public int d() {
        return this.u;
    }

    public void d(int i) {
        this.v = i;
    }

    public void d(boolean z) {
        this.G = z ? q : r;
    }

    public int e() {
        return this.y;
    }

    public void e(int i) {
        this.x = i;
    }

    public void e(boolean z) {
        this.D = z ? q : r;
    }

    public int f() {
        return this.v;
    }

    public void f(int i) {
        this.A = i;
    }

    public void f(boolean z) {
        this.H = z ? q : r;
    }

    public long g() {
        return this.z;
    }

    public void g(int i) {
        this.I = i;
    }

    public int h() {
        return this.x;
    }

    public int i() {
        return this.B;
    }

    public boolean j() {
        return this.F == q;
    }

    public boolean k() {
        return this.E == q;
    }

    public boolean l() {
        return this.C == q;
    }

    public boolean m() {
        return this.G == q;
    }

    public boolean n() {
        return this.D == q;
    }

    public boolean o() {
        return t.STATE_UNSYNCED.a() != this.A;
    }

    public boolean p() {
        return this.H == q;
    }

    public int q() {
        return this.I;
    }

    public String toString() {
        return c().toString();
    }
}
