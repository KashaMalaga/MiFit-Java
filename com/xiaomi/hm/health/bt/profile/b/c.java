package com.xiaomi.hm.health.bt.profile.b;

import cn.com.smartdevices.bracelet.C0596r;
import com.f.a.b.d.a;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;

public class c extends b implements B {
    private f b = null;
    private d c = null;
    private byte[] d = null;
    private int e = a.a;

    public c(f fVar, int i, d dVar) {
        this.b = fVar;
        this.c = dVar;
        this.e = i;
    }

    public c(f fVar, d dVar) {
        this.b = fVar;
        this.c = dVar;
    }

    private void a(int i) {
        synchronized (this.c) {
            try {
                this.c.wait((long) i);
            } catch (Exception e) {
            }
        }
    }

    private void b(byte[] bArr) {
        synchronized (this.c) {
            this.b.E();
            this.d = bArr;
            this.c.notify();
        }
    }

    public void a(byte[] bArr) {
        C0596r.d("RunningCalibrateTask", "notify:" + y.b(bArr));
        b(bArr);
    }

    protected void d() {
        boolean z = true;
        if (this.c != null) {
            this.c.c();
            if (this.b == null || !this.b.u()) {
                this.c.c(Boolean.valueOf(false));
                return;
            }
            this.b.b((B) this);
            this.b.c(true);
            a(this.e);
            this.b.c(false);
            if (this.d == null) {
                a((int) kankan.wheel.widget.a.bZ);
            }
            this.b.E();
            boolean z2 = this.d != null && this.d.length == 1;
            if (!z2) {
                z = z2;
            } else if (this.d[0] != (byte) 1) {
                z = false;
            }
            if (this.c != null) {
                this.c.c(Boolean.valueOf(z));
            }
        }
    }

    public void stop() {
        super.stop();
        b(null);
    }
}
