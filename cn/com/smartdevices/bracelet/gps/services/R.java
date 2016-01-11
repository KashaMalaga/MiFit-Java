package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.b;
import cn.com.smartdevices.bracelet.shoes.model.g;
import cn.com.smartdevices.bracelet.shoes.sync.C0639p;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.m;
import com.xiaomi.mistatistic.sdk.d;
import java.util.ArrayList;
import java.util.List;

class R extends StepProvider {
    private static final int f = 60000;
    private static final int i = 5000;
    private static final String p = "SStep";
    private aj g;
    private C0639p h;
    private String j;
    private W k;
    private boolean l;
    private V m;
    private U n;
    private int o;
    private boolean q;

    public R(Context context) {
        int i = 0;
        super(context);
        this.g = new ai(this);
        this.h = null;
        this.j = a.f;
        this.k = null;
        this.l = false;
        this.m = null;
        this.n = null;
        this.o = -1;
        this.q = true;
        this.h = new C0639p(this.d, false, false);
        this.k = new W();
        this.j = this.h.d();
        this.m = new V();
        this.n = new U();
        if (!this.h.e()) {
            i = -1;
        }
        this.o = i;
        if (this.o == 0) {
            this.q = this.h.f();
        }
        C0596r.d(p, "ShoesStepMonitor init mHwStatus = " + this.o + ",mRtffstepNotSupported:" + this.q);
    }

    private void c(int i, long j) {
        this.g.a(i, j, this.c.a(this.o));
    }

    private List<al> h() {
        List<al> arrayList = new ArrayList(2);
        al alVar = new al(this, "[RTStep]");
        alVar.c = 5000;
        alVar.a = new S(this);
        arrayList.add(alVar);
        alVar = new al(this, "[MStep]");
        alVar.c = d.g;
        alVar.a = new T(this);
        arrayList.add(alVar);
        return arrayList;
    }

    private void i() {
        if (this.o != -1 || this.c.a()) {
            if (this.q) {
                g a = b.a(this.d);
                if (a == null) {
                    C0596r.d("SStepM", "notifyMinutesStepChanged stepInfo is empty");
                    return;
                } else {
                    C0596r.d("SStepM", "notifyMinutesStepChanged stepInfo = " + a.toString());
                    this.c.b(a.c, a.a);
                }
            }
            int e = this.c.e();
            int c = this.c.c();
            C0596r.d("SStepM", "notifyMinutesStepChanged totalSteps = " + e + ",totalForefootSteps = " + c + ",mIsRtffstepNotSupported:" + this.q);
            this.g.a(c, e);
            return;
        }
        C0596r.d("SStepM", "NotifyMinutesRunnable HwStatus = " + this.o + ",isMinutesInited:" + this.c.a());
    }

    private void j() {
        c(g(), this.c.g());
    }

    protected void a(int i, int i2) {
        super.c(i, i2);
    }

    protected void a(int i, long j) {
        super.b(i, j);
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            this.g = ajVar;
        }
    }

    protected void a(HwConnStatus hwConnStatus) {
        if (hwConnStatus.b().d()) {
            this.o = hwConnStatus.k() ? 0 : -1;
            if (this.o == 0) {
                this.q = this.h.f();
            }
            C0596r.d(p, "notifyHwStatus mHwStatus = " + this.o + ",status = " + hwConnStatus + ",enableRT ?= " + this.e + ",mIsRtffstepNotSupported:" + this.q);
            if (hwConnStatus.k()) {
                a(this.e);
                return;
            }
            return;
        }
        C0596r.e(p, "status type is not sheos family, type = " + hwConnStatus.b());
    }

    protected void a(String str) {
        this.j = str;
    }

    protected void a(boolean z) {
        if (this.h != null) {
            if (z) {
                this.h.b(this.k);
            } else {
                this.h.a(this.k);
            }
        }
    }

    public boolean a() {
        if (!super.a()) {
            return false;
        }
        if (this.h != null) {
            if (this.k != null) {
                this.h.a(this.k);
            }
            this.h.a();
        }
        return true;
    }

    public String b() {
        return !TextUtils.isEmpty(this.j) ? this.j : this.l ? this.j : a.f;
    }

    protected boolean b(int i, int i2) {
        C0596r.e(p, "updateStepFromProvider ffSteps:" + i + ",totalSteps:" + i2);
        if (!super.d(i, i2)) {
            return false;
        }
        if (this.l) {
            return true;
        }
        j();
        this.l = true;
        return true;
    }

    public boolean c() {
        return true;
    }

    protected boolean d() {
        if (this.h == null || this.o == -1) {
            return false;
        }
        m b = this.h.b();
        if (b == null) {
            return false;
        }
        b(b.e(), b.d());
        return true;
    }

    protected List<al> e() {
        return h();
    }

    public ap stop() {
        if (c()) {
            if (this.h != null) {
                this.h.h();
            }
            return super.stop();
        }
        C0596r.d(p, "RtStep.NO_BINDED_DEVICES");
        return null;
    }
}
