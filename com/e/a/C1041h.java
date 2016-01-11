package com.e.a;

public class C1041h {
    final /* synthetic */ C1038e a;
    private C1044k b;

    C1041h(C1038e c1038e, C1034a c1034a) {
        this.a = c1038e;
        this.b = (C1044k) c1038e.d.get(c1034a);
        if (this.b == null) {
            this.b = new C1044k(c1034a);
            c1038e.d.put(c1034a, this.b);
            c1038e.e.add(this.b);
        }
    }

    public C1041h a(long j) {
        C1034a b = R.b(0.0f, 1.0f);
        b.d(j);
        c(b);
        return this;
    }

    public C1041h a(C1034a c1034a) {
        C1044k c1044k = (C1044k) this.a.d.get(c1034a);
        if (c1044k == null) {
            c1044k = new C1044k(c1034a);
            this.a.d.put(c1034a, c1044k);
            this.a.e.add(c1044k);
        }
        c1044k.a(new C1042i(this.b, 0));
        return this;
    }

    public C1041h b(C1034a c1034a) {
        C1044k c1044k = (C1044k) this.a.d.get(c1034a);
        if (c1044k == null) {
            c1044k = new C1044k(c1034a);
            this.a.d.put(c1034a, c1044k);
            this.a.e.add(c1044k);
        }
        c1044k.a(new C1042i(this.b, 1));
        return this;
    }

    public C1041h c(C1034a c1034a) {
        C1044k c1044k = (C1044k) this.a.d.get(c1034a);
        if (c1044k == null) {
            c1044k = new C1044k(c1034a);
            this.a.d.put(c1034a, c1044k);
            this.a.e.add(c1044k);
        }
        this.b.a(new C1042i(c1044k, 1));
        return this;
    }
}
