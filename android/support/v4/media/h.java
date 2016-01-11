package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.v4.view.A;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;
import com.c.b.h.a;
import java.util.ArrayList;

public class h extends g {
    public static final int i = 126;
    public static final int j = 127;
    public static final int k = 130;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 4;
    public static final int o = 8;
    public static final int p = 16;
    public static final int q = 32;
    public static final int r = 64;
    public static final int s = 128;
    final Context a;
    final q b;
    final AudioManager c;
    final View d;
    final Object e;
    final l f;
    final ArrayList<r> g;
    final k h;
    final Callback t;

    public h(Activity activity, q qVar) {
        this(activity, null, qVar);
    }

    private h(Activity activity, View view, q qVar) {
        this.g = new ArrayList();
        this.h = new i(this);
        this.t = new j(this);
        this.a = activity != null ? activity : view.getContext();
        this.b = qVar;
        this.c = (AudioManager) this.a.getSystemService("audio");
        if (activity != null) {
            view = activity.getWindow().getDecorView();
        }
        this.d = view;
        this.e = A.a(this.d);
        if (VERSION.SDK_INT >= 18) {
            this.f = new l(this.a, this.c, this.d, this.h);
        } else {
            this.f = null;
        }
    }

    public h(View view, q qVar) {
        this(null, view, qVar);
    }

    static boolean a(int i) {
        switch (i) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case a.d /*90*/:
            case 91:
            case i /*126*/:
            case j /*127*/:
            case k /*130*/:
                return true;
            default:
                return false;
        }
    }

    private r[] l() {
        if (this.g.size() <= 0) {
            return null;
        }
        r[] rVarArr = new r[this.g.size()];
        this.g.toArray(rVarArr);
        return rVarArr;
    }

    private void m() {
        r[] l = l();
        if (l != null) {
            int length = l.length;
            for (int i = 0; i < length; i += l) {
                l[i].a(this);
            }
        }
    }

    private void n() {
        r[] l = l();
        if (l != null) {
            int length = l.length;
            for (int i = 0; i < length; i += l) {
                l[i].b(this);
            }
        }
    }

    private void o() {
        if (this.f != null) {
            this.f.a(this.b.f(), this.b.e(), this.b.h());
        }
    }

    public void a() {
        if (this.f != null) {
            this.f.f();
        }
        this.b.a();
        o();
        m();
    }

    public void a(long j) {
        this.b.a(j);
    }

    public void a(r rVar) {
        this.g.add(rVar);
    }

    public boolean a(KeyEvent keyEvent) {
        return A.a(keyEvent, this.t, this.e, this);
    }

    public void b() {
        if (this.f != null) {
            this.f.g();
        }
        this.b.b();
        o();
        m();
    }

    public void b(r rVar) {
        this.g.remove(rVar);
    }

    public void c() {
        if (this.f != null) {
            this.f.h();
        }
        this.b.c();
        o();
        m();
    }

    public long d() {
        return this.b.d();
    }

    public long e() {
        return this.b.e();
    }

    public boolean f() {
        return this.b.f();
    }

    public int g() {
        return this.b.g();
    }

    public int h() {
        return this.b.h();
    }

    public Object i() {
        return this.f != null ? this.f.a() : null;
    }

    public void j() {
        o();
        m();
        n();
    }

    public void k() {
        this.f.b();
    }
}
