package kankan.wheel.widget;

class q implements o {
    final /* synthetic */ WheelView a;

    q(WheelView wheelView) {
        this.a = wheelView;
    }

    public void a() {
        this.a.o = true;
        this.a.c();
    }

    public void a(int i) {
        this.a.f(i);
        int height = this.a.getHeight();
        if (this.a.p > height) {
            this.a.p = height;
            this.a.n.a();
        } else if (this.a.p < (-height)) {
            this.a.p = -height;
            this.a.n.a();
        }
    }

    public void b() {
        if (this.a.o) {
            this.a.d();
            this.a.o = false;
        }
        this.a.p = 0;
        this.a.invalidate();
    }

    public void c() {
        if (Math.abs(this.a.p) > 1) {
            this.a.n.a(this.a.p, 0);
        }
    }
}
