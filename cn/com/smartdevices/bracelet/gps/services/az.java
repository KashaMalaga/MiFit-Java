package cn.com.smartdevices.bracelet.gps.services;

import android.support.v4.widget.C0203a;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.h.h;
import com.amap.api.maps.model.GroundOverlayOptions;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class az extends aa {
    public static final String B = "al";
    public static final String C = "st";
    public static final String D = "ed";
    public static final String E = "ctoffstpm";
    public static final String F = "ctoflstpm";
    public static final String G = "step";
    public static final String H = "sf";
    public static final String I = "stepct";
    public static final String J = "stepm";
    public static final String K = "dgc";
    public static final String L = "section";
    public static final String M = "s";
    public static final String N = "e";
    public static final String O = "mins";
    public static final String P = "maxs";
    public static final String Q = "minp";
    public static final String R = "maxp";
    public static final String S = "stepf";
    public static final String T = "stepmf";
    public static final String U = "ffp";
    public static final String V = "avghr";
    public static final String W = "hrs";
    public static final String X = "hrtm";
    public static final int af = -1;
    public static final int ag = -1;
    private static final long serialVersionUID = 1;
    SparseArray<Integer[]> Y;
    double Z;
    float aA;
    private final byte[] aB;
    double aa;
    float ab;
    float ac;
    long ad;
    long ae;
    int ah;
    float ai;
    float aj;
    float ak;
    int al;
    float am;
    float an;
    float ao;
    float ap;
    List<O> aq;
    long ar;
    int as;
    int at;
    int au;
    float av;
    long aw;
    int ax;
    int ay;
    int az;

    public az(long j, int i, String str) {
        super(j, i, str);
        this.Y = null;
        this.Z = 0.0d;
        this.aa = 0.0d;
        this.ab = 0.0f;
        this.ac = 0.0f;
        this.ad = 0;
        this.ae = 0;
        this.ah = ag;
        this.ai = GroundOverlayOptions.NO_DIMENSION;
        this.aj = C0203a.b;
        this.ak = Float.MIN_VALUE;
        this.al = 0;
        this.am = Float.MIN_VALUE;
        this.an = C0203a.b;
        this.ao = Float.MIN_VALUE;
        this.ap = C0203a.b;
        this.aq = new ArrayList();
        this.aB = new byte[0];
        this.ar = -1;
        this.as = ag;
        this.at = ag;
        this.au = ag;
        this.av = GroundOverlayOptions.NO_DIMENSION;
        this.aw = -1;
        this.ax = ag;
        this.ay = 0;
        this.az = 0;
        this.aA = GroundOverlayOptions.NO_DIMENSION;
        this.ad = System.currentTimeMillis() / 1000;
        this.Y = new SparseArray();
    }

    public az(JSONObject jSONObject, long j, int i, String str) {
        int i2 = 0;
        super(jSONObject, j, i, str);
        this.Y = null;
        this.Z = 0.0d;
        this.aa = 0.0d;
        this.ab = 0.0f;
        this.ac = 0.0f;
        this.ad = 0;
        this.ae = 0;
        this.ah = ag;
        this.ai = GroundOverlayOptions.NO_DIMENSION;
        this.aj = C0203a.b;
        this.ak = Float.MIN_VALUE;
        this.al = 0;
        this.am = Float.MIN_VALUE;
        this.an = C0203a.b;
        this.ao = Float.MIN_VALUE;
        this.ap = C0203a.b;
        this.aq = new ArrayList();
        this.aB = new byte[0];
        this.ar = -1;
        this.as = ag;
        this.at = ag;
        this.au = ag;
        this.av = GroundOverlayOptions.NO_DIMENSION;
        this.aw = -1;
        this.ax = ag;
        this.ay = 0;
        this.az = 0;
        this.aA = GroundOverlayOptions.NO_DIMENSION;
        try {
            if (!jSONObject.isNull(C)) {
                this.ad = jSONObject.getLong(C);
            }
            if (!jSONObject.isNull(D)) {
                this.ae = jSONObject.getLong(D);
            }
            if (!jSONObject.isNull(G)) {
                this.ah = jSONObject.getInt(G);
            }
            if (!jSONObject.isNull(I)) {
                this.ar = (long) jSONObject.getInt(I);
            }
            if (!jSONObject.isNull(E)) {
                this.aj = Float.valueOf(jSONObject.getString(E)).floatValue();
            }
            if (!jSONObject.isNull(F)) {
                this.ak = Float.valueOf(jSONObject.getString(F)).floatValue();
            }
            if (!jSONObject.isNull(K)) {
                this.al = jSONObject.getInt(K);
            }
            if (!jSONObject.isNull(O)) {
                this.an = Float.valueOf(jSONObject.getString(O)).floatValue();
            }
            if (!jSONObject.isNull(P)) {
                this.am = Float.valueOf(jSONObject.getString(P)).floatValue();
            }
            if (!jSONObject.isNull(Q)) {
                this.ap = Float.valueOf(jSONObject.getString(Q)).floatValue();
            }
            if (!jSONObject.isNull(R)) {
                this.ao = Float.valueOf(jSONObject.getString(R)).floatValue();
            }
            if (!jSONObject.isNull(T)) {
                this.at = jSONObject.getInt(T);
            } else if (!jSONObject.isNull(S)) {
                this.at = jSONObject.getInt(T);
            }
            if (!jSONObject.isNull(J)) {
                this.as = jSONObject.getInt(J);
            }
            if (!jSONObject.isNull(V)) {
                this.aA = (float) jSONObject.getInt(V);
            }
            if (!jSONObject.isNull(W)) {
                this.ay = jSONObject.getInt(W);
            }
            if (!jSONObject.isNull(X)) {
                this.az = jSONObject.getInt(X);
            }
            if (jSONObject.isNull(U)) {
                this.au = O();
            } else {
                this.au = jSONObject.getInt(U);
            }
            if (jSONObject.isNull(H)) {
                this.av = (float) N();
            } else {
                this.av = (float) jSONObject.getInt(H);
            }
            if (!jSONObject.isNull(B)) {
                Object string = jSONObject.getString(B);
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split(a.ci);
                    if (split != null && split.length >= 2) {
                        this.Z = Double.valueOf(split[0]).doubleValue();
                        this.aa = Double.valueOf(split[1]).doubleValue();
                    }
                }
            }
            if (!jSONObject.isNull(L)) {
                JSONArray jSONArray = jSONObject.getJSONArray(L);
                int length = jSONArray.length();
                if (length > 0) {
                    this.Y = new SparseArray(length);
                    while (i2 < length) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        this.Y.put(i2, new Integer[]{Integer.valueOf(jSONObject2.getInt(M)), Integer.valueOf(jSONObject2.getInt(N))});
                        i2++;
                    }
                }
            }
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
    }

    private int N() {
        return (this.ar <= 0 || this.ah <= 0) ? this.ah == 0 ? 0 : ag : (int) (((long) (this.ah * 60)) / this.ar);
    }

    private int O() {
        return (this.as <= 0 || this.at <= 0) ? (this.as == 0 || this.at == 0) ? 0 : ag : (this.at * 100) / this.as;
    }

    public double[] A() {
        return new double[]{this.aa, this.Z};
    }

    public List<O> B() {
        List<O> list;
        synchronized (this.aB) {
            list = this.aq;
        }
        return list;
    }

    public float C() {
        return this.ab;
    }

    public float D() {
        return this.ac;
    }

    public float E() {
        return this.ak;
    }

    public int F() {
        return this.al;
    }

    public int G() {
        return (int) this.ai;
    }

    public List<Integer[]> H() {
        if (this.Y == null) {
            return null;
        }
        int size = this.Y.size();
        List<Integer[]> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.Y.get(i));
        }
        return arrayList;
    }

    public float I() {
        return this.aj;
    }

    public long J() {
        return this.ad;
    }

    public int K() {
        return this.ah;
    }

    public long L() {
        return this.ae;
    }

    JSONArray M() {
        JSONArray jSONArray;
        synchronized (this.aB) {
            jSONArray = new JSONArray();
            for (O a : this.aq) {
                JSONObject a2 = a.a();
                if (a2 != null && a2.length() > 0) {
                    jSONArray.put(a2);
                }
            }
        }
        return jSONArray;
    }

    public JSONObject a() {
        JSONObject a = super.a();
        try {
            a.put(K, this.al);
            a.put(C, this.ad);
            a.put(D, this.ae);
            a.put(G, this.ah);
            a.put(I, this.ar);
            a.put(T, this.at);
            a.put(J, this.as);
            a.put(E, this.aj == C0203a.b ? Integer.valueOf(0) : h.b(this.aj, 6));
            a.put(F, this.ak == Float.MIN_VALUE ? Integer.valueOf(0) : h.b(this.ak, 6));
            a.put(B, this.Z + a.ci + this.aa);
            a.put(O, this.an == C0203a.b ? Integer.valueOf(0) : h.b(this.an, 6));
            a.put(P, this.am == Float.MIN_VALUE ? Integer.valueOf(0) : h.b(this.am, 6));
            a.put(Q, this.ap == C0203a.b ? Integer.valueOf(0) : h.b(this.ap, 6));
            a.put(R, this.ao == Float.MIN_VALUE ? Integer.valueOf(0) : h.b(this.ao, 6));
            a.put(V, (int) this.aA);
            a.put(X, this.az);
            a.put(W, this.ay);
            if (this.Y != null && this.Y.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int size = this.Y.size();
                for (int i = 0; i < size; i++) {
                    Integer[] numArr = (Integer[]) this.Y.get(i);
                    if (numArr.length == 2) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(M, numArr[0]);
                        jSONObject.put(N, numArr[1]);
                        jSONArray.put(jSONObject);
                    }
                }
                a.put(L, jSONArray);
            }
        } catch (JSONException e) {
            C0596r.a(p.a, e.getMessage());
        }
        return a;
    }

    void a(int i, int i2) {
        if (this.Y == null) {
            throw new IllegalStateException();
        }
        this.Y.put(this.Y.size(), new Integer[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    void a(long j, String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.aB) {
                this.aq = O.a(str);
            }
        }
    }

    void a(O o) {
        synchronized (this.aB) {
            this.aq.add(o);
        }
    }

    void b(int i) {
        this.al = i;
    }

    void b(int i, int i2) {
        if (this.Y == null || this.Y.size() < 1) {
            throw new IllegalStateException();
        }
        this.Y.put(this.Y.size() + ag, new Integer[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString() {
        return com.xiaomi.e.a.f;
    }

    public void w() {
        synchronized (this.aB) {
            this.aq.clear();
        }
    }

    public int x() {
        return (int) this.av;
    }

    public int y() {
        return (int) this.aA;
    }

    public int z() {
        return this.au;
    }
}
