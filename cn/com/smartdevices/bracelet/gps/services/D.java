package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;

final class D extends Handler {
    static final int a = 1;
    final /* synthetic */ A b;
    private Looper c = null;
    private final int d = 25;
    private final int e = 10;
    private final int f = 5;
    private final int g = 6;
    private final double[] h = new double[25];
    private final double[] i = new double[25];
    private final double[] j = new double[25];
    private final double[] k = new double[10];
    private final double[] l = new double[10];
    private final double[] m = new double[10];
    private int n = 0;
    private int o = 0;

    public D(A a, Context context, Looper looper) {
        this.b = a;
        super(looper);
        this.c = looper;
    }

    private boolean b() {
        if (this.o % 25 != 0) {
            return false;
        }
        int i;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        for (i = 0; i < 25; i += a) {
            d2 += this.h[i];
            d += this.h[i] * this.h[i];
            d4 += this.i[i];
            d3 += this.i[i] * this.i[i];
            d6 += this.j[i];
            d5 += this.j[i] * this.j[i];
        }
        double sqrt = Math.sqrt((d / 25.0d) - ((d2 / 25.0d) * (d2 / 25.0d)));
        d4 = Math.sqrt((d3 / 25.0d) - ((d4 / 25.0d) * (d4 / 25.0d)));
        d6 = Math.sqrt((d5 / 25.0d) - ((d6 / 25.0d) * (d6 / 25.0d)));
        this.k[this.n % 10] = sqrt;
        this.l[this.n % 10] = d4;
        double[] dArr = this.m;
        int i2 = this.n;
        this.n = i2 + a;
        dArr[i2 % 10] = d6;
        int b = this.b.i;
        i = 0;
        i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < 10) {
            if (this.k[i4] > 0.03d && this.l[i4] > 0.03d && this.m[i4] > 0.05d) {
                i3 += a;
            } else if (this.k[i4] > 0.02d && this.l[i4] > 0.02d && this.m[i4] > 0.03d) {
                i2 += a;
            } else if (this.k[i4] < 0.01d || this.l[i4] < 0.01d || this.m[i4] < 0.01d) {
                i += a;
            }
            i4 += a;
        }
        if (i3 == 0 && i2 == 0 && i == 0) {
            return false;
        }
        if (i3 >= 6) {
            if (i3 + i2 == 10) {
                i = a;
            }
            i = b;
        } else {
            if (i2 >= 6 || i >= 5) {
                i = 0;
            }
            i = b;
        }
        if (i == this.b.i) {
            return false;
        }
        this.b.i = i;
        return true;
    }

    public void a() {
        if (this.c != null) {
            this.c.quit();
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a /*1*/:
                if (message.obj != null && (message.obj instanceof SensorEvent)) {
                    try {
                        SensorEvent sensorEvent = (SensorEvent) message.obj;
                        this.h[this.o % 25] = (double) (sensorEvent.values[0] / 9.80665f);
                        this.i[this.o % 25] = (double) (sensorEvent.values[a] / 9.80665f);
                        double[] dArr = this.j;
                        int i = this.o;
                        this.o = i + a;
                        dArr[i % 25] = (double) (sensorEvent.values[2] / 9.80665f);
                        if (b() && this.b.j != null) {
                            this.b.j.a(this.b.i);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        C0596r.e("Gsensor", e.getMessage());
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
