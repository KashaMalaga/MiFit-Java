package com.e.a;

class C1043j implements C1035b {
    private C1038e a;
    private C1044k b;
    private int c;

    public C1043j(C1038e c1038e, C1044k c1044k, int i) {
        this.a = c1038e;
        this.b = c1044k;
        this.c = i;
    }

    private void e(C1034a c1034a) {
        if (!this.a.b) {
            int size = this.b.c.size();
            for (int i = 0; i < size; i++) {
                C1042i c1042i = (C1042i) this.b.c.get(i);
                if (c1042i.d == this.c && c1042i.c.a == c1034a) {
                    c1034a.b((C1035b) this);
                    break;
                }
            }
            Object obj = null;
            this.b.c.remove(obj);
            if (this.b.c.size() == 0) {
                this.b.a.start();
                this.a.c.add(this.b.a);
            }
        }
    }

    public void a(C1034a c1034a) {
        if (this.c == 0) {
            e(c1034a);
        }
    }

    public void b(C1034a c1034a) {
        if (this.c == 1) {
            e(c1034a);
        }
    }

    public void c(C1034a c1034a) {
    }

    public void d(C1034a c1034a) {
    }
}
