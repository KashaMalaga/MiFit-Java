package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.a.c;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import java.util.ArrayList;
import java.util.List;

class ad extends StepProvider {
    private static final int h = 5000;
    private static final String m = "BStep";
    private ag f;
    private final d g;
    private aj i;
    private final ah j;
    private boolean k;
    private int l;
    private boolean n;
    private String o;

    public ad(Context context) {
        int i = 0;
        super(context);
        this.f = null;
        this.g = new ae(this);
        this.i = new ai(this);
        this.j = new ah();
        this.k = false;
        this.l = -1;
        this.n = true;
        this.o = a.f;
        this.f = new ag();
        if (cn.com.smartdevices.bracelet.gps.e.a.h() && !cn.com.smartdevices.bracelet.gps.e.a.f()) {
            this.n = false;
        }
        if (com.xiaomi.hm.health.bt.bleservice.a.a() != null) {
            if (this.n && !com.xiaomi.hm.health.bt.bleservice.a.a().u()) {
                i = -1;
            }
            this.l = i;
        } else {
            if (this.n) {
                i = -1;
            }
            this.l = i;
        }
        C0596r.d(m, "StepMonitor init mHwStatus = " + this.l + ",mIsHwStatusSupported = " + this.n);
    }

    private boolean b(boolean z) {
        if (!h()) {
            return false;
        }
        boolean a = cn.com.smartdevices.bracelet.gps.e.a.a(z, this.j);
        if (!a) {
            return a;
        }
        c.a(this.d);
        return a;
    }

    private boolean h() {
        if (!this.n) {
            return true;
        }
        if (com.xiaomi.hm.health.bt.bleservice.a.a() != null && com.xiaomi.hm.health.bt.bleservice.a.a().u()) {
            return true;
        }
        C0596r.d(m, "checkDeviceConnected profile or status problem");
        return false;
    }

    private void i() {
        int g = g();
        if (g > 0) {
            this.i.a(g, this.c.g(), this.c.a(this.l));
        }
    }

    protected void a(int i, int i2) {
    }

    protected void a(int i, long j) {
        super.b(i, j);
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            this.i = ajVar;
        }
    }

    protected void a(HwConnStatus hwConnStatus) {
        if (hwConnStatus.b().c() && this.n) {
            this.l = hwConnStatus.k() ? 0 : -1;
            if (hwConnStatus.k()) {
                a(this.e);
            }
        }
    }

    protected void a(String str) {
        this.o = str;
    }

    protected void a(boolean z) {
        C0596r.e(m, "enableRTMode enable = " + z);
        b(z);
    }

    public boolean a() {
        return super.a();
    }

    protected String b() {
        if (!TextUtils.isEmpty(this.o)) {
            return this.o;
        }
        if (this.k) {
            this.o = com.xiaomi.hm.health.bt.b.c.MILI.b() + kankan.wheel.widget.a.ci + "MILI";
        }
        return this.o;
    }

    protected boolean b(int i, int i2) {
        if (!super.d(i, i2)) {
            return false;
        }
        if (this.k) {
            return true;
        }
        i();
        this.k = true;
        return true;
    }

    public boolean c() {
        return true;
    }

    protected boolean d() {
        if (!h()) {
            return false;
        }
        new H(this.g).g();
        return true;
    }

    protected List<al> e() {
        al alVar = new al(this, "[RTStep]");
        alVar.c = 5000;
        alVar.a = new af(this);
        List<al> arrayList = new ArrayList(1);
        arrayList.add(alVar);
        return arrayList;
    }

    public ap stop() {
        if (c()) {
            return super.stop();
        }
        C0596r.d(m, "RtStep.NO_BINDED_DEVICES");
        return null;
    }
}
