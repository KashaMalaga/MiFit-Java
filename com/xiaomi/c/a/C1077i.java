package com.xiaomi.c.a;

final class C1077i {
    private final H a;
    private final J b;
    private final I c;
    private final F d;
    private final C e;
    private final G f;
    private final B g;
    private final y h;
    private final D i;
    private final z j;
    private final C1069A k;
    private final boolean l;

    private C1077i(H h, J j, I i, F f, C c, G g, B b, y yVar, D d, z zVar, C1069A c1069a, boolean z) {
        this.a = h;
        this.b = j;
        this.c = i;
        this.d = f;
        this.e = c;
        this.f = g;
        this.g = b;
        this.h = yVar;
        this.i = d;
        this.j = zVar;
        this.k = c1069a;
        this.l = z;
    }

    static C1077i a(C1078u c1078u, C1078u c1078u2) {
        z a = z.a(c1078u2.a(K.c));
        boolean z = a != null && ((String) a.a()).equals(c1078u.a(K.q));
        return new C1077i(H.a(C1077i.a(c1078u2, K.t)), J.a(C1077i.a(c1078u2, K.z)), I.a(c1078u2.a(K.y)), F.a(c1078u2.a(K.n)), C.a(c1078u2.a(K.i)), G.a(c1078u2.a(K.p)), B.a(c1078u2.a(K.h)), y.a(c1078u2.a(K.a)), D.a(c1078u2.a(K.k)), a, C1069A.a(c1078u2.a(K.d)), z);
    }

    private static String a(C1078u c1078u, C1076h c1076h) {
        String a = c1078u.a(c1076h);
        if (a != null) {
            return a;
        }
        throw new C1070b("Connection Manager session creation response did not include required '" + c1076h.b() + "' attribute");
    }

    H a() {
        return this.a;
    }

    J b() {
        return this.b;
    }

    I c() {
        return this.c;
    }

    F d() {
        return this.d;
    }

    D e() {
        return this.i;
    }

    boolean f() {
        return this.l;
    }
}
