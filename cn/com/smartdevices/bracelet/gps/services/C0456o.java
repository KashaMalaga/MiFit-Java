package cn.com.smartdevices.bracelet.gps.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.content.v;
import android.support.v4.widget.C0203a;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.algorithm.GPSManager;
import cn.com.smartdevices.bracelet.gps.algorithm.GaoceptUtils;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.b;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.g.a;
import cn.com.smartdevices.bracelet.gps.g.h;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.h.i;
import cn.com.smartdevices.bracelet.gps.h.l;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import cn.com.smartdevices.bracelet.gps.model.k;
import cn.com.smartdevices.bracelet.gps.services.b.o;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

class C0456o implements C, L, aj {
    private static final int E = 180;
    private GPSManager A = null;
    private C0455n B = null;
    private float C = C0203a.b;
    private int D = 0;
    private C0458q F = null;
    private long G = 0;
    private boolean H = false;
    private StepProvider I = null;
    private BroadcastReceiver J = null;
    private v K = null;
    private ArrayList<HeartRateItem> L = new ArrayList(20);
    private final I a;
    private int b = Integer.MAX_VALUE;
    private boolean c;
    private long d = -1;
    private long e = -1;
    private int f = -1;
    private C0442t g = new C0459r();
    private final ArrayList<c> h = new ArrayList();
    private C0460s i = null;
    private d j = null;
    private SparseArray<c> k = null;
    private C0466z l = null;
    private int m = 0;
    private int n = -1;
    private ay o = null;
    private List<c> p = null;
    private Q q = null;
    private a r = null;
    private long s = 0;
    private A t = null;
    private Timer u = null;
    private long v = 0;
    private C0461u w = null;
    private boolean x = true;
    private C0464x y = null;
    private Context z = null;

    public C0456o(Context context, long j, C0464x c0464x) {
        this.z = context;
        this.y = c0464x;
        this.p = new ArrayList();
        this.k = new SparseArray();
        this.r = new a(this.z);
        this.i = new C0460s();
        this.C = b.d(context);
        this.J = new C0457p(this);
        this.K = v.a(context);
        this.K.a(this.J, new IntentFilter(d.a));
        this.B = new C0455n(5000, GeocodeSearch.GPS, this);
        HandlerThread handlerThread = new HandlerThread("runsynced");
        handlerThread.start();
        this.F = new C0458q(this, context, handlerThread.getLooper());
        C0596r.e("RService", "Finally TrackId = " + j);
        this.I = am.a(context);
        this.A = new GPSManager(o.a().getAbsolutePath());
        boolean c = c(j);
        this.a = new I(context);
        if (c && this.I != null) {
            this.I.a(this.l.O());
            this.I.a(this.l.y(), this.l.R());
            this.I.a(this.l.P(), this.l.Q());
        }
        if (this.I != null) {
            this.I.a((aj) this);
            this.l.b(this.I.b());
        }
        this.a.a((L) this);
    }

    static /* synthetic */ long a(C0456o c0456o, long j) {
        long j2 = c0456o.v + j;
        c0456o.v = j2;
        return j2;
    }

    private c a(int i, double d, double d2) {
        if (i < 0 || i >= o()) {
            e.a("RService", "revisePoint index OutOfBound = " + i + ",listSize = " + o());
            return null;
        }
        c cVar = (c) this.k.get(i);
        if (cVar == null) {
            return null;
        }
        cVar.p = d;
        cVar.q = d2;
        return cVar;
    }

    private void a(Context context, int i) {
        List arrayList = new ArrayList(this.p.size());
        arrayList.addAll(this.p);
        this.p.clear();
        Message obtainMessage = this.F.obtainMessage(1);
        obtainMessage.obj = arrayList;
        obtainMessage.arg1 = i;
        this.F.sendMessage(obtainMessage);
    }

    private void a(String str) {
        C0596r.e("RService", str + "  Booked mBaseIndex = " + this.D + ",mTickerTime = " + this.v + ",state = " + this.o.I + ",\nBooked mDeathStatistics = " + this.o.toString());
    }

    private void a(List<c> list, c cVar, boolean z, boolean z2) {
        a((List) list, z, z2);
        this.o.a = this.A.getTrackParameter(true);
        a(this.o.a.mRealtimePace, this.o.a.mRealtimeSpeed);
        O a = this.l.a(this.o, false);
        if (a != null && cn.com.smartdevices.bracelet.gps.e.b.c() == 0) {
            h hVar = new h();
            hVar.b = a.b();
            hVar.c = a.f();
            hVar.e = this.f;
            if (a.d() == 0 && hVar.b * 1000.0f != ((float) hVar.c)) {
                hVar.b = ((float) a.f()) / 1000.0f;
            }
            hVar.a = this.l.C();
            this.r.a(hVar);
        }
        if (cVar != null) {
            this.l.b(cVar);
            cVar.s = this.l.o();
        }
        if (z2) {
            this.y.a(this.l.A());
        }
        if (z) {
            g(o());
        }
    }

    private boolean a(float f, float f2) {
        if (this.j != null && this.H && cn.com.smartdevices.bracelet.gps.e.a.f()) {
            float b = i.b(f);
            if (b <= d.b || b <= ((float) this.j.h())) {
                this.d = -1;
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.d == -1) {
                this.d = currentTimeMillis;
                return false;
            } else if (currentTimeMillis - this.d <= 15000) {
                return false;
            } else {
                this.d = -1;
                cn.com.smartdevices.bracelet.gps.e.a.a(cn.com.smartdevices.bracelet.gps.c.a.o, (short) 0, (byte) 1);
                return true;
            }
        }
        this.d = -1;
        return false;
    }

    private boolean a(Context context, ArrayList<HeartRateItem> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        boolean a = p.a(context, (ArrayList) arrayList);
        arrayList.clear();
        return a;
    }

    private boolean a(Context context, List<c> list) {
        boolean z = true;
        int b = p.b(context, this.l) & 1;
        if (list.size() > 0) {
            z = p.a(context, (List) list, this.l.G()) & b;
            if (z) {
                p.h(context, this.l.G(), 4);
            }
            list.clear();
        }
        return z;
    }

    private boolean a(List<c> list, boolean z, boolean z2) {
        if (list == null) {
            return false;
        }
        int size = list.size();
        if (size <= 0) {
            return false;
        }
        List arrayList = new ArrayList(size);
        for (c cVar : list) {
            c cVar2 = a(cVar2.d(), cVar2.p, cVar2.q);
            if (cVar2 != null) {
                this.p.add(cVar2);
                arrayList.add(cVar2);
            }
        }
        if (z2) {
            this.y.a(arrayList, new g(true, 0));
        }
        arrayList.clear();
        return true;
    }

    private void b(long j) {
        List t = this.l.t();
        int size = t.size();
        this.q = size <= 0 ? new Q() : new Q(((Integer[]) t.get(size - 1))[0].intValue(), ((Integer[]) t.get(size - 1))[1].intValue());
        this.D = this.o.J;
        this.v = this.l.E() * 1000;
        h(this.o.I);
        i();
    }

    private void c(int i) {
        if (i >= this.b && cn.com.smartdevices.bracelet.gps.model.e.a(this.m) && this.c) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.e == -1) {
                this.e = currentTimeMillis;
                return;
            } else if (currentTimeMillis - this.e > 15000) {
                this.e = -1;
                cn.com.smartdevices.bracelet.gps.e.a.a(cn.com.smartdevices.bracelet.gps.c.a.l, cn.com.smartdevices.bracelet.gps.c.a.m, (byte) 2);
                d(i);
                return;
            } else {
                return;
            }
        }
        this.e = -1;
    }

    private boolean c(long j) {
        if (j > 0) {
            this.l = p.d(this.z, j);
            this.o = p.c(this.z, j);
        }
        boolean z = false;
        if (!(this.l == null || this.o == null)) {
            C0596r.e("RService", "initDeathTrackInfoFromDB from death");
            b(j);
            z = this.A.recoverFromCrash("Running", com.xiaomi.e.a.f, this.o.a);
        }
        if (!z) {
            if (j > 0) {
                p.a(this.z, j);
            }
            this.A.start("Running", com.xiaomi.e.a.f);
            p();
        }
        return z;
    }

    private void d(int i) {
        this.r.a(i);
    }

    private void d(boolean z) {
        if (this.I == null) {
            return;
        }
        if (z) {
            this.I.start();
        } else {
            this.I.f();
        }
    }

    private c e(boolean z) {
        c c = c();
        if (c == null) {
            return null;
        }
        int b = c.b();
        if (!c.a(b)) {
            e.a("Lost", "updateEPWithInactive !isActiveAttr attr = " + b);
            return null;
        } else if ((System.currentTimeMillis() / 1000) - c.e() >= 180) {
            c.b(4);
            e.a("Lost", "updateEPWithInactive found lost in second 180");
            return c;
        } else {
            c.b(z ? 2 : 3);
            return c;
        }
    }

    private void e(int i) {
        if (HeartRateInfo.isHRValueValid(i)) {
            this.L.add(new HeartRateItem(i, 1, System.currentTimeMillis() / 1000));
            if (this.L.size() >= 20) {
                Message obtainMessage = this.F.obtainMessage(3);
                obtainMessage.obj = this.L;
                this.F.sendMessage(obtainMessage);
            }
        }
    }

    private void e(c cVar) {
        this.k.remove(cVar.d());
    }

    private void f(int i) {
        int i2 = this.A.statusEstimation(i, this.n) == 0 ? 2 : 3;
        if (i2 != this.m) {
            if (i2 == 2 && cn.com.smartdevices.bracelet.gps.model.e.a(this.m)) {
                b(false);
                this.y.a(this.m, false);
                l.b(this.z);
            } else if (i2 == 3 && !cn.com.smartdevices.bracelet.gps.model.e.a(this.m)) {
                c(false);
                this.y.a(this.m, false);
            }
        }
    }

    private void f(c cVar) {
        this.p.add(cVar);
    }

    private void g(int i) {
        this.l.e(i);
        a(this.z, i);
    }

    private boolean h(int i) {
        int i2 = 0;
        int o;
        Q q;
        if (this.m != i && cn.com.smartdevices.bracelet.gps.model.e.a(i)) {
            this.G = 0;
            s();
            this.m = i;
            d(this.x);
            this.q.e();
            o = o();
            q = this.q;
            if (o <= 0) {
                o = 0;
            }
            q.b(o);
            this.q.a(this.q.d());
            this.l.a(this.q.d(), this.q.b());
            i();
            return true;
        } else if (this.m == i || !cn.com.smartdevices.bracelet.gps.model.e.b(i)) {
            return false;
        } else {
            this.m = i;
            l();
            if (this.I != null) {
                ap stop = this.I.stop();
                if (stop != null) {
                    this.l.a(stop.a, stop.b);
                    this.l.b(stop.d, stop.c);
                    C0596r.d("SRun", "Stop result = " + stop.toString());
                }
            }
            o = o();
            q = this.q;
            if (o > 0) {
                i2 = o - 1;
            }
            q.a(i2);
            this.l.c(this.q.d(), this.q.b());
            return true;
        }
    }

    private void i(int i) {
        this.n = i;
        q();
    }

    private void j(int i) {
        if (i == 2 || i == 4) {
            Object end;
            if (i == 4) {
                end = this.A.end(false);
            } else {
                ArrayList pauseRunning = this.A.pauseRunning();
            }
            boolean z = end != null && end.size() > 0;
            if (z) {
                a(end, null, true, false);
                end.clear();
                return;
            }
            n();
            return;
        }
        throw new IllegalArgumentException("Current support paused and end state");
    }

    private void l() {
        if (this.u != null) {
            this.u.cancel();
            this.u = null;
        }
        if (this.w != null) {
            this.w.a();
            this.w.cancel();
            this.w = null;
        }
    }

    private void m() {
        if (this.k != null) {
            this.k.clear();
        }
        if (this.l != null) {
            this.l.c();
        }
        if (this.p != null) {
            this.p.clear();
        }
        if (this.t != null) {
            this.t.a();
        }
        if (this.I != null) {
            this.I.a();
        }
        if (this.a != null) {
            this.a.a();
        }
        if (this.r != null) {
            this.r.a();
        }
        if (this.i != null) {
            this.i.a();
        }
        if (this.q != null) {
            this.q.a();
        }
        this.m = 0;
    }

    private void n() {
        int o = o();
        if (o > 0) {
            this.o.a = this.A.getTrackParameter(true);
            this.l.a(this.o, true);
            g(o);
        }
    }

    private int o() {
        return this.k.size() + this.D;
    }

    private void p() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        k kVar = new k(instance);
        this.q = new Q();
        this.l = new C0466z(4, System.currentTimeMillis() / 1000, kVar.b());
        this.m = 0;
        this.v = 0;
        cn.com.smartdevices.bracelet.gps.c.c.b(this.z);
        cn.com.smartdevices.bracelet.gps.c.c.e(this.z);
        this.o = new ay(this.l.G());
        h(1);
        i(1);
    }

    private void q() {
        if (this.t != null) {
            this.A.statusEstimation(this.t.b(), this.n);
        }
    }

    private void r() {
        i();
    }

    private void s() {
        l();
        this.u = new Timer();
        this.w = new C0461u();
        this.u.schedule(this.w, 0, 1000);
    }

    private void t() {
        int o = o();
        if (o > 0) {
            this.l.a((c) this.k.get(o - 1));
        }
    }

    public a a() {
        return this.r;
    }

    az a(long j) {
        return this.l == null ? null : this.l.A();
    }

    public void a(int i) {
        Message obtainMessage = this.i.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.arg1 = i;
        this.i.sendMessage(obtainMessage);
    }

    public void a(int i, int i2) {
        this.l.b(i, i2);
        if (cn.com.smartdevices.bracelet.gps.model.e.a(this.m)) {
            this.y.a(this.l.A());
        }
    }

    public void a(int i, long j, float f) {
        this.l.a(i, j, f);
        if (cn.com.smartdevices.bracelet.gps.model.e.a(this.m)) {
            this.y.a(this.l.A());
        }
        if (this.I != null && TextUtils.isEmpty(this.l.O())) {
            this.l.b(this.I.b());
        }
    }

    void a(c cVar) {
        int o = o();
        cVar.c(o);
        if (cVar.d() == this.q.d()) {
            cVar.a(this.q.c());
        }
        this.k.put(cVar.d(), cVar);
        if (o == 0) {
            d(cVar);
        }
    }

    void a(C0442t c0442t) {
        if (c0442t != null) {
            this.g = c0442t;
        }
    }

    void a(boolean z) {
        this.x = z;
        d(this.x);
    }

    void b() {
        if (!cn.com.smartdevices.bracelet.gps.model.e.a(this.m)) {
            m();
            if (this.F != null) {
                this.F.a();
            }
        }
    }

    void b(int i) {
        if (i == 0) {
            this.r.b();
        } else if (i == 1) {
            this.r.c();
        }
    }

    public void b(int i, int i2) {
        this.f = i;
        this.l.f(i);
        this.y.a(i, i2);
        c(i);
        e(i);
    }

    void b(c cVar) {
        a(cVar);
        cVar.b(1);
        c(cVar);
    }

    void b(boolean z) {
        this.B.a();
        if (h(2)) {
            j(2);
        } else {
            e.a("Lost", "pauseSportInternal !isUpdatedFromDiffState PAUSED");
        }
        c e = e(z);
        if (e != null) {
            List arrayList = new ArrayList(1);
            arrayList.add(e);
            this.y.a(arrayList, new g(true));
            f(e);
        }
        if (z) {
            i(0);
        }
    }

    c c() {
        int o = o();
        return o > 0 ? (c) this.k.get(o - 1) : null;
    }

    void c(c cVar) {
        if (cVar != null) {
            int receivePoint = this.A.receivePoint(cVar, GaoceptUtils.IS_DEBUG, this.h);
            if (receivePoint == 1) {
                e(cVar);
            } else if (this.h.size() > 0) {
                a(this.h, cVar, receivePoint == 4, true);
            }
            this.h.clear();
        }
    }

    void c(boolean z) {
        h(3);
        this.A.resumeRunning();
        this.B.start();
        if (z) {
            i(1);
        }
    }

    int d() {
        return this.m;
    }

    void d(c cVar) {
        this.l.c(cVar);
        this.l.a(this.z, null);
    }

    long e() {
        return this.v;
    }

    long f() {
        return this.l == null ? -1 : this.l.G();
    }

    int g() {
        return this.n;
    }

    boolean h() {
        return d() == 4 || this.l.C() <= 0.0f;
    }

    void i() {
        this.j = p.f(this.z);
        if (this.j != null) {
            int q = this.j.q();
            if (!HeartRateInfo.isHRValueValid(q)) {
                q = Integer.MAX_VALUE;
            }
            this.b = q;
            this.c = this.j.p();
            this.H = this.j.l();
            if (this.j.j() && this.t == null) {
                this.t = new A(this.z, this);
            } else if (!(this.j.j() || this.t == null)) {
                this.t.a();
                this.t = null;
            }
            this.s = System.currentTimeMillis();
            e.a("RService", "Config isAPaused:" + this.j.j() + ",isPaceEnabled:" + this.H);
        }
    }

    void j() {
        this.B.start();
    }

    void k() {
        if (cn.com.smartdevices.bracelet.gps.e.a.g() && HeartRateInfo.isHRValueValid(this.l.g())) {
            C0401a.a(this.z, C0401a.hl, cn.com.smartdevices.bracelet.gps.c.c.c(this.z));
            C0401a.a(this.z, C0401a.hm, cn.com.smartdevices.bracelet.gps.c.c.f(this.z));
            cn.com.smartdevices.bracelet.gps.c.c.b(this.z);
            cn.com.smartdevices.bracelet.gps.c.c.e(this.z);
        }
        t();
        this.l.S();
        h(4);
        i(0);
        Message obtainMessage = this.F.obtainMessage(2);
        if (this.l.C() >= this.C) {
            if (this.j != null && this.j.m()) {
                C0401a.a(this.z, C0401a.hj);
            }
            a(this.z, this.L);
            j(4);
            obtainMessage.arg1 = 1;
            if (HeartRateInfo.isHRValueValid(this.l.g())) {
                C0401a.a(this.z, C0401a.hk);
            }
        }
        if (!(this.J == null || this.K == null)) {
            this.K.a(this.J);
        }
        this.F.sendMessage(obtainMessage);
        this.A.FreeAllMemory();
    }
}
