package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class C0053bk implements C0014aY {
    private static final int A = 16;
    private static final int B = 1;
    private static final int C = 8388613;
    private static final int D = 80;
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 0;
    public static final int i = -1;
    private static final String j = "android.wearable.EXTENSIONS";
    private static final String k = "actions";
    private static final String l = "flags";
    private static final String m = "displayIntent";
    private static final String n = "pages";
    private static final String o = "background";
    private static final String p = "contentIcon";
    private static final String q = "contentIconGravity";
    private static final String r = "contentActionIndex";
    private static final String s = "customSizePreset";
    private static final String t = "customContentHeight";
    private static final String u = "gravity";
    private static final String v = "hintScreenTimeout";
    private static final int w = 1;
    private static final int x = 2;
    private static final int y = 4;
    private static final int z = 8;
    private ArrayList<aM> E = new ArrayList();
    private int F = w;
    private PendingIntent G;
    private ArrayList<Notification> H = new ArrayList();
    private Bitmap I;
    private int J;
    private int K = C;
    private int L = i;
    private int M = h;
    private int N;
    private int O = D;
    private int P;

    public C0053bk(Notification notification) {
        Bundle a = aK.a(notification);
        Bundle bundle = a != null ? a.getBundle(j) : null;
        if (bundle != null) {
            aM[] a2 = aK.ai.a(bundle.getParcelableArrayList(k));
            if (a2 != null) {
                Collections.addAll(this.E, a2);
            }
            this.F = bundle.getInt(l, w);
            this.G = (PendingIntent) bundle.getParcelable(m);
            Notification[] a3 = aK.b(bundle, n);
            if (a3 != null) {
                Collections.addAll(this.H, a3);
            }
            this.I = (Bitmap) bundle.getParcelable(o);
            this.J = bundle.getInt(p);
            this.K = bundle.getInt(q, C);
            this.L = bundle.getInt(r, i);
            this.M = bundle.getInt(s, h);
            this.N = bundle.getInt(t);
            this.O = bundle.getInt(u, D);
            this.P = bundle.getInt(v);
        }
    }

    private void a(int i, boolean z) {
        if (z) {
            this.F |= i;
        } else {
            this.F &= i ^ i;
        }
    }

    public aT a(aT aTVar) {
        Bundle bundle = new Bundle();
        if (!this.E.isEmpty()) {
            bundle.putParcelableArrayList(k, aK.ai.a((aM[]) this.E.toArray(new aM[this.E.size()])));
        }
        if (this.F != w) {
            bundle.putInt(l, this.F);
        }
        if (this.G != null) {
            bundle.putParcelable(m, this.G);
        }
        if (!this.H.isEmpty()) {
            bundle.putParcelableArray(n, (Parcelable[]) this.H.toArray(new Notification[this.H.size()]));
        }
        if (this.I != null) {
            bundle.putParcelable(o, this.I);
        }
        if (this.J != 0) {
            bundle.putInt(p, this.J);
        }
        if (this.K != C) {
            bundle.putInt(q, this.K);
        }
        if (this.L != i) {
            bundle.putInt(r, this.L);
        }
        if (this.M != 0) {
            bundle.putInt(s, this.M);
        }
        if (this.N != 0) {
            bundle.putInt(t, this.N);
        }
        if (this.O != D) {
            bundle.putInt(u, this.O);
        }
        if (this.P != 0) {
            bundle.putInt(v, this.P);
        }
        aTVar.a().putBundle(j, bundle);
        return aTVar;
    }

    public C0053bk a() {
        C0053bk c0053bk = new C0053bk();
        c0053bk.E = new ArrayList(this.E);
        c0053bk.F = this.F;
        c0053bk.G = this.G;
        c0053bk.H = new ArrayList(this.H);
        c0053bk.I = this.I;
        c0053bk.J = this.J;
        c0053bk.K = this.K;
        c0053bk.L = this.L;
        c0053bk.M = this.M;
        c0053bk.N = this.N;
        c0053bk.O = this.O;
        c0053bk.P = this.P;
        return c0053bk;
    }

    public C0053bk a(int i) {
        this.J = i;
        return this;
    }

    public C0053bk a(Notification notification) {
        this.H.add(notification);
        return this;
    }

    public C0053bk a(PendingIntent pendingIntent) {
        this.G = pendingIntent;
        return this;
    }

    public C0053bk a(Bitmap bitmap) {
        this.I = bitmap;
        return this;
    }

    public C0053bk a(aM aMVar) {
        this.E.add(aMVar);
        return this;
    }

    public C0053bk a(List<aM> list) {
        this.E.addAll(list);
        return this;
    }

    public C0053bk a(boolean z) {
        a(z, z);
        return this;
    }

    public C0053bk b() {
        this.E.clear();
        return this;
    }

    public C0053bk b(int i) {
        this.K = i;
        return this;
    }

    public C0053bk b(List<Notification> list) {
        this.H.addAll(list);
        return this;
    }

    public C0053bk b(boolean z) {
        a(w, z);
        return this;
    }

    public C0053bk c(int i) {
        this.L = i;
        return this;
    }

    public C0053bk c(boolean z) {
        a(x, z);
        return this;
    }

    public List<aM> c() {
        return this.E;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public PendingIntent d() {
        return this.G;
    }

    public C0053bk d(int i) {
        this.O = i;
        return this;
    }

    public C0053bk d(boolean z) {
        a(y, z);
        return this;
    }

    public C0053bk e() {
        this.H.clear();
        return this;
    }

    public C0053bk e(int i) {
        this.M = i;
        return this;
    }

    public C0053bk e(boolean z) {
        a(A, z);
        return this;
    }

    public C0053bk f(int i) {
        this.N = i;
        return this;
    }

    public List<Notification> f() {
        return this.H;
    }

    public Bitmap g() {
        return this.I;
    }

    public C0053bk g(int i) {
        this.P = i;
        return this;
    }

    public int h() {
        return this.J;
    }

    public int i() {
        return this.K;
    }

    public int j() {
        return this.L;
    }

    public int k() {
        return this.O;
    }

    public int l() {
        return this.M;
    }

    public int m() {
        return this.N;
    }

    public boolean n() {
        return (this.F & z) != 0;
    }

    public boolean o() {
        return (this.F & w) != 0;
    }

    public boolean p() {
        return (this.F & x) != 0;
    }

    public boolean q() {
        return (this.F & y) != 0;
    }

    public boolean r() {
        return (this.F & A) != 0;
    }

    public int s() {
        return this.P;
    }
}
