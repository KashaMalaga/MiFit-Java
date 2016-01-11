package com.e.a;

import java.util.ArrayList;

class C1044k implements Cloneable {
    public C1034a a;
    public ArrayList<C1042i> b = null;
    public ArrayList<C1042i> c = null;
    public ArrayList<C1044k> d = null;
    public ArrayList<C1044k> e = null;
    public boolean f = false;

    public C1044k(C1034a c1034a) {
        this.a = c1034a;
    }

    public C1044k a() {
        try {
            C1044k c1044k = (C1044k) super.clone();
            c1044k.a = this.a.i();
            return c1044k;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void a(C1042i c1042i) {
        if (this.b == null) {
            this.b = new ArrayList();
            this.d = new ArrayList();
        }
        this.b.add(c1042i);
        if (!this.d.contains(c1042i.c)) {
            this.d.add(c1042i.c);
        }
        C1044k c1044k = c1042i.c;
        if (c1044k.e == null) {
            c1044k.e = new ArrayList();
        }
        c1044k.e.add(this);
    }

    public /* synthetic */ Object clone() {
        return a();
    }
}
