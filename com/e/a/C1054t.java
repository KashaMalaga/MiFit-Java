package com.e.a;

class C1054t extends C1051q {
    Object d;

    C1054t(float f, Object obj) {
        this.a = f;
        this.d = obj;
        this.c = obj != null;
        this.b = this.c ? obj.getClass() : Object.class;
    }

    public void a(Object obj) {
        this.d = obj;
        this.c = obj != null;
    }

    public Object b() {
        return this.d;
    }

    public /* synthetic */ C1051q f() {
        return g();
    }

    public C1054t g() {
        C1054t c1054t = new C1054t(c(), this.d);
        c1054t.a(d());
        return c1054t;
    }
}
