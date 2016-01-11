package b.a;

class C0336cF extends dl<cC> {
    private C0336cF() {
    }

    public void a(cY cYVar, cC cCVar) {
        cCVar.c = null;
        cCVar.b = null;
        short v = cYVar.v();
        cCVar.b = cCVar.a(cYVar, v);
        if (cCVar.b != null) {
            cCVar.c = cCVar.b(v);
        }
    }

    public void b(cY cYVar, cC cCVar) {
        if (cCVar.j() == null || cCVar.k() == null) {
            throw new C0340cZ("Cannot write a TUnion with no set value!");
        }
        cYVar.a(cCVar.c.a());
        cCVar.d(cYVar);
    }
}
