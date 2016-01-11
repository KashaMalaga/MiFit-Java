package android.support.v4.app;

class Y implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ U c;

    Y(U u, int i, int i2) {
        this.c = u;
        this.a = i;
        this.b = i2;
    }

    public void run() {
        this.c.a(this.c.u.d, null, this.a, this.b);
    }
}
