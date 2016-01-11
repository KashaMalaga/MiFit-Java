package cn.com.smartdevices.bracelet.gps.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import android.support.v4.content.v;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.a.a;
import cn.com.smartdevices.bracelet.gps.algorithm.GPSManager;
import cn.com.smartdevices.bracelet.gps.g.i;

public class SubGPSSportService extends Service {
    static final String a = "RService";
    static final String b = "Run";
    private final au c = new au();
    private X d = null;
    private C0464x e = null;
    private as f = null;
    private F g = null;
    private at h = null;
    private C0456o i = null;
    private Context j = null;
    private GPSManager k = null;
    private WakeLock l = null;
    private aw m = null;
    private av n = null;
    private boolean o = false;
    private i p = null;

    private C0456o a(long j) {
        return new C0456o(this.j, j, this.e);
    }

    private void a() {
        if (this.h != null && this.g != null) {
            this.g.b();
            this.g.a();
        }
    }

    private void a(i iVar) {
        this.p = iVar;
    }

    private void b() {
        this.h = new at(this, 1);
        this.g = new F(this, true);
        this.g.a(this.h);
    }

    private void c() {
        if (this.k == null) {
            this.k = new GPSManager(a.d(".MISportLab").getAbsolutePath());
        }
    }

    private void d() {
        this.n = new av();
        v.a(this.j).a(this.n, this.n.a());
    }

    private void e() {
        this.m = new aw();
        registerReceiver(this.m, this.m.a());
    }

    private void f() {
        if (this.n != null) {
            v.a(this.j).a(this.n);
            this.n = null;
        }
    }

    private void g() {
        if (this.m != null) {
            unregisterReceiver(this.m);
            this.m = null;
        }
    }

    public IBinder onBind(Intent intent) {
        C0596r.e(a, " onBind ");
        if (this.f == null) {
            this.f = new as();
        }
        this.c.removeMessages(3);
        this.c.sendEmptyMessage(3);
        return this.f;
    }

    public void onCreate() {
        this.j = getApplicationContext();
        this.e = new C0464x();
        this.d = new X(this.e);
        b();
        C0596r.e(a, " onCreate ");
    }

    public void onDestroy() {
        if (this.c != null) {
            this.c.a();
        }
        if (this.e != null) {
            this.e.b();
        }
        a();
        if (this.l != null && this.l.isHeld()) {
            this.l.release();
        }
        if (this.i != null) {
            this.i.b();
        }
        super.onDestroy();
        C0596r.e(a, " onDestroy ");
    }
}
