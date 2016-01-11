package com.amap.api.mapcore;

import android.os.Handler;

class ba implements ag {
    final Handler a = new bb(this);
    private t b;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private boolean h = true;
    private boolean i = true;
    private boolean j = false;
    private int k = 0;
    private int l = 1;

    ba(t tVar) {
        this.b = tVar;
    }

    public void a(int i) {
        this.k = i;
        this.b.d(i);
    }

    public void a(boolean z) {
        this.j = z;
        this.a.obtainMessage(1).sendToTarget();
    }

    public boolean a() {
        return this.j;
    }

    public void b(int i) {
        this.l = i;
        this.b.e(i);
    }

    public void b(boolean z) {
        this.h = z;
        this.a.obtainMessage(0).sendToTarget();
    }

    public boolean b() {
        return this.h;
    }

    public void c(boolean z) {
        this.i = z;
        this.a.obtainMessage(2).sendToTarget();
    }

    public boolean c() {
        return this.i;
    }

    public void d(boolean z) {
        this.f = z;
        this.a.obtainMessage(3).sendToTarget();
    }

    public boolean d() {
        return this.f;
    }

    public void e(boolean z) {
        this.d = z;
    }

    public boolean e() {
        return this.d;
    }

    public void f(boolean z) {
        this.g = z;
    }

    public boolean f() {
        return this.g;
    }

    public void g(boolean z) {
        this.e = z;
    }

    public boolean g() {
        return this.e;
    }

    public void h(boolean z) {
        this.c = z;
    }

    public boolean h() {
        return this.c;
    }

    public int i() {
        return this.k;
    }

    public void i(boolean z) {
        h(z);
        g(z);
        f(z);
        e(z);
    }

    public int j() {
        return this.l;
    }
}
