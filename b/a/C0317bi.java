package b.a;

class C0317bi extends dl<C0314bf> {
    private C0317bi() {
    }

    public void a(cY cYVar, C0314bf c0314bf) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(c0314bf.a);
        c0372df.a(c0314bf.b);
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0314bf) cqVar);
    }

    public void b(cY cYVar, C0314bf c0314bf) {
        C0372df c0372df = (C0372df) cYVar;
        c0314bf.a = c0372df.w();
        c0314bf.a(true);
        c0314bf.b = c0372df.w();
        c0314bf.b(true);
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0314bf) cqVar);
    }
}
