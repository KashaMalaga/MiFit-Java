package cn.com.smartdevices.bracelet.chart.b;

import android.util.SparseArray;

public class d {
    protected f a;
    protected SparseArray<e> b = new SparseArray();
    protected boolean c;

    public void a(int i) {
        this.c = false;
        e b = this.a.b(i);
        b.g = i;
        this.b.put(i, b);
        if (!this.c) {
            this.a.a(b);
        }
    }

    public void a(int i, e eVar) {
        this.b.put(i, eVar);
    }

    public void a(f fVar) {
        this.a = fVar;
    }

    public boolean a() {
        return this.c;
    }

    public e b(int i) {
        return (e) this.b.get(i);
    }

    public void b() {
        this.c = true;
    }

    public void c() {
        this.b.clear();
    }

    public boolean c(int i) {
        return this.a.a(i);
    }

    public f d() {
        return this.a;
    }

    public void d(int i) {
        this.a.c(i);
    }
}
