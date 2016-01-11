package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.model.b;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.model.r;
import com.xiaomi.hm.health.bt.profile.a.j;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kankan.wheel.widget.a;

public class A extends C implements B {
    private boolean A = false;
    private volatile boolean B = false;
    public final byte a = (byte) 0;
    public final byte b = (byte) 1;
    boolean c = false;
    boolean d = false;
    int e = -1;
    int f = -1;
    int g = -1;
    int h = 0;
    int i = 0;
    Calendar j = null;
    private final int r = a.bT;
    private final int s = com.f.a.b.d.a.a;
    private final int t = 1;
    private Timer u = null;
    private TimerTask v = null;
    private int w = -1;
    private PipedInputStream x = null;
    private PipedOutputStream y = null;
    private final r z = new r();

    public A(d dVar) {
        super(dVar);
    }

    public A(j jVar, d dVar) {
        super(jVar, dVar);
    }

    private void a(int i) {
        this.u = new Timer();
        this.v = new B(this);
        this.u.schedule(this.v, (long) i);
    }

    private void a(int i, int i2, Calendar calendar) {
        int i3 = 4;
        this.d = true;
        this.h = i;
        this.i = 0;
        this.j = calendar;
        C0596r.d("xxx", "currentDataLen: " + this.i + ",currentDataTotalLen:" + this.h);
        C0596r.d("xxx", "timestamp: " + this.j.getTime().toString());
        C0596r.d("xxx", "totalLen: " + (i2 / (this.A ? 4 : 3)) + " minute(s)");
        String str = "xxx";
        StringBuilder append = new StringBuilder().append("current: ");
        int i4 = this.h;
        if (!this.A) {
            i3 = 3;
        }
        C0596r.d(str, append.append(i4 / i3).append(" minute(s)").toString());
    }

    private boolean b(int i) {
        if (this.d) {
            this.i += i;
            C0596r.d("xxx", "currentDataLen: " + this.i + ",currentDataTotalLen:" + this.h);
            if (i == 20 || this.i == this.h) {
                return true;
            }
            C0596r.d("xxx", "package lenght != 20 and current currentDataLen != currentDataTotalLen!!!");
            C0401a.c(C0401a.eq);
            d();
            return false;
        }
        C0596r.d("xxx", "get data before get head!!!");
        C0401a.c(C0401a.ep);
        d();
        return false;
    }

    private void i() {
        if (this.u != null) {
            this.u.cancel();
            this.u.purge();
            this.u = null;
        }
        if (this.v != null) {
            this.v.cancel();
            this.v = null;
        }
    }

    private void j() {
        C0596r.d(p, "stopGetActivities");
        this.q.z();
        try {
            if (this.x != null) {
                this.x.close();
                this.x = null;
            }
            if (this.y != null) {
                this.y.close();
                this.y = null;
            }
        } catch (Exception e) {
        }
    }

    private b k() {
        int i;
        int i2 = 4;
        C0596r.e();
        byte read = (byte) this.x.read();
        Calendar gregorianCalendar = new GregorianCalendar(this.x.read() + a.bZ, this.x.read(), this.x.read(), this.x.read(), this.x.read(), this.x.read());
        C0596r.a("timestamp: " + DateFormat.getDateTimeInstance().format(gregorianCalendar.getTime()));
        int read2 = ((this.x.read() & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (this.x.read() & HeartRateInfo.HR_EMPTY_VALUE);
        C0596r.a("totalLen: " + read2 + " minute(s)");
        if (read == (byte) 1) {
            i = (this.A ? 4 : 3) * read2;
        } else {
            i = read2;
        }
        this.z.a = i;
        i = (this.x.read() & HeartRateInfo.HR_EMPTY_VALUE) | ((this.x.read() & HeartRateInfo.HR_EMPTY_VALUE) << 8);
        C0596r.a("len: " + i + " minute(s)");
        if (read == (byte) 1) {
            if (!this.A) {
                i2 = 3;
            }
            i *= i2;
        }
        List arrayList = new ArrayList(i / 3);
        while (i > 0) {
            byte read3 = (byte) this.x.read();
            byte read4 = (byte) this.x.read();
            byte read5 = (byte) this.x.read();
            r rVar;
            if (this.A) {
                arrayList.add(new com.xiaomi.hm.health.bt.model.a(read4, read5, read3, (byte) this.x.read()));
                i -= 4;
                rVar = this.z;
                rVar.b += 4;
            } else {
                arrayList.add(new com.xiaomi.hm.health.bt.model.a(read4, read5, read3));
                i -= 3;
                rVar = this.z;
                rVar.b += 3;
            }
            a(this.z);
        }
        return new b(gregorianCalendar, arrayList);
    }

    public void a() {
        C0596r.d(p, "getActivities onStart");
    }

    public void a(d dVar) {
        C0596r.d(p, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        C0596r.d(p, "===========================start sync data================================");
        C0596r.d(p, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        if (dVar != null) {
            dVar.a();
        }
        if (this.q != null) {
            h B = this.q.B();
            if (B != null) {
                this.A = B.a();
                Object obj = null;
                int i = 0;
                while (i <= 1) {
                    this.B = false;
                    obj = e();
                    if (!this.B) {
                        break;
                    }
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
                if (r0 == null) {
                    C0596r.d(p, "getActivities return null, now finish!");
                }
                if (dVar != null) {
                    dVar.a((Object) r0);
                }
                if (r0 != null && r0.size() > 0) {
                    for (b bVar : r0) {
                        if (bVar.b != null) {
                            i = (this.A ? 4 : 3) * bVar.b.size();
                        } else {
                            i = 0;
                        }
                        this.q.a(bVar.a, i);
                    }
                }
                C0596r.d(p, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                C0596r.d(p, "============================stop sync data================================");
                C0596r.d(p, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                return;
            }
        }
        C0596r.d(p, "Can not obtain GattPeripheral or deviceinfo. BleSyncDataTask task stopped");
    }

    public void a(r rVar) {
        C0596r.e(p, "getActivities onProgress:" + rVar);
        int i = (rVar.b * 100) / rVar.a;
        if (i != this.w) {
            this.o.a(i);
            this.w = i;
        }
    }

    public void a(String str) {
        C0596r.d(p, "getActivities onError:" + str);
    }

    public synchronized void a(boolean z) {
        C0596r.d(p, "getActivities onBleNotify:" + z);
        i();
        if (!z) {
            a((int) com.f.a.b.d.a.a);
        }
    }

    public void a(byte[] bArr) {
        try {
            boolean z;
            boolean z2;
            if (bArr.length == 11) {
                int i;
                byte b = bArr[0];
                int i2 = bArr[1] + a.bZ;
                byte b2 = bArr[2];
                byte b3 = bArr[3];
                byte b4 = bArr[4];
                byte b5 = bArr[5];
                byte b6 = bArr[6];
                int i3 = (bArr[7] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[8] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
                int i4 = (bArr[9] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[10] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
                if (b == (byte) 1) {
                    i = (this.A ? 4 : 3) * i3;
                    i4 = (this.A ? 4 : 3) * i4;
                } else {
                    i = i3;
                }
                Calendar gregorianCalendar = new GregorianCalendar(i2, b2, b3, b4, b5, b6);
                if (!this.c) {
                    this.c = true;
                    this.e = b;
                    this.f = i;
                    this.g = i2;
                    z = i4 == 0;
                    a(i4, i, gregorianCalendar);
                    z2 = true;
                } else if (b != this.e || i != this.f) {
                    z2 = b(bArr.length);
                    z = false;
                } else if (this.i == this.h) {
                    z = i4 == 0;
                    a(i4, i, gregorianCalendar);
                    z2 = true;
                } else {
                    C0596r.d("xxx", "get data not complete but head coming!!!");
                    C0401a.c(C0401a.er);
                    d();
                    z2 = false;
                    z = false;
                }
            } else {
                z2 = b(bArr.length);
                z = false;
            }
            C0596r.d(p, y.b(bArr));
            if (z2) {
                this.y.write(bArr);
                a(z);
                return;
            }
            a(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b() {
        C0596r.d(p, "getActivities onStop");
        i();
        this.o.a(100);
    }

    public synchronized void c() {
        C0596r.d(p, "getActivities onCommand");
        i();
        a((int) a.bT);
    }

    public synchronized void d() {
        C0596r.d(p, "getActivities onMissData");
        this.B = true;
        i();
        j();
    }

    public List<b> e() {
        C0596r.d(p, "getActivities");
        a();
        List<b> arrayList = new ArrayList();
        try {
            this.x = new PipedInputStream();
            this.y = new PipedOutputStream();
            this.x.connect(this.y);
            this.q.a((B) this);
            boolean U = this.q.U();
            C0596r.a(U);
            if (U) {
                c();
                this.z.a = -1;
                this.z.b = 0;
                b k;
                do {
                    try {
                        k = k();
                        arrayList.add(k);
                    } catch (Exception e) {
                        a(e.getMessage());
                    }
                } while (k.b.size() != 0);
                b();
                this.q.V();
                try {
                    if (this.x != null) {
                        this.x.close();
                        this.x = null;
                    }
                    if (this.y != null) {
                        this.y.close();
                        this.y = null;
                    }
                } catch (Exception e2) {
                }
                return arrayList;
            }
            a("Write sync command failed!!!");
            b();
            this.q.V();
            return null;
        } catch (IOException e3) {
            a(e3.getMessage());
            b();
            e3.printStackTrace();
            return null;
        }
    }
}
