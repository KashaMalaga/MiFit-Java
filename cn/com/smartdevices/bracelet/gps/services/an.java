package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.GroundOverlayOptions;

class an {
    public static final int a = 4;
    private static final int b = -1;
    private static final int q = 300;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private int f = 0;
    private int g = b;
    private int h = 0;
    private int i = 0;
    private long j = 0;
    private int k = 0;
    private int l = 0;
    private int m = b;
    private int n = 0;
    private int o = 0;
    private int p = b;
    private final byte[] r = new byte[0];
    private int s = 0;
    private int t = 0;
    private ao[] u = null;

    public an(int i) {
        int i2 = 0;
        if (i <= 0) {
            i = a;
        }
        this.s = i;
        this.u = new ao[this.s];
        while (i2 < this.s) {
            this.u[i2] = new ao(this);
            i2++;
        }
    }

    private float a(long j, long j2) {
        return j2 == 0 ? GroundOverlayOptions.NO_DIMENSION : ((((float) j) * BitmapDescriptorFactory.HUE_YELLOW) * 1000.0f) / ((float) j2);
    }

    private void c(int i) {
        long j = 0;
        int i2 = 0;
        synchronized (this.r) {
            long currentTimeMillis = System.currentTimeMillis();
            int max = Math.max(0, this.g);
            int i3 = this.t % this.s;
            if (this.j != 0) {
                j = Math.max(0, currentTimeMillis - this.j);
            }
            if (this.i != 0) {
                i2 = Math.max(0, max - this.i);
            }
            float a = a((long) i2, j);
            if (a <= GroundOverlayOptions.NO_DIMENSION || a > BitmapDescriptorFactory.HUE_MAGENTA) {
                this.u[i3].e = b;
                C0596r.d("SStepR", "may disconnected or too fast. time = " + j + ",steps = " + i2 + ",frequency = " + a);
            } else {
                this.u[i3].e = i;
            }
            this.u[i3].d = j;
            this.u[i3].c = i2;
            C0596r.d("SStepR", "spanTime = " + j + ",steps = " + i2 + ",frequency = " + a + ",status = " + this.u[i3].e + ",inputStatus: " + i);
            this.t++;
            this.j = currentTimeMillis;
            this.i = max;
        }
    }

    private void d(int i) {
        C0596r.d("SStepR", "RR mRtStepOfCurSection = " + this.g + ",mRtStartStepOfCurSection = " + this.h + ",realtimeSteps = " + i + ",mRtTimeSpanOfCurSection = " + this.d + ",time = " + System.currentTimeMillis());
    }

    private void d(int i, int i2) {
        C0596r.d("SStepM", "MM mMinutesStepOfCurSection = " + this.m + ",mMinutesStartStepOfCurSection = " + this.l + ",mForefootStepOfCurSection = " + this.p + ",mForefootStartStepOfCurSection = " + this.o + ",totalSteps = " + i2 + ",forefootSteps = " + i + ",time = " + System.currentTimeMillis());
    }

    private long[] i() {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < this.s; i2++) {
            C0596r.d("SStepR", "Index = " + i2 + ",steps = " + this.u[i2].c + ",time = " + this.u[i2].d + ",status = " + this.u[i2].e);
            if (this.u[i2].e != b) {
                j += this.u[i2].d;
                i += this.u[i2].c;
            }
        }
        return new long[]{(long) i, j};
    }

    private void j() {
        synchronized (this.r) {
            this.f += Math.max(0, this.g);
            this.c += this.d;
        }
        this.k += Math.max(0, this.m);
        this.n += Math.max(0, this.p);
    }

    private void k() {
        j();
        m();
    }

    private void l() {
        for (int i = 0; i < this.s; i++) {
            this.u[i].a();
        }
        this.t = 0;
    }

    private void m() {
        synchronized (this.r) {
            this.g = b;
            this.h = 0;
            this.i = 0;
            this.d = 0;
            this.e = 0;
            l();
        }
        this.m = b;
        this.l = 0;
        this.p = b;
        this.o = 0;
    }

    public float a(int i) {
        c(i);
        long[] i2 = i();
        long j = i2[1];
        long j2 = i2[0];
        if (j == 0) {
            return GroundOverlayOptions.NO_DIMENSION;
        }
        float a = a(j2, j);
        C0596r.d("SStepR", "calculateFreq spanMilisecondTime = " + j + ",steps = " + j2 + ",rtStepFreq = " + a + ",hwStatus = " + i);
        return a <= BitmapDescriptorFactory.HUE_MAGENTA ? a : BitmapDescriptorFactory.HUE_MAGENTA;
    }

    public void a(int i, int i2) {
        this.n = Math.max(0, i);
        this.k = Math.max(0, i2);
    }

    public void a(int i, long j) {
        this.f = Math.max(0, i);
        this.c = Math.max(0, 1000 * j);
    }

    public boolean a() {
        return this.l <= 0;
    }

    public void b(int i, int i2) {
        if (i2 >= 0 && i >= 0) {
            if (i2 < this.l || i < this.o) {
                C0596r.d("SStep", "Attension: totalSteps:" + i2 + ",mMinutesStartStepOfCurSection:" + this.l + ",forefootSteps:" + i + ",mStartForefootStepsInMinutesOfCurSection:" + this.o);
                k();
            }
            if (this.l <= 0) {
                this.o = i;
                this.l = i2;
            } else {
                this.m = Math.max(0, i2 - this.l);
                this.p = Math.max(0, i - this.o);
            }
            d(i, i2);
        }
    }

    public boolean b() {
        return this.h <= 0;
    }

    public boolean b(int i) {
        boolean z = false;
        if (i >= 0) {
            if (i < this.h) {
                C0596r.d("SStep", "Attension: totalSteps = " + i + ",mRtStartStepOfCurSection = " + this.h + ",time = " + System.currentTimeMillis());
                k();
            }
            synchronized (this.r) {
                if (this.h <= 0) {
                    this.h = i;
                    this.e = System.currentTimeMillis();
                } else {
                    this.g = Math.max(0, i - this.h);
                    this.d = System.currentTimeMillis() - this.e;
                    z = true;
                }
            }
            d(i);
        }
        return z;
    }

    int c() {
        return this.n <= 0 ? this.p : this.n + Math.max(0, this.p);
    }

    public boolean c(int i, int i2) {
        b(i, i2);
        return b(i2);
    }

    int[] d() {
        return new int[]{c(), e()};
    }

    int e() {
        return this.k <= 0 ? this.m : this.k + Math.max(0, this.m);
    }

    long[] f() {
        return new long[]{(long) h(), g()};
    }

    long g() {
        return (this.c + this.d) / 1000;
    }

    int h() {
        return this.f <= 0 ? this.g : this.f + Math.max(0, this.g);
    }

    public void start() {
        k();
    }

    protected ap stop() {
        j();
        ap apVar = new ap();
        apVar.a = h();
        apVar.b = g();
        apVar.c = e();
        apVar.d = c();
        m();
        return apVar;
    }
}
