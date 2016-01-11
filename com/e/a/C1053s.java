package com.e.a;

class C1053s extends C1051q {
    int d;

    C1053s(float f) {
        this.a = f;
        this.b = Integer.TYPE;
    }

    C1053s(float f, int i) {
        this.a = f;
        this.d = i;
        this.b = Integer.TYPE;
        this.c = true;
    }

    public void a(Object obj) {
        if (obj != null && obj.getClass() == Integer.class) {
            this.d = ((Integer) obj).intValue();
            this.c = true;
        }
    }

    public Object b() {
        return Integer.valueOf(this.d);
    }

    public /* synthetic */ C1051q f() {
        return h();
    }

    public int g() {
        return this.d;
    }

    public C1053s h() {
        C1053s c1053s = new C1053s(c(), this.d);
        c1053s.a(d());
        return c1053s;
    }
}
