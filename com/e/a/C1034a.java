package com.e.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class C1034a implements Cloneable {
    ArrayList<C1035b> a = null;

    public void a() {
    }

    public abstract void a(long j);

    public abstract void a(Interpolator interpolator);

    public void a(C1035b c1035b) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(c1035b);
    }

    public void a(Object obj) {
    }

    public abstract C1034a b(long j);

    public void b() {
    }

    public void b(C1035b c1035b) {
        if (this.a != null) {
            this.a.remove(c1035b);
            if (this.a.size() == 0) {
                this.a = null;
            }
        }
    }

    public abstract long c();

    public /* synthetic */ Object clone() {
        return i();
    }

    public abstract long d();

    public abstract boolean e();

    public boolean f() {
        return e();
    }

    public ArrayList<C1035b> g() {
        return this.a;
    }

    public void h() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }

    public C1034a i() {
        try {
            C1034a c1034a = (C1034a) super.clone();
            if (this.a != null) {
                ArrayList arrayList = this.a;
                c1034a.a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    c1034a.a.add((C1035b) arrayList.get(i));
                }
            }
            return c1034a;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void start() {
    }
}
