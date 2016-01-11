package android.support.v7.widget;

import android.support.v4.l.a;
import android.util.SparseArray;

public class ag {
    a<aj, V> a = new a();
    a<aj, V> b = new a();
    a<Long, aj> c = new a();
    int d = 0;
    private int e = -1;
    private SparseArray<Object> f;
    private int g = 0;
    private int h = 0;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    static /* synthetic */ int a(ag agVar, int i) {
        int i2 = agVar.h + i;
        agVar.h = i2;
        return i2;
    }

    private void a(a<Long, aj> aVar, aj ajVar) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (ajVar == aVar.c(size)) {
                aVar.d(size);
                return;
            }
        }
    }

    ag a() {
        this.e = -1;
        if (this.f != null) {
            this.f.clear();
        }
        this.d = 0;
        this.i = false;
        return this;
    }

    public void a(int i) {
        if (this.f != null) {
            this.f.remove(i);
        }
    }

    public void a(int i, Object obj) {
        if (this.f == null) {
            this.f = new SparseArray();
        }
        this.f.put(i, obj);
    }

    public void a(aj ajVar) {
        this.a.remove(ajVar);
        this.b.remove(ajVar);
        if (this.c != null) {
            a(this.c, ajVar);
        }
    }

    public <T> T b(int i) {
        return this.f == null ? null : this.f.get(i);
    }

    public void b(aj ajVar) {
        a(ajVar);
    }

    public boolean b() {
        return this.j;
    }

    public boolean c() {
        return this.l;
    }

    public boolean d() {
        return this.k;
    }

    public int e() {
        return this.e;
    }

    public boolean f() {
        return this.e != -1;
    }

    public boolean g() {
        return this.i;
    }

    public int h() {
        return this.j ? this.g - this.h : this.d;
    }

    public String toString() {
        return "State{mTargetPosition=" + this.e + ", mPreLayoutHolderMap=" + this.a + ", mPostLayoutHolderMap=" + this.b + ", mData=" + this.f + ", mItemCount=" + this.d + ", mPreviousLayoutItemCount=" + this.g + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.h + ", mStructureChanged=" + this.i + ", mInPreLayout=" + this.j + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
    }
}
