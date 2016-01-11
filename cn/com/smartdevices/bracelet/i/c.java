package cn.com.smartdevices.bracelet.i;

import cn.com.smartdevices.bracelet.C0596r;

public class c {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 6;
    private static final int e = 10;
    private static final int f = 18;
    private static final int g = 38;
    private int h = a;
    private a i;
    private int j;
    private String k;

    public void a() {
        this.h = d;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(a aVar) {
        this.h = f;
        this.i = aVar;
    }

    public void a(String str) {
        this.k = str;
    }

    public void a(boolean z) {
        if (z) {
            a();
        } else {
            b();
        }
    }

    public void b() {
        this.h = e;
    }

    public void b(String str) {
        if (e()) {
            C0596r.e(str, "State -> Idle...");
        } else if (f()) {
            C0596r.e(str, "State -> Start...");
        } else if (!g()) {
        } else {
            if (h()) {
                C0596r.e(str, "State -> Finish : Success!!");
            } else if (i()) {
                C0596r.e(str, "State -> Finish : Failure!!");
            } else if (j()) {
                C0596r.a(str, "State -> Finish : Exception!!", this.i);
            } else if (k()) {
                C0596r.e(str, "State -> Finish : Passon!!");
            }
        }
    }

    public void c() {
        this.h = g;
    }

    public void d() {
        a(new a(a));
    }

    public boolean e() {
        return this.h == 0;
    }

    public boolean f() {
        return (this.h & b) == b;
    }

    public boolean g() {
        return (this.h & c) == c;
    }

    public boolean h() {
        return (this.h & d) == d;
    }

    public boolean i() {
        return (this.h & e) == e;
    }

    public boolean j() {
        return (this.h & f) == f;
    }

    public boolean k() {
        return (this.h & g) == g;
    }

    public a l() {
        return this.i;
    }

    public int m() {
        return this.j;
    }

    public String n() {
        return this.k;
    }
}
