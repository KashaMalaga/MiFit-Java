package android.support.v7.widget;

class ap {
    int a;
    int b;
    boolean c;
    boolean d;
    final /* synthetic */ StaggeredGridLayoutManager e;

    private ap(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.e = staggeredGridLayoutManager;
    }

    void a() {
        this.a = -1;
        this.b = af.a;
        this.c = false;
        this.d = false;
    }

    void a(int i) {
        if (this.c) {
            this.b = this.e.g.d() - i;
        } else {
            this.b = this.e.g.c() + i;
        }
    }

    void b() {
        this.b = this.c ? this.e.g.d() : this.e.g.c();
    }
}
