package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.HandlerThread;

public class A {
    static final int a = 1;
    static final int b = 0;
    private static final int g = 25;
    private static final int h = 1000;
    private SensorManager c = null;
    private E d = null;
    private final int e = g;
    private final int f = 40000;
    private int i = b;
    private C j = null;
    private D k = null;

    public A(Context context, C c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        a(c);
        HandlerThread handlerThread = new HandlerThread("gsensor");
        handlerThread.start();
        this.k = new D(this, context, handlerThread.getLooper());
        this.d = new E();
        this.c = (SensorManager) context.getSystemService("sensor");
        this.c.registerListener(this.d, this.c.getDefaultSensor(a), 40000);
    }

    private void a(C c) {
        this.j = c;
    }

    private void c() {
        this.j = null;
    }

    public void a() {
        c();
        if (this.k != null) {
            this.k.a();
        }
        if (this.d != null && this.c != null) {
            this.c.unregisterListener(this.d);
        }
    }

    public int b() {
        return this.i;
    }
}
