package b.a;

import android.content.Context;
import android.text.TextUtils;
import com.g.a.B;
import com.g.a.C1059a;
import com.g.a.b.f;
import com.g.a.j;
import com.g.a.k;
import com.g.a.m;
import com.g.a.n;
import com.g.a.o;
import com.g.a.p;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public final class dw implements dE, f {
    private dG a = null;
    private dH b = null;
    private n c = null;
    private B d = null;
    private dM e = null;
    private C0368da f = null;
    private int g = 10;
    private Context h;

    public dw(Context context) {
        this.h = context;
        this.a = new dG(context);
        this.f = du.a(context);
        this.e = new dM(context);
        this.b = new dH(context);
        this.b.a(this.e);
        this.d = B.a(context);
        int[] c = C1059a.c(this.h);
        a(c[0], c[1]);
    }

    private bE a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            cq bEVar = new bE();
            new C0360cv().a(bEVar, bArr);
            return bEVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(int i, int i2) {
        switch (i) {
            case a.i /*0*/:
                this.c = new n();
                break;
            case l.a /*1*/:
                this.c = new j();
                break;
            case a.aQ /*4*/:
                this.c = new m(this.e);
                break;
            case a.X /*5*/:
                this.c = new o(this.h);
                break;
            case a.bt /*6*/:
                this.c = new k(this.e, (long) i2);
                break;
            case a.bc /*7*/:
                this.c = new com.g.a.l(this.a, i2);
                break;
            default:
                this.c = new j();
                break;
        }
        bX.c(p.e, "report policy:" + i + " interval:" + i2);
    }

    private boolean a(boolean z) {
        if (bW.l(this.h)) {
            return !this.e.b() ? (bX.a && bW.w(this.h)) ? true : this.c.a(z) : true;
        } else {
            if (bX.a) {
                bX.c(p.e, "network is unavailable");
            }
            return false;
        }
    }

    private byte[] a(bE bEVar) {
        try {
            return new cB().a(bEVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean d() {
        return this.a.b() > this.g;
    }

    private void e() {
        try {
            if (this.e.b()) {
                this.a.a(new C0383i(this.e.j()));
            }
            f();
        } catch (Throwable th) {
            boolean z = th instanceof OutOfMemoryError;
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    private void f() {
        byte[] d;
        B a = B.a(this.h);
        boolean f = a.f();
        if (f) {
            d = a.d();
        } else {
            this.f.a();
            d = c();
            if (d == null) {
                bX.e(p.e, "message is null");
                return;
            } else {
                d = C0356cr.a(this.h, C1059a.a(this.h), d).c();
                a.c();
            }
        }
        switch (this.b.a(d)) {
            case l.a /*1*/:
                if (!f) {
                    a.b(d);
                }
                bX.b(p.e, "connection error");
                return;
            case a.k /*2*/:
                if (this.e.i()) {
                    this.e.h();
                }
                this.f.d();
                this.e.g();
                if (f) {
                    a.e();
                    return;
                }
                return;
            case a.l /*3*/:
                this.e.g();
                if (f) {
                    a.e();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a() {
        if (bW.l(this.h)) {
            e();
        } else if (bX.a) {
            bX.c(p.e, "network is unavailable");
        }
    }

    public void a(int i, long j) {
        C1059a.a(i, (int) j);
        a(i, (int) j);
    }

    public void a(dF dFVar) {
        if (dFVar != null) {
            this.a.a(dFVar);
        }
        if (a(dFVar instanceof C0327bs)) {
            e();
        } else if (d()) {
            b();
        }
    }

    public void b() {
        if (this.a.b() > 0) {
            try {
                byte[] c = c();
                if (c != null) {
                    this.d.a(c);
                }
            } catch (Throwable th) {
                if (th instanceof OutOfMemoryError) {
                    this.d.c();
                }
                if (th != null) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void b(dF dFVar) {
        this.a.a(dFVar);
    }

    protected byte[] c() {
        if (TextUtils.isEmpty(C1059a.a(this.h))) {
            bX.b(p.e, "Appkey is missing ,Please check AndroidManifest.xml");
            return null;
        }
        byte[] b = B.a(this.h).b();
        bE a = b == null ? null : a(b);
        if (a == null && this.a.b() == 0) {
            return null;
        }
        bE bEVar = a == null ? new bE() : a;
        this.a.a(bEVar);
        if (bX.a && bEVar.B()) {
            Object obj = null;
            for (C0327bs p : bEVar.z()) {
                try {
                    if (p.p() > 0) {
                        obj = 1;
                    }
                } catch (Exception e) {
                    bX.b(p.e, "Fail to construct message ...", e);
                    B.a(this.h).c();
                    return null;
                }
            }
            if (obj == null) {
                bX.e(p.e, "missing Activities or PageViews");
            }
        }
        try {
            b = a(bEVar);
            try {
                if (!bX.a) {
                    return b;
                }
                bX.c(p.e, bEVar.toString());
                return b;
            } catch (Exception e2) {
                bX.b(p.e, "Fail to serialize log ...");
                return b;
            }
        } catch (Exception e3) {
            b = null;
            bX.b(p.e, "Fail to serialize log ...");
            return b;
        }
    }
}
