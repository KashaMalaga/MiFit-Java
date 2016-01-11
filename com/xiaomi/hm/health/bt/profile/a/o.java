package com.xiaomi.hm.health.bt.profile.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;
import com.xiaomi.hm.health.bt.c.z;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.bt.model.p;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.mistatistic.sdk.d;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import kankan.wheel.widget.a;

public class o implements B {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private final int f = a;
    private final int g = b;
    private final int h = c;
    private final int i = d;
    private final String j = "MiLiSensorData";
    private int k = -1;
    private PipedInputStream l = null;
    private PipedOutputStream m = null;
    private boolean n = false;
    private j o = null;
    private BluetoothGattCharacteristic p = null;
    private f q = null;
    private Handler r = null;

    public o(j jVar) {
        this.o = jVar;
        HandlerThread handlerThread = new HandlerThread("MiLiSensorData");
        handlerThread.start();
        this.r = new p(this, handlerThread.getLooper());
    }

    private void a() {
        this.k = -1;
        if (this.o == null || !this.o.u()) {
            C0596r.d("MiLiSensorData", "mProfile is null!!!");
            a((int) b);
            return;
        }
        BluetoothGattService a = this.o.a(a.h_);
        if (a == null) {
            C0596r.d("MiLiSensorData", "get UUID_SERVICE_MILI_SERVICE return null!!!");
            a((int) b);
            return;
        }
        this.p = a.getCharacteristic(a.r);
        if (this.p == null) {
            C0596r.d("MiLiSensorData", "get UUID_CHARACTERISTIC_SENSOR_DATA return null!!!");
            a((int) b);
            return;
        }
        this.l = new PipedInputStream();
        this.m = new PipedOutputStream();
        try {
            this.m.connect(this.l);
            if (this.o.b(this.p, this)) {
                p x = this.o.x();
                C0596r.d("MiLiSensorData", "LEParams:" + x);
                if (x != null) {
                    if (x.e <= 60) {
                        C0596r.d("MiLiSensorData", "LEParams fit sensor data transfer~~~");
                    } else if (!this.o.a(39, 49, (int) a, (int) a.aB, a)) {
                        C0596r.d("MiLiSensorData", "_setLEParams failed!!!");
                        a((int) b);
                        return;
                    }
                    if (this.o.c(true)) {
                        this.n = true;
                        d();
                        this.r.sendEmptyMessageDelayed(c, d.g);
                        a((int) a);
                        return;
                    }
                    C0596r.d("MiLiSensorData", "enableGetSensorData failed!!!");
                    a((int) b);
                    return;
                }
                C0596r.d("MiLiSensorData", "_getLEParams failed!!!");
                a((int) b);
                return;
            }
            C0596r.d("MiLiSensorData", "registerNotification failed!!!");
            a((int) b);
        } catch (IOException e) {
            C0596r.d("MiLiSensorData", "m_SensorSourceOutputStream connect m_SensorSourceInputStream failed!!!");
            a((int) b);
        }
    }

    private void a(int i) {
        Message message = new Message();
        message.what = d;
        message.arg1 = i;
        this.r.sendMessage(message);
    }

    private void a(f fVar) {
        while (this.n) {
            try {
                int read = this.l.read();
                int read2 = this.l.read();
                int read3 = this.l.read();
                int read4 = this.l.read();
                read |= read2 << 8;
                short s = (short) (((read & 4095) << 20) >> 20);
                short s2 = (short) (((((read4 << 8) | read3) & 4095) << 20) >> 20);
                short read5 = (short) (((((this.l.read() << 8) | this.l.read()) & 4095) << 20) >> 20);
                if (this.n && fVar != null) {
                    fVar.a(s, s2, read5);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void b() {
        this.n = false;
        this.r.removeMessages(c);
        if (this.o != null) {
            this.o.c(false);
        }
        if (!(this.p == null || this.o == null)) {
            this.o.c(this.p);
        }
        try {
            if (this.l != null) {
                this.l.close();
            }
            if (this.m != null) {
                this.m.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        a((int) c);
    }

    private void c() {
        if (this.o == null || !this.o.E()) {
            C0596r.d("MiLiSensorData", "Send watchdog failed as profile is null or _sync failed!!!");
        }
    }

    private void d() {
        new Thread(new q(this)).start();
    }

    public void a(boolean z, f fVar) {
        this.q = fVar;
        if (z) {
            this.r.sendEmptyMessage(a);
        } else {
            this.r.sendEmptyMessage(b);
        }
    }

    public void a(byte[] bArr) {
        C0596r.e("MiLiSensorData", y.b(bArr));
        try {
            int i = (bArr[a] & HeartRateInfo.HR_EMPTY_VALUE) | ((bArr[b] & HeartRateInfo.HR_EMPTY_VALUE) << 8);
            C0596r.e("MiLiSensorData", "index:" + i + ",mLastSensorDataIndex:" + this.k);
            if (i == android.support.v4.e.a.a.a) {
                C0596r.d("MiLiSensorData", "sensor data notify packages index is -1 !!!");
                a((int) e);
                throw new RuntimeException("sensor data notify packages index is -1 !!!");
            }
            if (!((this.k == z.j && i == 0) || this.k + b == i)) {
                C0596r.d("MiLiSensorData", "sensor data notify packages index is not continuous!!!");
            }
            this.k = i;
            Object obj = new byte[(bArr.length - 2)];
            System.arraycopy(bArr, c, obj, a, bArr.length - 2);
            this.m.write(obj);
        } catch (IOException e) {
            C0596r.d("MiLiSensorData", e.getMessage());
        }
    }
}
