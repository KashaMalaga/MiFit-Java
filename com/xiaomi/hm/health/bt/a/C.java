package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.profile.a.j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class C implements Runnable {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    private static ExecutorService c = Executors.newFixedThreadPool(5);
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 2;
    public static String p = "BleTask";
    protected d o = null;
    protected j q = null;

    public C(d dVar) {
        this.o = dVar;
        this.q = a.a();
    }

    public C(j jVar, d dVar) {
        this.o = dVar;
        this.q = jVar;
    }

    public abstract void a(d dVar);

    public void f() {
        a.execute(this);
    }

    public void g() {
        c.execute(this);
    }

    public void h() {
        b.execute(this);
    }

    public void run() {
        C0596r.d(p, "BleTask Run..........................................in:" + getClass().getName());
        if (this.q != null && this.q.v()) {
            a(this.o);
        } else if (this.o != null) {
            this.o.d(Boolean.valueOf(false));
        }
        C0596r.d(p, "BleTask Run..........................................out:" + getClass().getName());
    }
}
