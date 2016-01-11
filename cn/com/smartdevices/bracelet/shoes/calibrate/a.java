package cn.com.smartdevices.bracelet.shoes.calibrate;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.c.d;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.sync.C0632i;
import com.xiaomi.mipush.sdk.f;

public class a {
    private static final String a = "CalibrateInTransfer";
    private static final int b = 500;
    private static final int c = 300;
    private static final int d = 1;
    private ShoesCalibrate e;
    private volatile boolean f = false;
    private C0632i g;
    private Context h;
    private e i;
    private d j;
    private b k = b.UNKNOWN;

    private void a(String str) {
        C0596r.e(a, str);
    }

    private void d() {
        C0596r.e(a, "use fake calibrate data");
        for (int i = 0; i < c; i += d) {
            this.j.a(new c((short) 1, (short) 2, (short) 3));
        }
    }

    private void e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("native calibrate result: brand = ").append(this.i.e).append(" subModel = ").append(this.i.f).append(" macAddress = ").append(this.i.g()).append(" Theta = ").append(this.e.getTheta()).append(" Phi = ").append(this.e.getPhi()).append(" Psi = ").append(this.e.getPsi());
        C0596r.e(a, stringBuilder.toString());
        double c = d.c(this.e.getTheta());
        double c2 = d.c(this.e.getPhi());
        double c3 = d.c(this.e.getPsi());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Theta:").append(c).append(f.i).append("Phi:").append(c2).append(f.i).append("Psi:").append(c3);
        t.a(this.h, this.i.e(), stringBuilder2.toString());
    }

    private void f() {
        this.f = true;
        this.k = b.UNKNOWN;
        if (this.j == null) {
            this.j = new d(this, b);
        }
        C0596r.e(a, "clear sample data");
        this.j.a();
        if (this.e == null) {
            this.e = new ShoesCalibrate();
        }
    }

    public void a() {
        if (this.f) {
            this.g.n();
        }
    }

    public void a(int i) {
        if (!this.f) {
            if (i == 0) {
                a("START_SENSOR_DATA_OK");
            } else if (i == d) {
                a("START_SENSOR_DATA_FAILED");
            } else if (i == 2) {
                a("STOP_SENSOR_DATA_OK");
            } else if (i == 3) {
                a("STOP_SENSOR_DATA_FAILED");
            } else if (i == 4) {
                a("TRANSFER_SENSOR_DATA_ERROR");
            } else {
                a("UNKNOWN_STATUS");
            }
        }
    }

    public void a(c cVar) {
        if (this.f && !this.j.a(cVar)) {
            a("the collected data is full");
            c();
        }
    }

    public void a(com.xiaomi.hm.health.bt.d.f fVar, e eVar, Context context, C0632i c0632i) {
        this.i = eVar;
        this.h = context;
        this.g = c0632i;
        f();
        this.g.a(fVar);
    }

    public b b() {
        return this.k;
    }

    public void c() {
        if (this.k != b.UNKNOWN) {
            C0596r.e(a, "the calibrate result was generated");
            return;
        }
        this.f = false;
        a("STOP TRANSFER");
        this.g.n();
        if (this.j.b() >= c) {
            a("the collected data is enough, length = " + this.j.b());
            if (this.e.receiveSamples(this.j.c(), this.j.d(), this.j.e(), this.j.b()) == d) {
                a("native calibrate success");
                this.k = b.SUCCESS;
                e();
                return;
            }
            a("native calibrate fail");
            this.k = b.FAIL;
            return;
        }
        a("the collected data is NOT enough, length = " + this.j.b());
        this.k = b.FAIL;
    }
}
