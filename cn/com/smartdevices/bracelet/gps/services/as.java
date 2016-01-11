package cn.com.smartdevices.bracelet.gps.services;

import android.location.Location;
import android.os.Binder;
import android.os.PowerManager;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.algorithm.TrackStatistics;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.a.b;
import cn.com.smartdevices.bracelet.gps.services.a.d;
import cn.com.smartdevices.bracelet.gps.services.b.m;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.xiaomi.e.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

final class as extends Binder implements d {
    final /* synthetic */ SubGPSSportService a;

    private as(SubGPSSportService subGPSSportService) {
        this.a = subGPSSportService;
    }

    private void g(long j) {
        m.b(this.a);
        this.a.l = ((PowerManager) this.a.j.getSystemService("power")).newWakeLock(1, "GPS");
        if (this.a.l != null) {
            this.a.l.acquire();
        }
        this.a.i = this.a.a(j);
        this.a.i.a(new ax(this.a, null));
        this.a.a(this.a.i.a());
        this.a.e();
        this.a.d();
    }

    public int a(int i) {
        return -1;
    }

    public int a(long j) {
        if (this.a.i != null) {
            int d = this.a.i.d();
            C0596r.d("RService", "getSportState state = " + d);
            return d;
        }
        C0596r.d("RService", "getSportState DEFUALT");
        return -1;
    }

    public int a(c cVar, ArrayList<c> arrayList) {
        this.a.c();
        return this.a.k.receivePoint(cVar, false, arrayList);
    }

    public long a(b bVar, int i) {
        g(-1);
        return this.a.i.f();
    }

    public Location a() {
        return null;
    }

    public void a(TrackStatistics trackStatistics) {
        this.a.k.recoverFromCrash("Running", a.f, trackStatistics);
    }

    public void a(cn.com.smartdevices.bracelet.gps.services.a.a aVar) {
        this.a.e.a(aVar);
    }

    public void a(b bVar) {
        this.a.e.a(bVar);
    }

    public int b() {
        return this.a.g != null ? this.a.g.c() : -1;
    }

    public az b(long j) {
        return this.a.i != null ? this.a.i.a(j) : null;
    }

    public void b(cn.com.smartdevices.bracelet.gps.services.a.a aVar) {
        this.a.e.b(aVar);
    }

    public void b(b bVar) {
    }

    public int c() {
        return this.a.d == null ? C0463w.DEFAULT.a() : this.a.d.a();
    }

    public int c(long j) {
        if (this.a.i == null) {
            return -1;
        }
        int g = this.a.i.g();
        C0596r.d("RService", "getUserOpState state = " + g);
        return g;
    }

    public void c(b bVar) {
    }

    public TrackStatistics d() {
        this.a.c();
        return this.a.k.getTrackParameter(false);
    }

    public void d(long j) {
        e.a("RService", "pauseSport");
        if (this.a.i != null) {
            this.a.i.b(true);
        }
    }

    public void d(b bVar) {
        this.a.e.b(bVar);
    }

    public long e() {
        return this.a.i == null ? 0 : this.a.i.e();
    }

    public void e(long j) {
        e.a("RService", "resumeSport");
        if (this.a.i != null) {
            this.a.i.c(true);
        }
    }

    public long f() {
        long f = this.a.i == null ? -1 : this.a.i.f();
        C0596r.d("RService", "getTrackId trackId = " + f);
        return f;
    }

    public void f(long j) {
        e.a("RService", "stopSport");
        if (this.a.d != null) {
            this.a.d.b();
        }
        if (this.a.i != null) {
            this.a.i.k();
            this.a.i = null;
        }
        if (this.a.l != null && this.a.l.isHeld()) {
            this.a.l.release();
        }
        this.a.g();
        this.a.f();
        m.a(this.a);
    }

    public void g() {
        if (this.a.i != null) {
            this.a.i.i();
        }
    }

    public void h() {
        this.a.c();
        this.a.k.cleanStorage();
    }

    public ArrayList<c> i() {
        this.a.c();
        return this.a.k.end(true);
    }

    public File j() {
        this.a.c();
        return this.a.k.getAllNormFile();
    }

    public float k() {
        this.a.c();
        return this.a.k.getDistance();
    }

    public int l() {
        this.a.c();
        return this.a.k.getAllFileLength();
    }

    public File m() {
        this.a.c();
        return this.a.k.getTestFile();
    }

    public void n() {
        this.a.c();
        this.a.k.start("Running", a.f);
    }

    public int o() {
        try {
            this.a.c();
            return this.a.k.test();
        } catch (IOException e) {
            C0596r.a(GeocodeSearch.GPS, e.getMessage());
            throw e;
        }
    }
}
