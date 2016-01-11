package com.e.a;

class C1052r extends C1051q {
    float d;

    C1052r(float f) {
        this.a = f;
        this.b = Float.TYPE;
    }

    C1052r(float f, float f2) {
        this.a = f;
        this.d = f2;
        this.b = Float.TYPE;
        this.c = true;
    }

    public void a(Object obj) {
        if (obj != null && obj.getClass() == Float.class) {
            this.d = ((Float) obj).floatValue();
            this.c = true;
        }
    }

    public Object b() {
        return Float.valueOf(this.d);
    }

    public /* synthetic */ C1051q f() {
        return h();
    }

    public float g() {
        return this.d;
    }

    public C1052r h() {
        C1052r c1052r = new C1052r(c(), this.d);
        c1052r.a(d());
        return c1052r;
    }
}
