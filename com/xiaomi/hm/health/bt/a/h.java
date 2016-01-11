package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import kankan.wheel.widget.a;

public class h extends C implements b {
    private b c = null;
    private String d = null;
    private byte[] e = null;
    private int f = 0;

    public h(j jVar, String str, byte[] bArr, b bVar) {
        super(jVar, null);
        this.d = str;
        this.c = bVar;
        this.e = bArr;
    }

    public h(String str, byte[] bArr, b bVar) {
        super(null);
        this.d = str;
        this.c = bVar;
        this.e = bArr;
    }

    private boolean a(byte[] bArr, int i, int i2, int i3, int i4, boolean z, b bVar) {
        boolean a;
        if (i4 == -1) {
            a = this.q.a(i, i2, bArr.length, i3);
        } else if (i4 == -2) {
            a = this.q.b(i, i2, bArr.length, i3, 0);
        } else {
            a = this.q.b(i, i2, bArr.length, i3, i4);
        }
        if (!a) {
            C0596r.e(p, "prepareFirmwareUpdate failed!");
            return false;
        } else if (this.q.a(bArr, bVar)) {
            if (z) {
                C0596r.e(p, "need reboot!!!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                if (this.q.R()) {
                    C0596r.e(p, "reboot success!!!");
                    this.q.c();
                } else {
                    C0596r.e(p, "reboot failed!!!");
                    return false;
                }
            }
            return true;
        } else {
            C0596r.e(p, "sendFirmwareData failed!");
            return false;
        }
    }

    public void a(d dVar) {
        Thread.currentThread().setPriority(10);
        this.c.onStart(0);
        if (this.e == null || this.e.length < 1) {
            this.c.onStop(1);
            return;
        }
        String[] split = this.d.split(a.ci);
        int byteValue = ((Integer.decode("0x" + split[4]).byteValue() & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (Integer.decode("0x" + split[5]).byteValue() & HeartRateInfo.HR_EMPTY_VALUE);
        com.xiaomi.hm.health.bt.model.h j_ = this.q.j_();
        if (j_ == null) {
            this.c.onStop(1);
            return;
        }
        boolean z = false;
        int d;
        int i;
        if (j_.a()) {
            d = com.xiaomi.hm.health.bt.profile.a.d(this.e);
            int e = com.xiaomi.hm.health.bt.profile.a.e(this.e);
            i = j_.f;
            int i2 = j_.g;
            C0596r.e(p, "old firmware version:" + i + ", " + i2 + "  new firmware version:" + d + ", " + e);
            int i3 = com.xiaomi.hm.health.bt.profile.a.i(this.e);
            int j = com.xiaomi.hm.health.bt.profile.a.j(this.e);
            int f = com.xiaomi.hm.health.bt.profile.a.f(this.e);
            int g = com.xiaomi.hm.health.bt.profile.a.g(this.e);
            byte[] bArr = new byte[j];
            System.arraycopy(this.e, i3, bArr, 0, j);
            int c = y.c(bArr) ^ byteValue;
            byte[] bArr2 = new byte[g];
            System.arraycopy(this.e, f, bArr2, 0, g);
            byteValue ^= y.c(bArr2);
            C0596r.e(p, "size1:" + g + ",size2:" + j + ",data1 len:" + bArr2.length + ",data2 len:" + bArr.length);
            C0596r.e(p, "newVersion2:" + e + ",oldVersion2:" + i2 + ",newVersion1:" + d + ",oldVersion1:" + i);
            boolean k = com.xiaomi.hm.health.bt.profile.a.k(this.e);
            boolean h = com.xiaomi.hm.health.bt.profile.a.h(this.e);
            C0596r.e(p, "getFw2Valid:" + k);
            C0596r.e(p, "getFw1Valid:" + h);
            boolean c2 = com.xiaomi.hm.health.bt.profile.a.c(this.e);
            C0596r.e(p, "seq:" + c2);
            if (e <= i2 || d <= i) {
                if (e > i2 && k) {
                    this.c.setMax(j);
                    z = a(bArr, i2, e, c, 1, true, this);
                } else if (d > i && h) {
                    this.c.setMax(g);
                    z = a(bArr2, i, d, byteValue, 0, true, this);
                }
            } else if (c2) {
                this.c.setMax(g);
                z = a(bArr2, i, d, byteValue, 0, true, this);
            } else {
                this.c.setMax(g + j);
                if (k) {
                    z = a(bArr, i2, e, c, 1, false, this);
                }
                if (z && h) {
                    this.f = j;
                    z = a(bArr2, i, d, byteValue, 0, true, this);
                }
            }
        } else {
            i = this.q.j_().f;
            d = com.xiaomi.hm.health.bt.profile.a.a(this.e);
            byteValue ^= y.c(this.e);
            C0596r.e(p, "old firmware version:" + i + "  new firmware version:" + d);
            this.c.setMax(this.e.length);
            z = a(this.e, i, d, byteValue, j_.b() ? -2 : -1, true, this);
        }
        this.c.onStop(z ? 0 : 1);
    }

    public void onStart(int i) {
    }

    public void onStop(int i) {
    }

    public void report(int i) {
        C0596r.e(p, "mBaseProgress:" + this.f + ",progress:" + i);
        this.c.report(this.f + i);
    }

    public void setMax(int i) {
        C0596r.e(p, "max:" + i);
    }
}
