package b.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.g.a.C1059a;
import com.g.a.C1060b;
import com.g.a.p;
import com.xiaomi.e.a;
import java.util.ArrayList;
import java.util.List;

public class dG {
    private List<dF> a = new ArrayList();
    private C0383i b = null;
    private C0389o c = null;
    private A d = null;
    private aQ e = null;
    private Context f = null;

    public dG(Context context) {
        this.f = context;
    }

    private void a(Context context) {
        try {
            this.c.a(C1059a.a(context));
            this.c.e(C1059a.b(context));
            if (!(C1059a.a == null || C1059a.b == null)) {
                this.c.f(C1059a.a);
                this.c.g(C1059a.b);
            }
            this.c.c(bW.u(context));
            this.c.a(C0326br.ANDROID);
            this.c.d(p.c);
            this.c.b(bW.d(context));
            this.c.a(Integer.parseInt(bW.c(context)));
            if (C1059a.c == 1) {
                this.c.c(C1059a.c);
                this.c.d(p.d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(Context context) {
        try {
            this.d.f(bW.a());
            this.d.a(bW.f(context));
            this.d.b(bW.g(context));
            this.d.c(bW.p(context));
            this.d.e(Build.MODEL);
            this.d.g(p.b);
            this.d.h(VERSION.RELEASE);
            int[] r = bW.r(context);
            if (r != null) {
                this.d.a(new C0314bf(r[1], r[0]));
            }
            if (C1059a.e != null) {
                String str = C1059a.d;
            }
            this.d.i(Build.BOARD);
            this.d.j(Build.BRAND);
            this.d.a(Build.TIME);
            this.d.k(Build.MANUFACTURER);
            this.d.l(Build.ID);
            this.d.m(Build.DEVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(Context context) {
        try {
            String[] j = bW.j(context);
            if (bW.d.equals(j[0])) {
                this.e.a(C0382h.ACCESS_TYPE_WIFI);
            } else if (bW.c.equals(j[0])) {
                this.e.a(C0382h.ACCESS_TYPE_2G_3G);
            } else {
                this.e.a(C0382h.ACCESS_TYPE_UNKNOWN);
            }
            if (!a.f.equals(j[1])) {
                this.e.e(j[1]);
            }
            this.e.c(bW.s(context));
            j = bW.n(context);
            this.e.b(j[0]);
            this.e.a(j[1]);
            this.e.a(bW.m(context));
            if (C1059a.g != 0 || C1059a.f != null || C1059a.h != null || C1059a.i != null) {
                bK bKVar = new bK();
                bKVar.a(C1059a.g);
                bKVar.a(C1060b.a(C1059a.f));
                bKVar.a(C1059a.h);
                bKVar.b(C1059a.i);
                this.e.a(bKVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String i() {
        return C0366dK.a(this.f).getString("session_id", null);
    }

    public Context a() {
        return this.f;
    }

    public void a(bE bEVar) {
        String i = i();
        if (i != null) {
            synchronized (this) {
                for (dF a : this.a) {
                    a.a(bEVar, i);
                }
                this.a.clear();
                if (this.b != null) {
                    bEVar.a(this.b);
                    this.b = null;
                }
            }
            bEVar.a(c());
            bEVar.a(d());
            bEVar.a(e());
            bEVar.a(h());
            bEVar.a(f());
            bEVar.a(g());
        }
    }

    public synchronized void a(dF dFVar) {
        this.a.add(dFVar);
    }

    public synchronized void a(C0383i c0383i) {
        this.b = c0383i;
    }

    protected boolean a(int i) {
        return true;
    }

    public synchronized int b() {
        int size;
        size = this.a.size();
        if (this.b != null) {
            size++;
        }
        return size;
    }

    public synchronized C0389o c() {
        if (this.c == null) {
            this.c = new C0389o();
            a(this.f);
        }
        return this.c;
    }

    public synchronized A d() {
        if (this.d == null) {
            this.d = new A();
            b(this.f);
        }
        return this.d;
    }

    public synchronized aQ e() {
        if (this.e == null) {
            this.e = new aQ();
            c(this.f);
        }
        return this.e;
    }

    public C0300as f() {
        try {
            return du.b(this.f).a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C0294am g() {
        try {
            return du.a(this.f).b();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C0395u h() {
        try {
            return dM.a(this.f);
        } catch (Exception e) {
            e.printStackTrace();
            return new C0395u();
        }
    }
}
