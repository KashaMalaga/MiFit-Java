package com.xiaomi.hm.health.bt.profile.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.e.a.a;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.c.z;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.mistatistic.sdk.d;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class k extends b implements B {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    private static final String g = "RunningSensorDataTask";
    private final int h = b;
    private final int i = c;
    private final int j = d;
    private final int k = e;
    private f l = null;
    private f m = null;
    private boolean n = false;
    private PipedInputStream o = null;
    private PipedOutputStream p = null;
    private Handler q = null;
    private int r = -1;

    public k(f fVar, f fVar2) {
        this.l = fVar;
        this.m = fVar2;
        HandlerThread handlerThread = new HandlerThread(g);
        handlerThread.start();
        this.q = new l(this, handlerThread.getLooper());
    }

    private void a(int i) {
        Message message = new Message();
        message.what = e;
        message.arg1 = i;
        this.q.sendMessage(message);
    }

    private void a(f fVar) {
        while (this.n) {
            try {
                int read = this.o.read();
                int read2 = this.o.read();
                int read3 = this.o.read();
                int read4 = this.o.read();
                read |= read2 << 8;
                short s = (short) (((read & 4095) << 20) >> 20);
                short s2 = (short) (((((read4 << 8) | read3) & 4095) << 20) >> 20);
                short read5 = (short) (((((this.o.read() << 8) | this.o.read()) & 4095) << 20) >> 20);
                if (this.n && fVar != null) {
                    fVar.a(s, s2, read5);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void f() {
    }

    private boolean g() {
        this.r = -1;
        if (this.l == null || !this.l.u()) {
            C0596r.d(g, "mProfile is null!!!");
            a((int) c);
            return false;
        }
        this.o = new PipedInputStream();
        this.p = new PipedOutputStream();
        try {
            this.p.connect(this.o);
            if (this.l.a((B) this) && this.l.b(true)) {
                this.n = true;
                this.q.sendEmptyMessageDelayed(d, d.g);
                a((int) b);
                return true;
            }
            C0596r.d(g, "enable sensor data failed!!!");
            a((int) c);
            return false;
        } catch (IOException e) {
            C0596r.d(g, "m_SensorSourceOutputStream connect m_SensorSourceInputStream failed!!!");
            a((int) c);
            return false;
        }
    }

    private void h() {
        this.n = false;
        this.q.removeMessages(d);
        if (this.l != null) {
            this.l.b(false);
            this.l.B();
        }
        try {
            if (this.o != null) {
                this.o.close();
            }
            if (this.p != null) {
                this.p.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        a((int) d);
    }

    public void a(byte[] bArr) {
        C0596r.e(g, y.b(bArr));
        try {
            int i = (bArr[b] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[c] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
            C0596r.e(g, "index:" + i + ",mLastSensorDataIndex:" + this.r);
            if (i == a.a) {
                C0596r.d(g, "sensor data notify packages index is -1 !!!");
                a((int) f);
                throw new RuntimeException("sensor data notify packages index is -1 !!!");
            }
            if (!((this.r == z.j && i == 0) || this.r + c == i)) {
                C0596r.d(g, "sensor data notify packages index is not continuous!!!");
            }
            this.r = i;
            Object obj = new byte[(bArr.length - 2)];
            System.arraycopy(bArr, d, obj, b, bArr.length - 2);
            this.p.write(obj);
        } catch (IOException e) {
            C0596r.d(g, e.getMessage());
        }
    }

    protected void d() {
        if (g()) {
            a(this.m);
        }
    }

    public void e() {
        this.m = null;
    }

    public void stop() {
        this.q.sendEmptyMessage(c);
    }
}
