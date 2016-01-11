package b.a;

import android.support.v4.g.c;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class C0281a {
    private final int a = 10;
    private final int b = 20;
    private final String c;
    private List<C0282aa> d;
    private C0288ag e;

    public C0281a(String str) {
        this.c = str;
    }

    private boolean g() {
        C0288ag c0288ag = this.e;
        String c = c0288ag == null ? null : c0288ag.c();
        int j = c0288ag == null ? 0 : c0288ag.j();
        String a = a(f());
        if (a == null || a.equals(c)) {
            return false;
        }
        if (c0288ag == null) {
            c0288ag = new C0288ag();
        }
        c0288ag.a(a);
        c0288ag.a(System.currentTimeMillis());
        c0288ag.a(j + 1);
        C0282aa c0282aa = new C0282aa();
        c0282aa.a(this.c);
        c0282aa.c(a);
        c0282aa.b(c);
        c0282aa.a(c0288ag.f());
        if (this.d == null) {
            this.d = new ArrayList(2);
        }
        this.d.add(c0282aa);
        if (this.d.size() > 10) {
            this.d.remove(0);
        }
        this.e = c0288ag;
        return true;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        return (trim.length() == 0 || Constants.VIA_RESULT_SUCCESS.equals(trim) || c.a.equals(trim.toLowerCase(Locale.US))) ? null : trim;
    }

    public void a(C0288ag c0288ag) {
        this.e = c0288ag;
    }

    public void a(C0294am c0294am) {
        this.e = (C0288ag) c0294am.d().get("mName");
        List<C0282aa> j = c0294am.j();
        if (j != null && j.size() > 0) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            for (C0282aa c0282aa : j) {
                if (this.c.equals(c0282aa.a)) {
                    this.d.add(c0282aa);
                }
            }
        }
    }

    public void a(List<C0282aa> list) {
        this.d = list;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.e == null || this.e.j() <= 20;
    }

    public C0288ag d() {
        return this.e;
    }

    public List<C0282aa> e() {
        return this.d;
    }

    public abstract String f();
}
