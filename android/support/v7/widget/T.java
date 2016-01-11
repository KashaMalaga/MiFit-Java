package android.support.v7.widget;

class T implements S {
    final /* synthetic */ RecyclerView a;

    private T(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(aj ajVar) {
        ajVar.a(true);
        if (!this.a.h(ajVar.a) && ajVar.s()) {
            this.a.removeDetachedView(ajVar.a, false);
        }
    }

    public void b(aj ajVar) {
        ajVar.a(true);
        if (ajVar.u()) {
            this.a.h(ajVar.a);
        }
    }

    public void c(aj ajVar) {
        ajVar.a(true);
        if (ajVar.u()) {
            this.a.h(ajVar.a);
        }
    }

    public void d(aj ajVar) {
        ajVar.a(true);
        if (ajVar.g != null && ajVar.h == null) {
            ajVar.g = null;
            ajVar.a(-65, ajVar.r);
        }
        ajVar.h = null;
        if (ajVar.u()) {
            this.a.h(ajVar.a);
        }
    }
}
