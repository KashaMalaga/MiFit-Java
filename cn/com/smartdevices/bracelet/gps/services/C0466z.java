package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.b.b;
import cn.com.smartdevices.bracelet.gps.b.c;
import cn.com.smartdevices.bracelet.gps.c.a.t;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.services.b.k;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.Serializable;
import java.util.List;
import kankan.wheel.widget.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0466z implements Serializable {
    public static final String a = "trackId";
    public static final int b = 60;
    private static final String c = "GPSTrackInfo";
    private static final long serialVersionUID = 1;
    private int d = 4;
    private az e = null;
    private long f = 0;
    private int g = t.SYNC_STATE_DEFAULT.a();
    private c h = null;
    private float i = 0.0f;
    private long j = 0;
    private int k = 0;
    private float l = 0.0f;
    private k m = null;
    private k n = null;
    private int o = 0;
    private int p = 0;

    public C0466z(int i, long j, String str) {
        this.e = new az(j, i, str);
        this.f = j;
        this.d = i;
        this.h = b.a(4);
        this.m = new k(3);
        this.n = new k(3);
        this.l = cn.com.smartdevices.bracelet.gps.e.b.a();
        this.o = this.e.az;
        this.p = this.e.ay;
    }

    private void T() {
        int i = 0;
        if (this.e.as > 0) {
            i = (this.e.at * 100) / this.e.as;
        }
        C0596r.d(c, "zprintForefootInfo updateForefootInfo pecent = " + i + ",mTotalMinutesSteps = " + this.e.as + ",mTotalForfootSteps = " + this.e.at);
    }

    private void U() {
        float f = 0.0f;
        if (this.e.ar > 0) {
            f = (((float) this.e.ah) * BitmapDescriptorFactory.HUE_YELLOW) / ((float) this.e.ar);
        }
        C0596r.d(c, "zprintRtStepsInfo totalSteps = " + this.e.ah + ",totalTime = " + this.e.ar + ",avgStepFreq = " + f);
    }

    private float a(float f, long j) {
        float f2 = f - this.i;
        long j2 = j - this.j;
        if (f2 < 0.0f) {
            f2 = -this.h.a((int) Math.abs(f2), j2, this.l);
        } else {
            f2 = this.m.a(Float.valueOf(this.h.a((int) f2, j2)));
        }
        this.i = f;
        this.j = j;
        return f2;
    }

    public static int a(int i) {
        return i % b == 0 ? i / b : (i / b) + 1;
    }

    public az A() {
        return this.e;
    }

    public int B() {
        return this.g;
    }

    public float C() {
        return this.e.o;
    }

    public long D() {
        return this.e.r;
    }

    public long E() {
        return this.e.s + this.e.r;
    }

    public long F() {
        return this.e.s;
    }

    public long G() {
        return this.f;
    }

    public boolean H() {
        return this.e.p();
    }

    public boolean I() {
        return t.STATE_SYNCED_FROM_SERVER.a() == this.g;
    }

    public boolean J() {
        return t.STATE_SYNCED_TO_SERVER.a() == this.g;
    }

    public boolean K() {
        return this.e.s();
    }

    public boolean L() {
        return t.STATE_SYNCED_FROM_SERVER_SUMMERY_DONE.a() == this.g;
    }

    public boolean M() {
        return t.STATE_UNSYNCED.a() != this.g;
    }

    public boolean N() {
        return this.e.v();
    }

    String O() {
        return this.e.A;
    }

    int P() {
        return this.e.at;
    }

    int Q() {
        return this.e.as;
    }

    long R() {
        return this.e.ar;
    }

    void S() {
        this.e.ae = System.currentTimeMillis() / 1000;
    }

    O a(ay ayVar, boolean z) {
        this.e.o = ayVar.a.mTotalDistance >= this.e.o ? ayVar.a.mTotalDistance : this.e.o;
        if (ayVar.a.mTotalTime >= 0) {
            this.e.s = ayVar.a.mTotalTime;
        }
        if (ayVar.a.mTotalPauseTime >= 0) {
            this.e.r = ayVar.a.mTotalPauseTime;
        }
        if (this.k % 2 == 0 || z) {
            az azVar = this.e;
            azVar.t += a(this.e.l(), this.e.n());
        }
        this.k++;
        if (ayVar.a.mTotalSpeed >= 0.0f) {
            this.e.p = ayVar.a.mTotalSpeed;
        }
        if (ayVar.a.mTotalSpeed >= 0.0f) {
            this.e.q = ayVar.a.mTotalPace;
        }
        if (ayVar.a.mRealtimeSpeed >= 0.0f) {
            this.e.ac = ayVar.a.mRealtimeSpeed;
        }
        if (ayVar.a.mRealtimePace >= 0.0f) {
            this.e.ab = ayVar.a.mRealtimePace;
        }
        if (this.e.ao <= ayVar.a.mRealtimePace && ayVar.a.mRealtimePace >= 0.0f) {
            this.e.ao = ayVar.a.mRealtimePace;
        }
        if (this.e.ap >= ayVar.a.mRealtimePace && ayVar.a.mRealtimePace >= 0.0f) {
            this.e.ap = ayVar.a.mRealtimePace;
        }
        if (this.e.am <= ayVar.a.mRealtimeSpeed && ayVar.a.mRealtimeSpeed >= 0.0f) {
            this.e.am = ayVar.a.mRealtimeSpeed;
        }
        if (this.e.an >= ayVar.a.mRealtimeSpeed && ayVar.a.mRealtimeSpeed >= 0.0f) {
            this.e.an = ayVar.a.mRealtimeSpeed;
        }
        e.a("Summary", "updateSummeryInfo mTotalDistance = " + this.e.o + ",mTotalUsedTime = " + this.e.s + ",mAvgSpeed = " + this.e.p + ",mAvgPaceSpeed = " + this.e.q + ",mInstantSpeed = " + this.e.ac + ",mInstantPaceSpeed = " + this.e.ab + ",mTotalPausedTime = " + this.e.r);
        if (this.e.B() == null || ayVar.a.mKilometerSpeeds == null) {
            return null;
        }
        int i = ayVar.a.mLastKilometerNum;
        if (i <= 0) {
            return null;
        }
        if (i <= this.e.B().size()) {
            return null;
        }
        int i2 = 0;
        O o = null;
        while (i2 < i) {
            int size = this.e.B().size();
            if (i2 >= size) {
                int i3;
                O o2 = new O(this.e.u);
                o2.a(size);
                o2.b(ayVar.a.mKilometerTimestamps[i2] > 0 ? ayVar.a.mKilometerTimestamps[i2] : 0);
                o2.b(ayVar.a.mKilometerSpeeds[i2] > 0.0f ? ayVar.a.mKilometerSpeeds[i2] : 0.0f);
                o2.a(ayVar.a.mKilometerPaces[i2] > 0.0f ? ayVar.a.mKilometerPaces[i2] : 0.0f);
                if (o2.l <= this.e.aj && o2.l >= 0.0f) {
                    this.e.aj = o2.l;
                }
                if (o2.l >= this.e.ak && o2.l >= 0.0f) {
                    this.e.ak = o2.l;
                }
                if (size == 0) {
                    i3 = (int) this.e.aA;
                } else {
                    int i4 = this.e.az - this.o;
                    i3 = i4 > 0 ? (this.e.ay - this.p) / i4 : 0;
                }
                C0596r.e(c, this.e.ay + a.ci + this.e.az + a.ci + this.p + a.ci + this.o);
                this.o = this.e.az;
                this.p = this.e.ay;
                o2.b(i3);
                this.e.a(o2);
                o = o2;
            }
            i2++;
        }
        if (o == null) {
            return o;
        }
        e.a("Summary", "IndexedKilometerInfo index = " + o.d() + ",mUsedTime = " + o.n + ",mAvgSpeed = " + o.k + ",mAvgPaceSpeed = " + o.l + ",mAvgHR = " + o.q);
        return o;
    }

    public JSONArray a() {
        return this.e.M();
    }

    void a(int i, int i2) {
        this.e.a(i, i2);
    }

    void a(int i, long j) {
        this.e.ah = i;
        this.e.ar = j;
    }

    void a(int i, long j, float f) {
        a(i, j);
        this.e.ai = f;
    }

    public void a(long j, int i, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.e = new az(new JSONObject(str2), j, i, str);
            } catch (JSONException e) {
                C0596r.d(c, e.getMessage());
                this.e = new az(new JSONObject(), j, i, str);
            }
        }
    }

    public void a(long j, String str) {
        this.e.a(j, str);
    }

    public void a(Context context, ac acVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        this.e.a(context, acVar, false);
    }

    void a(cn.com.smartdevices.bracelet.gps.model.c cVar) {
        if (cVar != null) {
            this.e.x = cVar.p;
            this.e.y = cVar.q;
        }
    }

    public void a(String str) {
        this.e.a(str);
    }

    public JSONObject b() {
        if (this.e != null) {
            return this.e.a();
        }
        throw new IllegalStateException();
    }

    public void b(int i) {
        this.e.b(i);
    }

    void b(int i, int i2) {
        this.e.at = i;
        this.e.as = i2;
    }

    void b(cn.com.smartdevices.bracelet.gps.model.c cVar) {
        if (cVar != null) {
            if (cVar.o >= this.e.Z) {
                this.e.Z = cVar.o;
            } else if (cVar.o < this.e.aa || cVar.o == 0.0d) {
                this.e.aa = cVar.o;
            }
        }
    }

    void b(String str) {
        this.e.A = str;
    }

    public void c() {
        this.f = -1;
        if (this.m != null) {
            this.m.a();
        }
        if (this.n != null) {
            this.n.a();
        }
        this.e.w();
    }

    public void c(int i) {
        this.d = i;
    }

    void c(int i, int i2) {
        this.e.b(i, i2);
    }

    void c(cn.com.smartdevices.bracelet.gps.model.c cVar) {
        if (cVar != null) {
            this.e.v = cVar.p;
            this.e.w = cVar.q;
        }
    }

    public float d() {
        return this.e.q;
    }

    public void d(int i) {
        this.g = i;
    }

    public float e() {
        return this.e.p;
    }

    void e(int i) {
        if (i > 0) {
            this.e.b(C0466z.a(i));
        }
    }

    public int f() {
        return this.e.x();
    }

    void f(int i) {
        long j = this.e.aw;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int i2 = (int) (currentTimeMillis - j);
        if (HeartRateInfo.isHRValueValid(i) && i2 >= 1) {
            int i3 = this.e.ax;
            C0596r.e(c, j + a.ci + currentTimeMillis);
            C0596r.e(c, "offset:" + i2 + "-----" + "hr:" + i);
            az azVar;
            if (i3 == -1 || i2 > b) {
                azVar = this.e;
                azVar.ay += i;
                azVar = this.e;
                azVar.az++;
            } else {
                azVar = this.e;
                azVar.ay += (i3 * (i2 - 1)) + i;
                azVar = this.e;
                azVar.az += i2;
            }
            this.e.aw = currentTimeMillis;
            this.e.ax = i;
            this.e.aA = ((float) this.e.ay) / ((float) this.e.az);
            C0596r.e(c, this.e.ay + a.ci + this.e.ay + a.ci + this.e.aA);
        }
    }

    public int g() {
        return this.e.y();
    }

    public String h() {
        return this.e.z;
    }

    public float i() {
        return this.e.t;
    }

    public String j() {
        return this.e.n;
    }

    public double[] k() {
        return this.e.h();
    }

    public int l() {
        return this.e.z();
    }

    public double[] m() {
        return this.e.A();
    }

    public List<O> n() {
        return this.e.B();
    }

    public float o() {
        return this.e.ac;
    }

    public float p() {
        return this.e.ak;
    }

    public float q() {
        return this.e.ab;
    }

    public int r() {
        return this.e.F();
    }

    public int s() {
        return (int) this.e.ai;
    }

    public List<Integer[]> t() {
        return this.e.H();
    }

    public String toString() {
        if (this.e == null) {
            return "Summary is null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GPSTrackInfo: \n").append("Uri:").append(this.e.d()).append(",Summary:").append(this.e.a().toString()).append("\n");
        return stringBuilder.toString();
    }

    public float u() {
        return this.e.aj;
    }

    public int v() {
        return this.d;
    }

    public double[] w() {
        return this.e.j();
    }

    public long x() {
        return this.e.ad;
    }

    public int y() {
        return this.e.ah;
    }

    public long z() {
        return this.e.L();
    }
}
