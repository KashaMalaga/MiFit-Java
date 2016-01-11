package android.support.v7.widget;

import android.view.ViewGroup;

public abstract class N<VH extends aj> {
    private final O a = new O();
    private boolean b = false;

    public abstract int a();

    public int a(int i) {
        return 0;
    }

    public abstract VH a(ViewGroup viewGroup, int i);

    public final void a(int i, int i2) {
        this.a.a(i, i2);
    }

    public void a(P p) {
        this.a.registerObserver(p);
    }

    public void a(RecyclerView recyclerView) {
    }

    public void a(VH vh) {
    }

    public abstract void a(VH vh, int i);

    public void a(boolean z) {
        if (c()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.b = z;
    }

    public long b(int i) {
        return -1;
    }

    public final VH b(ViewGroup viewGroup, int i) {
        VH a = a(viewGroup, i);
        a.e = i;
        return a;
    }

    public final void b(int i, int i2) {
        this.a.d(i, i2);
    }

    public void b(P p) {
        this.a.unregisterObserver(p);
    }

    public void b(RecyclerView recyclerView) {
    }

    public void b(VH vh) {
    }

    public final void b(VH vh, int i) {
        vh.b = i;
        if (b()) {
            vh.d = b(i);
        }
        a((aj) vh, i);
        vh.a(1, 7);
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(int i) {
        this.a.a(i, 1);
    }

    public final void c(int i, int i2) {
        this.a.b(i, i2);
    }

    public void c(VH vh) {
    }

    public final boolean c() {
        return this.a.a();
    }

    public final void d() {
        this.a.b();
    }

    public final void d(int i) {
        this.a.b(i, 1);
    }

    public final void d(int i, int i2) {
        this.a.c(i, i2);
    }

    public final void e(int i) {
        this.a.c(i, 1);
    }
}
