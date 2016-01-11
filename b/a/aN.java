package b.a;

class aN extends dl<aK> {
    private aN() {
    }

    public void a(cY cYVar, aK aKVar) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(aKVar.a);
        c0372df.a(aKVar.b);
        c0372df.a(aKVar.c);
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (aK) cqVar);
    }

    public void b(cY cYVar, aK aKVar) {
        C0372df c0372df = (C0372df) cYVar;
        aKVar.a = c0372df.y();
        aKVar.a(true);
        aKVar.b = c0372df.y();
        aKVar.b(true);
        aKVar.c = c0372df.x();
        aKVar.c(true);
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (aK) cqVar);
    }
}
