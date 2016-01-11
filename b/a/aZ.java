package b.a;

class aZ extends dl<aW> {
    private aZ() {
    }

    public void a(cY cYVar, aW aWVar) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(aWVar.a);
        c0372df.a(aWVar.b);
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (aW) cqVar);
    }

    public void b(cY cYVar, aW aWVar) {
        C0372df c0372df = (C0372df) cYVar;
        aWVar.a = c0372df.z();
        aWVar.a(true);
        aWVar.b = c0372df.x();
        aWVar.b(true);
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (aW) cqVar);
    }
}
