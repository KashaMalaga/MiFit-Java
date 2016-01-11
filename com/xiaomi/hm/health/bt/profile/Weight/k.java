package com.xiaomi.hm.health.bt.profile.Weight;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.profile.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class k implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ long b;
    final /* synthetic */ f c;
    private byte d = (byte) 0;
    private byte e = (byte) 1;
    private byte f = (byte) 2;
    private byte g = (byte) 3;
    private byte h = (byte) 4;
    private boolean i = false;
    private long j = -1;
    private long k = -1;
    private int l = -1;
    private int m = 0;
    private ArrayList<e> n = new ArrayList();
    private int o = 0;

    k(f fVar, d dVar, long j) {
        this.c = fVar;
        this.a = dVar;
        this.b = j;
    }

    private void a(ArrayList<e> arrayList) {
        Object mVar = new m();
        mVar.d = arrayList;
        mVar.a = this.j;
        mVar.b = this.k;
        mVar.c = this.o;
        C0596r.e(f.n, "Result:" + mVar.toString());
        if (this.a != null) {
            this.a.a(mVar);
        }
    }

    private void a(byte[] bArr) {
        int i = 0;
        synchronized (this.c.A) {
            C0596r.e(f.n, "in handleData:" + y.b(bArr));
            if (bArr.length == 1) {
                this.i = true;
            } else if (bArr.length == 3) {
                if (bArr[0] != this.e) {
                    this.i = true;
                } else {
                    this.i = false;
                    this.l = ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (bArr[1] & HeartRateInfo.HR_EMPTY_VALUE);
                }
            } else if (bArr.length == 7) {
                if (bArr[0] != this.e) {
                    this.i = true;
                } else {
                    boolean z;
                    this.l = ((bArr[2] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (bArr[1] & HeartRateInfo.HR_EMPTY_VALUE);
                    r3 = ((((bArr[6] & HeartRateInfo.HR_EMPTY_VALUE) << 24) | ((bArr[5] & HeartRateInfo.HR_EMPTY_VALUE) << 16)) | ((bArr[4] & HeartRateInfo.HR_EMPTY_VALUE) << 8)) | (bArr[3] & HeartRateInfo.HR_EMPTY_VALUE);
                    C0596r.d(f.n, "data size:" + this.l + ",weight uid:" + r3 + ",current uid:" + this.b);
                    if (((long) r3) != this.b) {
                        z = true;
                    }
                    this.i = z;
                }
            } else if (bArr.length == 10 || bArr.length == 20) {
                this.i = false;
                Object obj = new byte[10];
                r3 = bArr.length / 10;
                this.m += r3;
                while (i < r3) {
                    System.arraycopy(bArr, i * 10, obj, 0, 10);
                    e a = a.a(obj, false, true);
                    if (this.c.H != null) {
                        a.a(this.c.H.a);
                    }
                    long e = a.e();
                    if (a.j() == 0.0f) {
                        this.o++;
                        C0596r.d(f.n, "wrong weight data value as reboot:" + a + "<DROP>!!!");
                    } else if (a(e)) {
                        this.n.add(a);
                        if (this.j == -1) {
                            this.j = e;
                        } else if (this.j > e) {
                            this.j = e;
                        }
                        if (this.k == -1) {
                            this.k = e;
                        } else if (this.k < e) {
                            this.k = e;
                        }
                    } else {
                        C0596r.d(f.n, "wrong weight data timestamp:" + new Date(e).toString() + "<DROP>!!!");
                    }
                    i++;
                }
            } else {
                this.i = true;
            }
            this.c.A.notify();
            C0596r.e(f.n, "out handleData");
        }
    }

    private boolean a(byte b, int i) {
        C0596r.e(f.n, "in doCommand:" + b);
        this.i = true;
        if (b > (byte) 0) {
            if (b == this.e || b == this.h) {
                this.c.b(this.c.A, new byte[]{b, (byte) ((int) (this.b & 255)), (byte) ((int) ((this.b >> 8) & 255)), (byte) ((int) ((this.b >> 16) & 255)), (byte) ((int) ((this.b >> 24) & 255))});
            } else {
                this.c.b(this.c.A, new byte[]{b});
            }
        }
        if (!this.i) {
            return true;
        }
        synchronized (this.c.A) {
            if (i > 0) {
                try {
                    this.c.A.wait((long) i);
                } catch (InterruptedException e) {
                    return false;
                }
            }
        }
        C0596r.e(f.n, "out doCommand:" + b);
        return !this.i;
    }

    private boolean a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (instance.get(1) < 2014) {
            C0596r.d(f.n, "year less than 2014!!!");
            return false;
        } else if (j <= Calendar.getInstance().getTimeInMillis() + com.xiaomi.mistatistic.sdk.d.h) {
            return true;
        } else {
            C0596r.d(f.n, "timestamp large than current!!!");
            return false;
        }
    }

    public void run() {
        if (this.a != null) {
            this.a.a();
        }
        if (this.c.A() == 3) {
            C0596r.d(f.n, "sand glass mode is test!!!");
            this.c.B();
        }
        if (this.c.A == null) {
            this.c.A = this.c.t.getCharacteristic(a.B_);
        }
        if (this.c.A == null) {
            C0596r.d(f.n, "m_CharSyncControl is null!!!");
            a(null);
            return;
        }
        this.c.b(this.c.A, new l(this));
        if (!a(this.e, (int) com.f.a.b.d.a.a)) {
            C0596r.d(f.n, "CMD_GET_SIZE failed!!!");
            a(this.g, 0);
            a(null);
        } else if (a(this.f, (int) com.f.a.b.d.a.a)) {
            do {
            } while (a(this.d, (int) com.f.a.b.d.a.a));
            a(this.g, 0);
            if (this.l == this.m) {
                a(this.h, 0);
            } else {
                C0596r.d(f.n, "received weight data size not match the head data size!!!");
            }
            this.c.c(this.c.A);
            if (this.l != this.n.size()) {
                C0596r.d(f.n, "valid weight data size not match the head data size!!!");
                this.l = this.n.size();
            }
            a(this.n);
        } else {
            C0596r.d(f.n, "CMD_START_SYNC failed!!!");
            a(this.g, 0);
            a(null);
        }
    }
}
